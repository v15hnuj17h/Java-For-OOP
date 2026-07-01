import java.sql.*;

public class JDBCintro {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:db/college.db";

        try {
            // Connect to database
            Connection conn = DriverManager.getConnection(url);

            // Create statement
            Statement stmt = conn.createStatement();

            // Create table
            String createTable = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY,
                    name TEXT NOT NULL,
                    branch TEXT NOT NULL
                );
                """;

            stmt.execute(createTable);

            // Insert data
            String insert = """
                INSERT INTO students(name, branch)
                VALUES('Vishnu', 'Electrical and Electronics');
                """;

            stmt.executeUpdate(insert);

            // Display data
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("ID\tName\tBranch");
            System.out.println("------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("branch")
                );
            }

            rs.close();
            stmt.close();
            conn.close();

            System.out.println("\nDatabase operation completed!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}