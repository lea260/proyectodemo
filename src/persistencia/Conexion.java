package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	

	public Conexion() {
	}

	private static Connection conexion = null;

	public static Connection getConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String extra = "?autoReconnect=true&useSSL=false";
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/adscripcion"+extra, "root", "jona18");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
			// TODO: handle exception
		} catch (SQLException ex) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

			// TODO: handle exception
		}

		return conexion;
	}

}
