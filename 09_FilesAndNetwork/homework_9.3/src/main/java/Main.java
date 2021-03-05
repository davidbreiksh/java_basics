import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import net.sf.saxon.expr.Component;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException {

        final String path = "D:\\skillbox\\java_basics\\09_FilesAndNetwork\\homework_9.3\\src\\test\\resources\\movementList.csv";

        CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(1).build();

        Movements movements = new Movements(path);

       // movements.getExpenseSum();
       // movements.getIncomeSum();
        movements.getExpenseByOrganization();

    }
}