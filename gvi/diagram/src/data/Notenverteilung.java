
/*---------------------------------------------------
 * Hochschule für Technik Stuttgart
 * Fachbereich Vermessung, Informatik und Mathematik
 * Schellingstr. 24
 * D-70174 Stuttgart
 *
 * Volker Coors, 11.9.2015
 * GeoVisualisierung
 * IL3, WS 2015/16
 *
 * 
 * ------------------------------------------------*/
package data;

public class Notenverteilung implements Datenbasis{

	String[] beobachtungsraum = {"1.0","1.3","1.7","2.0", "2.3", "2.7", "3.0", "3.3", "3.7", "4.0", "4.7", "5.0"};
	Integer[] merkmalsauspraegungen = {0, 1, 3, 3, 1, 3, 5, 4, 4, 8, 2, 3};
	
	public String[] getBeobachtungsraum(){
		return beobachtungsraum;
	}
	
	public String getNameBeobachtungsraum(){
		return "Note";
	}
	
	public String getNameMerkmalsauspraegung() {
		return "Anzahl";
	}
	
	public String getTopic() {
		return "Notenverteilung DST WS 2010/11";
	}

	public Number[] getMerkmalsauspraegungen(){
		return merkmalsauspraegungen;
	}

	@Override
	public String getName() {
		return "Notenverteilung";
	}


}