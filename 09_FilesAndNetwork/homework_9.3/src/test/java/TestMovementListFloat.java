import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Файл test/resources/movementListFloat.csv (значения прихода/расхода не целые")
public class TestMovementListFloat {

    private static final double DELTA = 0.01;
    private static final String CSV_FILENAME = "movementListFloat.csv";
    CSVReader reader;


    @Test
    @DisplayName("Сумма прихода")
    void testSumIncome() throws IOException, CsvValidationException {
        assertEquals(1500.5, new Movements(getCsvFilenamePath(), reader).getIncomeSum(), DELTA);
    }

    @Test
    @DisplayName("Сумма расходов")
    void testSumExpense() throws IOException, CsvValidationException {
        assertEquals(300.03, new Movements(getCsvFilenamePath(), reader).getExpenseSum(), DELTA);
    }

    private String getCsvFilenamePath() {
        return this.getClass().getResource(CSV_FILENAME).getPath();
    }

}