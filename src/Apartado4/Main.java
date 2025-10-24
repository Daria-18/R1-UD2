package Apartado4;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws SQLException {
		ListaCantantes listaCantantes = new ListaCantantes();
		ArrayList<Cantante> listaC = listaCantantes.getListaCantantes();
		
		ListaAlbum listaAlbum = new ListaAlbum();
		ArrayList<Album> listaA = listaAlbum.getListaAlbumnes();
		
		BaseMusica BaseMusica=new BaseMusica();
		BaseMusica.miConexion=DriverManager.getConnection(BaseMusica.ruta, BaseMusica.user, BaseMusica.contraseña);
		/*EJECUTAR LA PRIMERA VEZ SI NO TIENES LA BASE CREADA*/
		/*BaseMusica.crearBase();
		BaseMusica.relleñarTablaCantantes(listaC);
		BaseMusica.relleñarTablaAlbum(listaA);*/
		
		BaseMusica.buscarCantante("Taylor Swift");
		BaseMusica.añadirCantante(new Cantante("Conan Gray", "CG", "Estadounidense", Date.valueOf("2003-12-13"), Date.valueOf("2018-10-24"), Cantante.Estado.enActivo));
		BaseMusica.eliminarCantante("Charlie XCX");

	}

}
