import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        final String path = "D:\\skillbox\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementList.csv";

        Movements movements = new Movements(path);

        movements.getExpenseSum();

    }
}