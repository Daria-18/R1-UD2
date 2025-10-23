package Apartado1.Controller;

import Apartado1.Model.IModeloAlumnos;
import Apartado1.Model.ModeloAlumnosJDBC;
import Apartado1.UI.VentanaAlumnos;

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
