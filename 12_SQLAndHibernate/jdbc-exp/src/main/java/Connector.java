import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connector {
    Scanner scanner = new Scanner(System.in);

    private final String url;
    private final String user;
    private final String pass;

    public Connector() {
        url = "jdbc:mysql://localhost:3306/skillbox";
        user = "root";
        pass = scanner.nextLine();
    }

        public Statement getConnection () throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection.createStatement();
    }
}