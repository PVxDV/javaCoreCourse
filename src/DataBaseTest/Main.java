package DataBaseTest;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Path DBPath = Paths.get("databases", "testjava.db");

        // to auto close connection recommended use try with resources
        //        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DBPath.toAbsolutePath());
        //            Statement statement = conn.createStatement()){

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DBPath.toAbsolutePath());
            //conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                    "(name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Anastasiya', 987654321, 'anastasiya@mail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Aleksander', 678912345, 'aleksander@mail.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Dmitriy', 1122334455, 'dmitriy@mail.com')");

//            statement.execute("UPDATE contacts SET phone =5566789 WHERE name = 'Anastasiya'");
//            statement.execute("DELETE FROM contacts WHERE name= 'Dmitriy'");

            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }

            results.close();
            statement.close(); // if we don`t use try with resources we have to close connection manually
                               // ORDER IS IMPORTANT(!) At firsts we should close any instances of STATEMENT, then CONNECTION
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

}
