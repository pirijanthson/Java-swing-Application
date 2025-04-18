package TechRepair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	private Connection conn;
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tech","root","");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class is missing");
        } catch (SQLException ex) {
            System.out.println("Cannot connect");
        }
    }
    public static DatabaseConnection getSingleConnection() {
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.conn.isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (SQLException ex) {
            System.out.println("Something went wrong with server");
            return null;
        }
        return instance;
    }

    public boolean execute(String query) {
        try {
            Statement st = conn.createStatement();
            int result = st.executeUpdate(query);
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("Cannot insert");
            return false;
        }
    }
    
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
        return pstmt.executeQuery();
    }

    // Close the connection
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
