//  javac -cp "lib/*" DatabaseConnectionTester.java
// java -cp ".;lib/*" DatabaseConnectionTester

import java.sql.*;

public class DatabaseConnectionTester {
    private static final String URL = "jdbc:sqlite:test.db";
    public static void main (String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = DriverManager.getConnection(URL)) {
                System.out.println("Connected successfully");

                String createTable = """
                    CREATE TABLE IF NOT EXISTS products (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        price REAL NOT NULL
                    )
                """;
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(createTable);
                    System.out.println("Table created successfully");
                }

                try (Statement stmt = conn.createStatement()){
                    stmt.executeUpdate("DELETE FROM products");
                }

                String insertSql = "INSERT INTO products(id, name, price) VALUES (?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(insertSql)){
                    ps.setInt(1, 1);
                    ps.setString(2, "Apple");
                    ps.setDouble(3, 1.50);
                    ps.executeUpdate();

                    ps.setInt(1, 2);
                    ps.setString(2, "Banana");
                    ps.setDouble(3, 0.75);
                    ps.executeUpdate();

                    ps.setInt(1, 3);
                    ps.setString(2, "Mango");
                    ps.setDouble(3, 2.00);
                    ps.executeUpdate();

                    System.out.println("3 product inserted");
                }

                String selectSql = "SELECT * FROM products";
                try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(selectSql)){
                    System.out.println("--Product list--");
                    while (rs.next()) {
                        System.out.printf("%d | %-7s | %.2f%n",rs.getInt("id"),rs.getString("name"),rs.getDouble("price"));
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC Driver not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}