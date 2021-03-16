import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Movement {

    private final double amount;
    private final String organization;
    private final Direction direction;

    public double getAmount() {
        return amount;
    }

    public String getOrganization() {
        return organization;
    }

    public Direction getDirection() {
        return direction;
    }

    public Movement(double amount, String organization, Direction direction) {
        this.amount = amount;
        this.organization = organization;
        this.direction = direction;
    }
}

class Movements {

    private final List<Movement> movements = new ArrayList();

    private final int INCOME_INDEX = 6;
    private final int EXPENSE_INDEX = 7;

    private final String path;

    public Movements(String pathMovementsCsv) throws IOException, CsvValidationException {
        this.path = pathMovementsCsv;
    }

    public Movement buildMovement(String[] data) throws IOException, CsvValidationException {
        double income = Double.parseDouble(data[INCOME_INDEX]);
        double expense = Double.parseDouble(data[EXPENSE_INDEX]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
        }
        String org = sb.toString();

        String[] row1 = org.trim().split(" {3,}");
        String[] row2 = row1[1].split("/");
        String[] row3 = row2[row2.length - 1].split("\\\\");

        String organization = row3[row3.length - 1];
        organization = organization.replaceAll("\\d", "");

        if (income - expense > 0) {
            return new Movement(income, organization, Direction.INCOME);
        }
        return new Movement(expense, organization, Direction.EXPENSE);
    }

    public List<Movement> readMovementFile(String filePath) throws IOException, CsvValidationException {
        String[] column;
        CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build();

        while ((column = reader.readNext()) != null) {
            column[EXPENSE_INDEX] = column[EXPENSE_INDEX].replaceAll("\"", "");
            column[EXPENSE_INDEX] = column[EXPENSE_INDEX].replaceAll(",", ".");
            column[INCOME_INDEX] = column[INCOME_INDEX].replaceAll("\"", "");
            column[INCOME_INDEX] = column[INCOME_INDEX].replaceAll(",", ".");

            Movement movement = buildMovement(column);

            movements.add(movement);
        }
        return movements;
    }

    public double getExpenseSum() throws IOException, CsvValidationException {
        double sum = 0;

        if (movements.isEmpty()) {
            readMovementFile(path);
            sum = movements.stream().filter(m -> m.getDirection() == Direction.EXPENSE)
                    .mapToDouble(Movement::getAmount).sum();
            System.out.println(sum + " рублей");
        }
        return sum;
    }

    public double getIncomeSum() throws IOException, CsvValidationException {
        double sum = 0;

        if (movements.isEmpty()) {
            readMovementFile(path);
            sum = movements.stream().filter(m -> m.getDirection() == Direction.INCOME)
                    .mapToDouble(Movement::getAmount).sum();
            System.out.println(sum + " рублей");
        }
        return sum;
    }

    public Map<String, Double> getExpenseByOrganization() throws IOException, CsvValidationException {
        Map<String, Double> expByOrg = null;
        if (movements.isEmpty()) {
            readMovementFile(path);
            expByOrg = movements.stream()
                    .filter(m -> m.getDirection() == Direction.EXPENSE)
                    .collect(Collectors.groupingBy(Movement::getOrganization,
                            Collectors.summingDouble(Movement::getAmount)));
        }
        for (Map.Entry<String, Double> entry : expByOrg.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString() + " " + "рублей");
        }
        return expByOrg;
    }
}