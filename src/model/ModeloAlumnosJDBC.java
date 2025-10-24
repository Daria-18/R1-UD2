package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloAlumnosJDBC implements IModeloAlumnos {

	private static String cadenaConexion =  "jdbc:mysql://localhost:3306/adat";
	private static String user = "dam2";
	private static String pass = "asdf.1234";
	
	Connection miConexion=null;
	
	public ModeloAlumnosJDBC() throws SQLException {
		try {
            miConexion = DriverManager.getConnection(cadenaConexion, user, pass);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            crearBD();
            //e.printStackTrace();
            miConexion = DriverManager.getConnection(cadenaConexion, user, pass);
            System.out.println("Conectado a la base de datos");
        }
	}

    private void crearBD() throws SQLException {

        String ruta2 = "jdbc:mysql://localhost:3306/";

        Connection conexionCrear = DriverManager.getConnection(ruta2,user,pass);
        Statement sqlCreate = conexionCrear.createStatement();

        sqlCreate.execute("CREATE DATABASE IF NOT EXISTS adat");
        System.out.println("Base creada: adat" );

        Connection conexionTabla = DriverManager.getConnection(cadenaConexion, user, pass);
        Statement sqlTabla = conexionTabla.createStatement();

        String sqlAlumnos = """
            CREATE TABLE IF NOT EXISTS Alumnos (
                DNI VARCHAR(9) PRIMARY KEY,
                nombre VARCHAR(50) NOT NULL,
                apellido VARCHAR(50) NOT NULL,
                CP VARCHAR(10)
            )
         """;

        sqlTabla.execute(sqlAlumnos);
        System.out.println("Tabla alumnos creada");

    }



    @Override
	public List<String> getAll() {
		List<String> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Alumnos";
        try (Statement st = miConexion.createStatement();
             ResultSet rs = st.executeQuery(SQL)) {
            while (rs.next()) {
                String info = rs.getString("DNI") + " - " +
                              rs.getString("nombre") + " " +
                              rs.getString("apellido") + " (CP: " +
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
		String SQL = "SELECT * FROM Alumnos WHERE DNI = ?";
        Alumno a = null;
        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
            ps.setString(1, DNI);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno(
                    rs.getString("DNI"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("CP")
                );
                System.out.println("Alumno encontrado: " + a);
            } else {
                System.out.println("No se encontró ningún alumno con DNI " + DNI);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
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

        String SQL = "DELETE FROM Alumnos WHERE DNI = ?";
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
		String SQL = "INSERT INTO Alumnos (DNI, nombre, apellido, CP) VALUES (?, ?, ?, ?)";
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
