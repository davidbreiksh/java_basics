import java.sql.*;

public class DBConnection {
    private static Connection connection;
    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "ya78yrc8n4w3984";

    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() throws ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

//    public static void executeMultipleInserts() throws SQLException, ClassNotFoundException {
//        if (insertQuery.length() > 0) {
//            DBConnection.getConnection().createStatement()
//                    .execute("INSERT INTO voter_count(name , birthDate , `count`) VALUES" +
//                            insertQuery.toString());
//            insertQuery = new StringBuilder();
//        }
//    }

    public static void countVoter(String name, String birthDay) throws SQLException, ClassNotFoundException {
        birthDay = birthDay.replace('.', '-');
        insertQuery.append("('" + name + "', '" + birthDay + "', 1)");
        String sql =
            "SELECT id FROM voter_count WHERE birthDate='" + birthDay + "' AND name='" + name + "'";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        if (!rs.next()) {
            DBConnection.getConnection().createStatement()
                .execute("INSERT INTO voter_count(name, birthDate, `count`) VALUES('" +
                    name + "', '" + birthDay + "', 1)");
        } else {
            Integer id = rs.getInt("id");
            DBConnection.getConnection().createStatement()
                .execute("UPDATE voter_count SET `count`=`count`+1 WHERE id=" + id);
        }
        rs.close();
    }

//    public static void countVoter(String name, String birthDay) throws SQLException, ClassNotFoundException {
//        birthDay = birthDay.replace('.', '-');
//        insertQuery.append("(?, ?, 1),");
//        PreparedStatement ps = DBConnection.getConnection().prepareStatement(
//                "INSERT INTO voter_count(name, birthDate, `count`) VALUES (?, ?, 1)");
//        ps.setString(1, name);
//        ps.setString(2, birthDay);
//        ps.executeUpdate();
//    }

    public static void printVoterCounts() throws SQLException, ClassNotFoundException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}