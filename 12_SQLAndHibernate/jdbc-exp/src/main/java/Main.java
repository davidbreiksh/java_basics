import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select course_name ,\n" +
                    "subscription_date ,\n" +
                    "count(month(subscription_date)),\n" +
                    "sum(month(subscription_date)),\n" +
                    "avg(month(subscription_date))\n" +
                    "from purchaselist\n" +
                    "where subscription_date>'2018-01-01' and subscription_date<'2018-12-31'\n" +
                    "group by course_name\n" +
                    "order by course_name");

            while (resultSet.next()) {

                System.out.print(resultSet.getString("course_name"));
                System.out.println(" " + resultSet.getDouble("avg(month(subscription_date))"));
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}