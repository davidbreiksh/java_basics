import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        final String path = "D:\\skillbox\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementList.csv";

        Movements movements = new Movements(path);

        movements.getExpenseByOrganization();

    }
}