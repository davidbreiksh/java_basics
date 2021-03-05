import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Movements {

    private final Map<String, Double> organizations = new HashMap<>();

    private final String path;

    double sum = 0;

    public Movements(String pathMovementsCsv) {
        this.path = pathMovementsCsv;
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

    public void getExpenseByOrganization() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(1).build();

        String[] columns;

        double expense = 0;

        while ((columns = reader.readNext()) != null) {
            columns[7] = columns[7].replaceAll("\"", "");
            columns[7] = columns[7].replaceAll(",", ".");


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < columns.length; i++) {
                sb.append(columns[i]);
            }
            String org = sb.toString();

            String[] row1 = org.trim().split(" {3,}");
            String[] temp1 = row1[1].split("/");
            String[] suppliesTemp1 = temp1[temp1.length - 1].split("\\\\");

            String organization = suppliesTemp1[suppliesTemp1.length - 1];

            expense = Double.parseDouble(columns[7]);

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