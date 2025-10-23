package Apartado4;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class ListaAlbum {
private ArrayList<Album> listaAlbumnes = new ArrayList<Album>();
	
	public ListaAlbum() {
		ListaCantantes listaCantantes = new ListaCantantes();
		ArrayList<Cantante> listaC = listaCantantes.getListaCantantes();
		
		// Taylor Swift
		listaAlbumnes.add(new Album("Taylor Swift", "TS1", listaC.get(0), 15, Time.valueOf("00:53:00"), "Country", Date.valueOf("2006-10-24")));
		listaAlbumnes.add(new Album("Fearless", "TS2", listaC.get(0), 19, Time.valueOf("01:19:00"), "Country", Date.valueOf("2008-11-11")));
		listaAlbumnes.add(new Album("Speak Now", "TS3", listaC.get(0), 14, Time.valueOf("01:16:00"), "Country", Date.valueOf("2010-10-25")));
		listaAlbumnes.add(new Album("Red", "TS4", listaC.get(0), 22, Time.valueOf("01:30:00"), "Country", Date.valueOf("2012-10-22")));
		listaAlbumnes.add(new Album("1989", "TS5", listaC.get(0), 19, Time.valueOf("01:08:00"), "Pop", Date.valueOf("2014-10-24")));
		listaAlbumnes.add(new Album("Reputation", "TS6", listaC.get(0), 15, Time.valueOf("00:55:00"), "Pop", Date.valueOf("2017-11-10")));

		// Ariana Grande 
		listaAlbumnes.add(new Album("Yours Truly", "AG1", listaC.get(1), 12, Time.valueOf("00:46:00"), "Pop", Date.valueOf("2013-09-03")));
		listaAlbumnes.add(new Album("My Everything", "AG2", listaC.get(1), 15, Time.valueOf("00:50:00"), "Pop", Date.valueOf("2014-08-25")));
		listaAlbumnes.add(new Album("Sweetener", "AG3", listaC.get(1), 15, Time.valueOf("00:47:00"), "Pop", Date.valueOf("2018-08-17")));

		// Lady Gaga 
		listaAlbumnes.add(new Album("The Fame", "LG1", listaC.get(2), 14, Time.valueOf("00:54:00"), "Pop", Date.valueOf("2008-08-19")));
		listaAlbumnes.add(new Album("Born This Way", "LG2", listaC.get(2), 17, Time.valueOf("01:01:00"), "Pop", Date.valueOf("2011-05-23")));
		listaAlbumnes.add(new Album("Chromatica", "LG3", listaC.get(2), 16, Time.valueOf("00:43:00"), "Pop", Date.valueOf("2020-05-29")));

		// Johnny Orlando 
		listaAlbumnes.add(new Album("Teenage Fever", "JO1", listaC.get(3), 12, Time.valueOf("00:38:00"), "Pop", Date.valueOf("2019-03-15")));
		listaAlbumnes.add(new Album("all the things that could go wrong", "JO2", listaC.get(3), 12, Time.valueOf("00:40:00"), "Pop", Date.valueOf("2022-08-19")));

		// Alec Benjamin 
		listaAlbumnes.add(new Album("Narrated for You", "AB1", listaC.get(4), 12, Time.valueOf("00:38:00"), "Pop", Date.valueOf("2018-11-16")));
		listaAlbumnes.add(new Album("These Two Windows", "AB2", listaC.get(4), 10, Time.valueOf("00:31:00"), "Pop", Date.valueOf("2020-05-29")));

		// Troye Sivan 
		listaAlbumnes.add(new Album("Blue Neighbourhood", "TS21", listaC.get(5), 16, Time.valueOf("00:56:00"), "Pop", Date.valueOf("2015-12-04")));
		listaAlbumnes.add(new Album("Bloom", "TS22", listaC.get(5), 10, Time.valueOf("00:36:00"), "Pop", Date.valueOf("2018-08-31")));

		// Olivia Rodrigo 
		listaAlbumnes.add(new Album("SOUR", "OR1", listaC.get(6), 11, Time.valueOf("00:34:00"), "Pop", Date.valueOf("2021-05-21")));
		listaAlbumnes.add(new Album("GUTS", "OR2", listaC.get(6), 12, Time.valueOf("00:39:00"), "Pop Rock", Date.valueOf("2023-09-08")));

		// Charli XCX 
		listaAlbumnes.add(new Album("True Romance", "XCX1", listaC.get(7), 13, Time.valueOf("00:49:00"), "Pop", Date.valueOf("2013-04-12")));
		listaAlbumnes.add(new Album("Crash", "XCX2", listaC.get(7), 12, Time.valueOf("00:34:00"), "Synthpop", Date.valueOf("2022-03-18")));

		// Dua Lipa 
		listaAlbumnes.add(new Album("Dua Lipa", "DL1", listaC.get(8), 12, Time.valueOf("00:48:00"), "Pop", Date.valueOf("2017-06-02")));
		listaAlbumnes.add(new Album("Future Nostalgia", "DL2", listaC.get(8), 11, Time.valueOf("00:37:00"), "Pop", Date.valueOf("2020-03-27")));

		// Harry Styles 
		listaAlbumnes.add(new Album("Harry Styles", "HS1", listaC.get(9), 10, Time.valueOf("00:40:00"), "Pop Rock", Date.valueOf("2017-05-12")));
		listaAlbumnes.add(new Album("Fine Line", "HS2", listaC.get(9), 12, Time.valueOf("00:46:00"), "Pop Rock", Date.valueOf("2019-12-13")));
		listaAlbumnes.add(new Album("Harry's House", "HS3", listaC.get(9), 13, Time.valueOf("00:42:00"), "Pop", Date.valueOf("2022-05-20")));

		// Alessandra Mele 
		listaAlbumnes.add(new Album("Trenchcoat", "AM1", listaC.get(10), 10, Time.valueOf("00:33:00"), "Pop", Date.valueOf("2024-03-08")));

		// Ed Sheeran 
		listaAlbumnes.add(new Album("+", "ES1", listaC.get(11), 12, Time.valueOf("00:49:00"), "Pop", Date.valueOf("2011-09-09")));
		listaAlbumnes.add(new Album("x", "ES2", listaC.get(11), 12, Time.valueOf("00:50:00"), "Pop", Date.valueOf("2014-06-20")));
		listaAlbumnes.add(new Album("÷", "ES3", listaC.get(11), 12, Time.valueOf("00:46:00"), "Pop", Date.valueOf("2017-03-03")));

		// Kyle Alessandro 
		listaAlbumnes.add(new Album("Glow", "KA1", listaC.get(12), 10, Time.valueOf("00:32:00"), "Pop", Date.valueOf("2022-06-10")));

		// Sabrina Carpenter (listaCantantes.get(13))
		listaAlbumnes.add(new Album("Eyes Wide Open", "SC1", listaC.get(13), 12, Time.valueOf("00:42:00"), "Pop", Date.valueOf("2015-04-14")));
		listaAlbumnes.add(new Album("emails i can’t send", "SC2", listaC.get(13), 13, Time.valueOf("00:44:00"), "Pop", Date.valueOf("2022-07-15")));
		listaAlbumnes.add(new Album("Short n’ Sweet", "SC3", listaC.get(13), 12, Time.valueOf("00:36:00"), "Pop", Date.valueOf("2024-08-23")));

		// Michael Jackson 
		listaAlbumnes.add(new Album("Thriller", "MJ1", listaC.get(14), 9, Time.valueOf("00:42:00"), "Pop", Date.valueOf("1982-11-30")));
		listaAlbumnes.add(new Album("Bad", "MJ2", listaC.get(14), 10, Time.valueOf("00:48:00"), "Pop", Date.valueOf("1987-08-31")));
		listaAlbumnes.add(new Album("Dangerous", "MJ3", listaC.get(14), 14, Time.valueOf("01:17:00"), "Pop", Date.valueOf("1991-11-26")));

		// Ross Lynch 
		listaAlbumnes.add(new Album("Louder", "RS1", listaC.get(15), 11, Time.valueOf("00:42:00"), "Pop Rock", Date.valueOf("2013-09-24")));
		listaAlbumnes.add(new Album("Girlfriend", "RS2", listaC.get(15), 13, Time.valueOf("00:40:00"), "Pop Rock", Date.valueOf("2021-09-17")));

	}

	public ArrayList<Album> getListaAlbumnes() {
		return listaAlbumnes;
	}
}
