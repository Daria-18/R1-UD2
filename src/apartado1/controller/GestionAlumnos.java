package src.apartado1.controller;

import src.apartado1.ui.VentanaAlumnos;
import src.apartado1.model.IModeloAlumnos;
import src.apartado1.model.ModeloAlumnosJDBC;

public class GestionAlumnos {

	public static void main(String[] args) {
		 try {
        	VentanaAlumnos view = new VentanaAlumnos();
        	IModeloAlumnos model = new ModeloAlumnosJDBC();
        	ControladorGestionAlumnos controller = new ControladorGestionAlumnos(model, view);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
