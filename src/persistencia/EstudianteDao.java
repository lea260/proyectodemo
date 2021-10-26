package persistencia;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.IntToDoubleFunction;

import dto.EstudianteDto;

public class EstudianteDao {
	public EstudianteDao() {

	}

	public ArrayList<EstudianteDto> obternerListaClientes() {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		ArrayList<EstudianteDto> listaPersonas = new ArrayList<EstudianteDto>();
		try {
			PreparedStatement ps = con.prepareStatement("select nombre, apellido, cedula from estudiante");
			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellido = resultado.getString("apellido");
				int cedula = resultado.getInt("cedula");
				EstudianteDto personaDao = new EstudianteDto(nombre, apellido, cedula);
				listaPersonas.add(personaDao);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaPersonas;
	}

	public int agregarEstudiante(EstudianteDto est) {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();

		int resultado = -1;
		try {
			PreparedStatement ps = con.prepareStatement(
					"insert into estudiante (nombre, apellido, cedula) values(?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, est.getNombre());
			ps.setString(2, est.getApellido());
			ps.setInt(3, est.getCedula());
			resultado = ps.executeUpdate();
			if (ps.executeUpdate() > 0) {
				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object
				java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					int primkey = generatedKeys.getInt(1);
					resultado = primkey;
				}
			}
			// System.out.println("Record updated with id = "+primkey);

		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultado;
	}

	public boolean eliminarCliente(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		boolean resultado = false;
		try {
			PreparedStatement ps = con.prepareStatement("delete from clientes where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean editarEstudiante(EstudianteDto est) {
		// TODO Auto-generated method stub
		Connection con = Conexion.getConexion();
		int resultado = -1;
		try {
			PreparedStatement ps = con.prepareStatement("update estudiante set nombre=?,apellido=?,cedula=? where cedula=?");
			ps.setString(1, est.getNombre());
			ps.setString(2, est.getApellido());
			ps.setInt(3, est.getCedula());
			resultado = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
