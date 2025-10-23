package apartado1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloAlumnosJDBC implements IModeloAlumnos {

	private static String cadenaConexion =  "jdbc:mysql://localhost:3306/instituto";
	private static String user = "dam2";
	private static String pass = "asdf.1234";
	
	Connection miConexion=null;
	
	public ModeloAlumnosJDBC() {
		try {
            miConexion = DriverManager.getConnection(cadenaConexion, user, pass);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	

	@Override
	public List<String> getAll() {
		List<String> lista = new ArrayList<>();
        String SQL = "SELECT * FROM alumnos";
        try (Statement st = miConexion.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            while (rs.next()) {
                String info = rs.getString("DNI") + " - " +
                              rs.getString("nombre") + " " +
                              rs.getString("apellidos") + " (CP: " +
                              rs.getString("CP") + ")";
                lista.add(info);
            }
           
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos: " + e.getMessage());
        }
        return lista;
	}

	@Override
	public Alumno getAlumnoPorDNI(String DNI) {
		String SQL = "SELECT * FROM alumnos WHERE DNI = ?";
        Alumno a = null;
        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
            ps.setString(1, DNI);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno(
                    rs.getString("DNI"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("CP")
                );
                System.out.println("🔍 Alumno encontrado: " + a);
            } else {
                System.out.println("⚠️ No se encontró ningún alumno con DNI " + DNI);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al buscar alumno: " + e.getMessage());
        }
        return a;
	}

	@Override
	public boolean modificarAlumno(Alumno alumno) {
		 String SQL = "UPDATE alumnos SET nombre = ?, apellidos = ?, CP = ? WHERE DNI = ?";
	        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
	            ps.setString(1, alumno.getNombre());
	            ps.setString(2, alumno.getApellidos());
	            ps.setString(3, alumno.getCP());
	            ps.setString(4, alumno.getDNI());
	            int filas = ps.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Alumno actualizado correctamente: " + alumno);
	                return true;
	            } else {
	                System.out.println("No se encontró el alumno para actualizar con DNI " + alumno.getDNI());
	                return false;
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al modificar alumno: " + e.getMessage());
	            return false;
	        }
	}
	

	@Override
	public boolean eliminarAlumno(String DNI) {

        String SQL = "DELETE FROM alumnos WHERE DNI = ?";
        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
            ps.setString(1, DNI);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno eliminado correctamente (DNI: " + DNI + ")");
                return true;
            } else {
                System.out.println("No se encontró el alumno con DNI " + DNI);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar alumno: " + e.getMessage());
            return false;
        }
	}

	@Override
	public boolean crear(Alumno alumno) {
		String SQL = "INSERT INTO alumnos (DNI, nombre, apellidos, CP) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
            ps.setString(1, alumno.getDNI());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellidos());
            ps.setString(4, alumno.getCP());
            ps.executeUpdate();
            System.out.println("Alumno añadido correctamente: " + alumno);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear alumno: " + e.getMessage());
            return false;
        }
	}
	
	

}
