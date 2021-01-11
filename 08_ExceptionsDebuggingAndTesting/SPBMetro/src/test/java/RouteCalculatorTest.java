import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    List<Station> firstRoute;
    List<Station> secondRoute;
    List<Station> thirdRoute;
    RouteCalculator calc;
    List<Station> connections;
    List<Station> connectionsTwo;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        firstRoute = new ArrayList<>();
        secondRoute = new ArrayList<>();
        thirdRoute = new ArrayList<>();

        connections = new ArrayList<>();
        connectionsTwo = new ArrayList<>();
        stationIndex = new StationIndex();

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(new Station("Шоколадная", line1));
        stationIndex.addStation(new Station("Конфетная", line1));
        line1.addStation(stationIndex.getStation("Шоколадная", 1));
        line1.addStation(stationIndex.getStation("Конфетная", 1));

        stationIndex.addStation(new Station("Куриная", line2));
        stationIndex.addStation(new Station("Говяжья", line2));
        line2.addStation(stationIndex.getStation("Куриная", 2));
        line2.addStation(stationIndex.getStation("Говяжья", 2));

        stationIndex.addStation(new Station("Клубничная", line3));
        stationIndex.addStation(new Station("Вишневая", line3));
        line3.addStation(stationIndex.getStation("Клубничная", 3));
        line3.addStation(stationIndex.getStation("Вишневая", 3));

        connections.add(stationIndex.getStation("Конфетная", 1));
        connections.add(stationIndex.getStation("Говяжья", 2));

        connectionsTwo.add(stationIndex.getStation("Говяжья", 2));
        connectionsTwo.add(stationIndex.getStation("Клубничная", 3));

        stationIndex.addConnection(connections);
        stationIndex.addConnection(connectionsTwo);

        firstRoute.add(stationIndex.getStation("Шоколадная", 1));
        firstRoute.add(stationIndex.getStation("Конфетная", 1));

        secondRoute.add(stationIndex.getStation("Шоколадная", 1));
        secondRoute.add(stationIndex.getStation("Конфетная", 1));
        secondRoute.add(stationIndex.getStation("Говяжья", 2));

        thirdRoute.add(stationIndex.getStation("Шоколадная", 1));
        thirdRoute.add(stationIndex.getStation("Конфетная", 1));
        thirdRoute.add(stationIndex.getStation("Говяжья", 2));
        thirdRoute.add(stationIndex.getStation("Клубничная", 3));
        thirdRoute.add(stationIndex.getStation("Вишневая", 3));

        calc = new RouteCalculator(stationIndex);

        super.setUp();
    }

    public void testShortestRouteOnOneLineWithoutConnection() {
        List<Station> actual = calc.getShortestRoute(stationIndex.getStation("Шоколадная", 1),
                stationIndex.getStation("Конфетная", 1));
        assertEquals(firstRoute, actual);

        List<Station> reversedActual = calc.getShortestRoute(stationIndex.getStation("Конфетная", 1),
                stationIndex.getStation("Шоколадная", 1));
        Collections.reverse(firstRoute);
        assertEquals(firstRoute, reversedActual);

    }


    public void testShortestRouteWithOneConnection() {
        List<Station> actual = calc.getShortestRoute(stationIndex.getStation("Шоколадная", 1),
                stationIndex.getStation("Говяжья", 2));
        assertEquals(secondRoute, actual);
    }

    public void testShortestRouteWithTwoConnections() {
        List<Station> actual = calc.getShortestRoute(stationIndex.getStation("Шоколадная", 1),
                stationIndex.getStation("Вишневая", 3));
        assertEquals(thirdRoute, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(firstRoute);
        double expected = 2.5;
        assertEquals(expected, actual);

        assertEquals(actual , expected);
    }
}