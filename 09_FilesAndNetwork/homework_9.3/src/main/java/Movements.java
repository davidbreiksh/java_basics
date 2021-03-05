import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Movements {


    private final Map<String, Double> organizations = new HashMap<>();

    private final String path;
    private final CSVReader reader;

    double sum = 0;
    String[] column;

    public Movements(String pathMovementsCsv, CSVReader reader) throws IOException, CsvValidationException {
        this.path = pathMovementsCsv;
        this.reader = reader;
    }

    public double getExpenseSum() throws IOException, CsvValidationException {

        while ((column = reader.readNext()) != null) {
            column[7] = column[7].replaceAll("\"", "");
            column[7] = column[7].replaceAll(",", ".");
            double expenseSum = Double.parseDouble(column[7]);
            sum += expenseSum;
        }
        System.out.println(sum);
        return sum;
    }

    public double getIncomeSum() throws IOException, CsvValidationException {

        while ((column = reader.readNext()) != null) {
            column[6] = column[6].replaceAll("\"", "");
            column[6] = column[6].replaceAll(",", ".");
            double incomeSum = Double.parseDouble(column[6]);
            sum += incomeSum;
        }
        System.out.println(sum);
        return sum;
    }

    public void getExpenseByOrganization() throws IOException, CsvValidationException {

        String[] column;

        double expense = 0;

        while ((column = reader.readNext()) != null) {
            column[7] = column[7].replaceAll("\"", "");
            column[7] = column[7].replaceAll(",", ".");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < column.length; i++) {
                sb.append(column[i]);
            }
            String org = sb.toString();

            String[] row1 = org.trim().split(" {3,}");
            String[] row2 = row1[1].split("/");
            String[] row3 = row2[row2.length - 1].split("\\\\");

            String organization = row3[row3.length - 1];

            expense = Double.parseDouble(column[7]);

            if (!organizations.containsKey(organization))
                organizations.put(organization, expense);
            else {
                double sum = organizations.get(organization);
                sum += expense;
                organizations.put(organization.trim(), sum);
            }
        }
    }
}