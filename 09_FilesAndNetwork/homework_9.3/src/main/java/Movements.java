import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Movements {

    final String path = "C:\\Users\\david\\IdeaProjects\\homework_9.3\\src\\test\\resources\\movementList.csv";

    String line = "";
    double sum = 0;

    public Movements(String pathMovementsCsv) {

    }

    public double getExpenseSum() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        reader.readLine();

        while ((line = reader.readLine()) != null) {

            String[] expense = line.split(",");

            //if (expense[6].matches("\\d+\\.\\d+"))

                double sumExpense = Integer.parseInt(expense[7].replace("\"", ""));

                sum = sum + sumExpense;

        }
        System.out.println("Общий расход " + sum + " рублей");
        return sum;
    }

    public double getIncomeSum() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] expense = line.split(",");

            double sumExpense = Double.parseDouble(expense[6].replace("\"", ""));

            sum = sum + sumExpense;

        }
        System.out.println("Общий доход " + sum + " рублей");
        return sum;
    }
}