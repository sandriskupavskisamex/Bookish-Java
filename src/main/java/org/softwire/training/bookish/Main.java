package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "library";
        String user = "root";
        String password = "passwordsql";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {


        // TODO: print out the details of all the books (using JDBC)
        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

        Connection connection = DriverManager.getConnection(connectionString);

        String database = "library";

        Statement statement = null;

        try {

            statement = connection.createStatement();

            String query = "select title " +
                    "from " + database + ".books ORDER BY title";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String title = rs.getString("title");
                System.out.println(title);
            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    private static void jdbiMethod(String connectionString) {

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);; // (H2 in-memory database)

        // THIS DOES NOT WORK. NEEDS SETTER.

        List<Book> books = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT title FROM library.books;")
                    .mapToBean(Book.class)
                    .list();
        });

        System.out.println("THE BOOK IS: " + books.get(0).getTitle());

    }
}
