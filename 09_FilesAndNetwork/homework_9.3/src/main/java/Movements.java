import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Movements {

    final String path = "C:\\Users\\david\\IdeaProjects\\homework_9.3\\src\\test\\resources\\movementList.csv";

    String line = "";
    double sum = 0;
    String expenseColumn;

    public Movements(String pathMovementsCsv) {

    }

    public double getExpenseSum() throws IOException, CsvValidationException {

        CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(1).build();

        String[] columns;

        while ((columns = reader.readNext()) != null) {
            columns[7] = columns[7].replaceAll("\"", "");
            columns[7] = columns[7].replaceAll(",", ".");
            double sumExpense = Double.parseDouble(columns[7]);
            sum += sumExpense;
        }
        System.out.println("Общий расход " + sum + " рублей");
        return sum;
    }


    public double getIncomeSum() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(1).build();

        String[] columns;

        while ((columns = reader.readNext()) != null) {
            columns[6] = columns[6].replaceAll("\"", "");
            columns[6] = columns[6].replaceAll(",", ".");
            double sumExpense = Double.parseDouble(columns[6]);
            sum += sumExpense;
        }
        System.out.println("Общий расход " + sum + " рублей");
        return sum;
    }
}