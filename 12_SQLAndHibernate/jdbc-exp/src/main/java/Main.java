import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите пароль");

        HashMap<String, ArrayList<Integer>> purchaseMonthMap = new HashMap<>();

        try {
            Connector sqlConnection = new Connector();
            Statement statement = sqlConnection.getConnection();
            ResultSet resultSet = statement.executeQuery("SELECT pl.course_name, MONTH(pl.subscription_date) FROM PurchaseList pl ORDER BY pl.course_name");
            ArrayList<Integer> monthsList = new ArrayList<>();
            String nameCourse = null;
            while(resultSet.next()) {
                if(nameCourse == null) {
                    monthsList.add(resultSet.getInt("MONTH(pl.subscription_date)"));
                    nameCourse = resultSet.getString("course_name");
                    continue;
                }
                if(resultSet.getString("course_name").equals(nameCourse)) {
                    monthsList.add(resultSet.getInt("MONTH(pl.subscription_date)"));
                } else {
                    ArrayList<Integer> monthsListAll = new ArrayList<>(monthsList);
                    Collections.sort(monthsListAll);
                    purchaseMonthMap.put(nameCourse, monthsListAll);
                    monthsList.clear();
                    monthsList.add(resultSet.getInt("MONTH(pl.subscription_date)"));
                    nameCourse = null;
                    continue;
                }
                nameCourse = resultSet.getString("course_name");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        getStatistics(purchaseMonthMap);
    }

    public static void getStatistics(HashMap<String, ArrayList<Integer>> purchaseMap) {
        for(Map.Entry<String, ArrayList<Integer>> entry : purchaseMap.entrySet()) {
            System.out.println("Курс: " + entry.getKey());
            double range = (entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0)) + 1;
            double avg = entry.getValue().size() / range;
            String formattedDouble = new DecimalFormat("#0.00").format(avg);
            System.out.println("Продажи = " + formattedDouble);
        }
    }
}