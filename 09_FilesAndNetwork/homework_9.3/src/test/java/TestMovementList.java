import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Файл test/resources/movementList.csv")
public class TestMovementList {

    private static final double DELTA = 0.01;
    private static final String CSV_FILENAME = "movementList.csv";


    @Test
    @DisplayName("Сумма прихода")
    void testSumIncome() throws IOException, CsvValidationException {
        assertEquals(460_800.0, new Movements(getCsvFilenamePath()).getIncomeSum(), DELTA);
    }

    @Test
    @DisplayName("Сумма расходов")
    void testSumExpense() throws IOException, CsvValidationException {
        assertEquals(466_393.07, new Movements(getCsvFilenamePath()).getExpenseSum(), DELTA);
    }

    private String getCsvFilenamePath() {
        return this.getClass().getResource(CSV_FILENAME).getPath();
    }

}