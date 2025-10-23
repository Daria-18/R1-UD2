package Apartado4;

import java.sql.Date;

public class Cantante{
	String nombre;
	String identificador;
	String nacionalidad;
	Date fechaNac;
	Date fechaDec;
	Date fechaDebut;
	Estado estado;
	
	public enum Estado{enActivo,retirada,retirado}

	public Cantante(String nombre, String identificador, String nacionalidad, Date fechaNac, Date fechaDec,Date fechaDebut,Estado estado) {
		this.nombre = nombre;
		this.identificador = identificador;
		this.nacionalidad = nacionalidad;
		this.fechaNac = fechaNac;
		this.fechaDec = fechaDec;
		this.fechaDebut=fechaDebut;
		this.estado=estado;
	}
	public Cantante(String nombre, String identificador, String nacionalidad, Date fechaNac, Date fechaDebut,Estado estado) {
		this.nombre = nombre;
		this.identificador = identificador;
		this.nacionalidad = nacionalidad;
		this.fechaNac = fechaNac;
		this.fechaDebut = fechaDebut;
		this.estado = estado;
	}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public String getIdentificador() {return identificador;}
	public void setIdentificador(String identificador) {this.identificador = identificador;}
	
	public String getNacionalidad() {return nacionalidad;}
	public void setNacionalidad(String nacionalidad) {}
	
	public Date getFechaNac() {return fechaNac;}
	public void setFechaNac(Date fechaNac) {this.fechaNac = fechaNac;}
	
	public Date getFechaDec() {return fechaDec;}
	public void setFechaDec(Date fechaDec) {this.fechaDec = fechaDec;}

	public Date getFechaDebut() {return fechaDebut;}
	public void setFechaDebut(Date fechaDebut) {this.fechaDebut = fechaDebut;}

	public Estado getEstado() {return estado;}
	public void setEstado(Estado estado) {this.estado = estado;}
	@Override
	public String toString() {
		return "Cantante [nombre=" + nombre + ", identificador=" + identificador + ", nacionalidad=" + nacionalidad
				+ ", fechaNac=" + fechaNac + ", fechaDec=" + fechaDec + ", fechaDebut=" + fechaDebut + ", estado="
				+ estado + "]";
	}

	
	
	
	
}

