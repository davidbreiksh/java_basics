import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Файл test/resources/movementListInteger.csv (значения целые)")
public class TestMovementListInteger {

    private static final double DELTA = 0.01;
    private static final String CSV_FILENAME = "movementListInteger.csv";
    CSVReader reader;

    @Test
    @DisplayName("Сумма прихода")
    void testSumIncome() throws IOException, CsvValidationException {
        assertEquals(1500.0, new Movements(getCsvFilenamePath(), reader).getIncomeSum(), DELTA);
    }

    @Test
    @DisplayName("Сумма расходов")
    void testSumExpense() throws IOException, CsvValidationException {
        assertEquals(300.0, new Movements(getCsvFilenamePath(), reader).getExpenseSum(), DELTA);
    }

    private String getCsvFilenamePath() {
        return this.getClass().getResource(CSV_FILENAME).getPath();
    }

}