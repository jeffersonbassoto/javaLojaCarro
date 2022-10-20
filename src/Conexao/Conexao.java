package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/serratec";
	private static final String USER = "postgres";
    private static final String PASS = "123456";
    
    public static Connection getConnection() {
    	try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro: " + ex);
            return null;
        }
    }
    
    public static void closeConnection(Connection con) {
    	if (con != null) {
    		try {
                con.close();
    		} catch (SQLException ex) {
                System.err.println("Erro: " + ex);
    		}
    	}
    }
}
