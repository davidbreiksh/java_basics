import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();


        System.out.println(date);

        airport.getTerminals().forEach(t -> t.getFlights().stream()
                .filter(f-> f.getType() == Flight.Type.DEPARTURE)
                .filter(f -> f.getDate().getTime() - System.currentTimeMillis() <= 7200000)
                .filter(f -> f.getDate().getTime() - System.currentTimeMillis() > 0).forEach(System.out::println));
    }
}