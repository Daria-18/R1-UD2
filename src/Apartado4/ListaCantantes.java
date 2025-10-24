package Apartado4;

import java.sql.Date;
import java.util.ArrayList;


public class ListaCantantes {
	private ArrayList<Cantante> listaCantantes = new ArrayList<Cantante>();

	public ListaCantantes() {
		/*0*/ listaCantantes.add(new Cantante("Taylor Swift", "TS", "Estadounidense", Date.valueOf("1989-12-13"), Date.valueOf("2006-10-24"), Cantante.Estado.enActivo));
		/*1*/ listaCantantes.add(new Cantante("Ariana Grande", "AG", "Estadounidense", Date.valueOf("1993-06-26"), Date.valueOf("2013-03-26"), Cantante.Estado.enActivo));
		/*2*/ listaCantantes.add(new Cantante("Lady Gaga", "LG", "Estadounidense", Date.valueOf("1986-03-28"), Date.valueOf("2008-04-08"), Cantante.Estado.enActivo));
		/*3*/ listaCantantes.add(new Cantante("Johnny Orlando", "JO", "Canadiense", Date.valueOf("2003-01-24"), Date.valueOf("2015-12-15"), Cantante.Estado.enActivo));
		/*4*/ listaCantantes.add(new Cantante("Alec Benjamin", "AB", "Estadounidense", Date.valueOf("1994-05-28"), Date.valueOf("2013-11-01"), Cantante.Estado.enActivo));
		/*5*/ listaCantantes.add(new Cantante("Troye Sivan", "TS2", "Australiano", Date.valueOf("1995-06-05"), Date.valueOf("2007-06-01"), Cantante.Estado.enActivo));
		/*6*/ listaCantantes.add(new Cantante("Olivia Rodrigo", "OR", "Estadounidense", Date.valueOf("2003-02-20"), Date.valueOf("2021-01-08"), Cantante.Estado.enActivo));
		/*7*/ listaCantantes.add(new Cantante("Charli XCX", "xcx", "Británica", Date.valueOf("1992-08-02"), Date.valueOf("2008-05-01"), Cantante.Estado.enActivo));
		/*8*/ listaCantantes.add(new Cantante("Dua Lipa", "DL", "Británica", Date.valueOf("1995-08-22"), Date.valueOf("2015-08-18"), Cantante.Estado.enActivo));
		/*9*/ listaCantantes.add(new Cantante("Harry Styles", "HS", "Británico", Date.valueOf("1994-02-01"), Date.valueOf("2010-07-23"), Cantante.Estado.enActivo)); 
		/*10*/listaCantantes.add(new Cantante("Alessandra Mele", "AM", "Noruega", Date.valueOf("2002-09-05"), Date.valueOf("2022-11-05"), Cantante.Estado.enActivo));
		/*11*/listaCantantes.add(new Cantante("Ed Sheeran", "ES", "Británico", Date.valueOf("1991-02-17"), Date.valueOf("2011-04-26"), Cantante.Estado.enActivo));
		/*12*/listaCantantes.add(new Cantante("Kyle Alessandro", "KA", "Noruego", Date.valueOf("2006-05-10"), Date.valueOf("2017-01-01"), Cantante.Estado.enActivo)); 
		/*13*/listaCantantes.add(new Cantante("Sabrina Carpenter", "SC", "Estadounidense", Date.valueOf("1999-05-11"), Date.valueOf("2014-03-14"), Cantante.Estado.enActivo));
		/*14*/listaCantantes.add(new Cantante("Michael Jackson", "MJ", "Estadounidense", Date.valueOf("1958-08-29"),Date.valueOf("2009-06-25"), Date.valueOf("1964-01-01"), Cantante.Estado.retirado));
		/*15*/listaCantantes.add(new Cantante("Ross Lynch", "RS", "Estadounidense", Date.valueOf("1995-12-29"), Date.valueOf("2012-04-02"), Cantante.Estado.enActivo));
	}

	
	public ArrayList<Cantante> getListaCantantes() {
		return listaCantantes;
	}

}
