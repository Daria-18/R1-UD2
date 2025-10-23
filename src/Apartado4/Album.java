package Apartado4;

import java.sql.Date;
import java.sql.Time;

public class Album {
	String nombre;
	String identificador;
	Cantante cantante;
	int numCanciones;
	Time duracion;
	String  genero;
	Date fechaLanzamiento;
	
	
	public Album(String nombre, String identificador, Cantante cantante, int numCanciones, Time duracion,String genero, Date fechaLanzamiento) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.cantante = cantante;
		this.numCanciones = numCanciones;
		this.duracion = duracion;
		this.genero = genero;
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getIdentificador() {return identificador;}
	public void setIdentificador(String identificador) {this.identificador = identificador;}
	
	public Cantante getCantante() {return cantante;}
	public void setCantante(Cantante cantante) {this.cantante = cantante;}
	
	public int getNumCanciones() {return numCanciones;}
	public void setNumCanciones(int numCanciones) {this.numCanciones = numCanciones;}
	
	public Time getDuracion() {return duracion;}
	public void setDuracion(Time duracion) {this.duracion = duracion;}
	
	public String getGenero() {return genero;}
	public void setGenero(String genero) {this.genero = genero;}
	
	public Date getFechaLanzamiento() {return fechaLanzamiento;}
	public void setFechaLanzamiento(Date fechaLanzamiento) {this.fechaLanzamiento = fechaLanzamiento;}
	
	@Override
	public String toString() {
		return "Album [nombre=" + nombre + ", identificador=" + identificador + ", cantante=" + cantante
				+ ", numCanciones=" + numCanciones + ", duracion=" + duracion + ", genero=" + genero
				+ ", fechaLanzamiento=" + fechaLanzamiento + "]";
	}
	
	
	
}
