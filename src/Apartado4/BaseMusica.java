package Apartado4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BaseMusica {
	final String ruta="jdbc:mysql://localhost:3306/adat1";
	final String user="dam2";
	final String contraseña="asdf.1234";
	Connection miConexion=null;
	
	public void crearBase() {
		String SQLCantante="CREATE TABLE IF NOT EXISTS Cantante("
				+ "nombre VARCHAR(50) NOT NULL,"
				+ "id_cantante VARCHAR(5) UNIQUE NOT NULL PRIMARY KEY,"
				+ "nacionalidad VARCHAR(50),"
				+ "fecha_nac DATE,"
				+ "fecha_dec DATE,"
				+ "fecha_debut DATE,"
				+ "estado ENUM('enActivo','retirada','retirado') NOT NULL)";
		
		String SQLAlbum="CREATE TABLE IF NOT EXISTS Album("
				+ "nombre VARCHAR(100) NOT NULL,"
				+ "id_album VARCHAR(5) UNIQUE NOT NULL PRIMARY KEY,"
				+ "id_cantante VARCHAR(5) NOT NULL,"
				+ "num_canciones INT NOT NULL,"
				+ "duracion TIME NOT NULL,"
				+ "genero VARCHAR(100),"
				+ "fecha_lanzamiento DATE,"
				+ "FOREIGN KEY (id_cantante) REFERENCES Cantante(id_cantante) ON DELETE CASCADE)";
		
		try(Statement iniciar=miConexion.createStatement()){
			iniciar.execute(SQLCantante);
			iniciar.execute(SQLAlbum);
			System.out.println("BASE Y TABLAS CREADAS CORRECTAMENTE");
		} catch (SQLException e) {
			System.out.println("Error al crear las tablas"+" "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void relleñarTablaCantantes(ArrayList<Cantante> listaCantantes) throws SQLException {
		for(Cantante c:listaCantantes) {
			añadirCantante(c);
		}
	}
	
	public void relleñarTablaAlbum(ArrayList<Album> listaAlbum) throws SQLException {
		for(Album a:listaAlbum) {
			añadirAlbum(a);
		}
	}
	
	public Cantante buscarCantante(String nombre) {
		String SQL = "SELECT * FROM Cantante WHERE nombre = ?";
		Cantante c = null;
        try (PreparedStatement ps = miConexion.prepareStatement(SQL)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	String id = rs.getString("id_cantante");
                String nacionalidad = rs.getString("nacionalidad");
                Date fechaNac = rs.getDate("fecha_nac");
                Date fechaDec = rs.getDate("fecha_dec");
                Date fechaDebut = rs.getDate("fecha_debut");
                String estadoStr = rs.getString("estado");
                Cantante.Estado estado = Cantante.Estado.valueOf(estadoStr);
                
                if (fechaDec != null) {
                    c = new Cantante(nombre, id, nacionalidad, fechaNac, fechaDec, fechaDebut, estado);
                } else {
                    c = new Cantante(nombre, id, nacionalidad, fechaNac, fechaDebut, estado);
                }

                
                System.out.println("Cantante encontrado: " + c);
            } else {
                System.out.println("No se encontró ningún cantante llamado/a " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
        return c;
	}
	
	public void añadirCantante(Cantante c) throws SQLException {
		PreparedStatement introCv=miConexion.prepareStatement("INSERT IGNORE INTO Cantante("
				+ "nombre,id_cantante,nacionalidad,fecha_nac,fecha_debut,estado)"
				+ " Values(?,?,?,?,?,?)");
		PreparedStatement introCm=miConexion.prepareStatement("INSERT IGNORE INTO Cantante Values(?,?,?,?,?,?,?)");
		
		if(c.fechaDec==null) {
			introCv.setString(1, c.nombre);
			introCv.setString(2, c.identificador);
			introCv.setString(3, c.nacionalidad);
			introCv.setDate(4, c.fechaNac);
			introCv.setDate(5, c.fechaDebut);
			introCv.setString(6, c.getEstado().name());
			
			introCv.executeUpdate();
		}else {
			introCm.setString(1, c.nombre);
			introCm.setString(2, c.identificador);
			introCm.setString(3, c.nacionalidad);
			introCm.setDate(4, c.fechaNac);
			introCm.setDate(5, c.fechaDec);
			introCm.setDate(6, c.fechaDebut);
			introCm.setString(7, c.getEstado().name());
			
			introCm.executeUpdate();
			
			System.out.println(c.nombre+" añadido correctamente");
		}
	}
	
	public void añadirAlbum(Album a) throws SQLException {
		PreparedStatement introA=miConexion.prepareStatement("INSERT IGNORE INTO Album Values(?,?,?,?,?,?,?)");
		
		introA.setString(1, a.nombre);
		introA.setString(2, a.identificador);
		introA.setString(3, a.cantante.getIdentificador());
		introA.setInt(4, a.numCanciones);
		introA.setTime(5, a.duracion);
		introA.setString(6, a.genero);
		introA.setDate(7, a.fechaLanzamiento);
			
		introA.executeUpdate();
		
		System.out.println(a.nombre+" añadido correctamente");
		
	}
	
	public void eliminarCantante(String nombre) throws SQLException {
		PreparedStatement introA=miConexion.prepareStatement("DELETE FROM Cantante WHERE nombre= ?" );
		introA.setString(1, nombre);
		introA.execute();
		System.out.println(nombre+" eliminado correctamente");
	}
	
	

}
