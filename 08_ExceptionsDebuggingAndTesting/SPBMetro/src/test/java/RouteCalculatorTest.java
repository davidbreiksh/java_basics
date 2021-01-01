import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    List<Station> secondRoute;
    RouteCalculator calc;
    List<Station> connections;
    List<Station> connectionsTwo;
    List<Station> connectionsThree;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        secondRoute = new ArrayList<>();
        connections = new ArrayList<>();
        connectionsTwo = new ArrayList<>();
        connectionsThree = new ArrayList<>();
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(new Station("Шоколадная", line1));
        stationIndex.addStation(new Station("Конфетная", line1));
        stationIndex.addStation(new Station("Куриная", line2));
        stationIndex.addStation(new Station("Говяжья", line2));
        stationIndex.addStation(new Station("Клубничная", line3));
        stationIndex.addStation(new Station("Вишневая", line3));

        connections.add(stationIndex.getStation("Шоколадная", 1));
        connections.add(stationIndex.getStation("Говяжья", 2));

        connectionsTwo.add(stationIndex.getStation("Конфетная" , 1));
        connectionsTwo.add(stationIndex.getStation("Клубничная", 3));

        connectionsThree.add(stationIndex.getStation("Куриная" , 2));
        connectionsThree.add(stationIndex.getStation("Вишневая" , 3));

        stationIndex.addConnection(connections);
        stationIndex.addConnection(connectionsTwo);
        stationIndex.addConnection(connectionsThree);

        secondRoute.add(stationIndex.getStation("Шоколадная", 1));
        // secondRoute.add(stationIndex.getStation("Конфетная"));
        //secondRoute.add(stationIndex.getStation("Куриная"));
        secondRoute.add(stationIndex.getStation("Говяжья" , 2));
        secondRoute.add(stationIndex.getStation("Клубничная", 3));
        //secondRoute.add(stationIndex.getStation("Вишневая"));

        calc = new RouteCalculator(stationIndex);

        super.setUp();
    }

    public void testGetShortestRoute() {
        List<Station> actual = calc.getShortestRoute(stationIndex.getStation("Шоколадная", 1),
                stationIndex.getStation("Клубничная", 3));
        List<Station> expected = secondRoute;
        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(actual, expected);
    }
}