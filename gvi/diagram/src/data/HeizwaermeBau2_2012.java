
/*---------------------------------------------------
 * Hochschule f�r Technik Stuttgart
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

public class HeizwaermeBau2_2012 implements Datenbasis{

	String[] beobachtungsraum = {"Jan","Feb","Mar","Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"};
	Number[] merkmalsauspraegungen = {128.52, 187.54, 63.16, 72.18, 0, 0, 0, 0, 6, 68.58, 84.54, 120.51 };


	public String[] getBeobachtungsraum(){
		return beobachtungsraum;
	}
	

	public String getNameBeobachtungsraum(){
		return "Monat";
	}

	public String getNameMerkmalsauspraegung() {
		return "Heizwaermebedarf [MWh]";
	}
	

	public String getTopic() {
		return "Heizwaermebedarf HFT Stuttgart Bau2 pro Monat";
	}
	

	public Number[] getMerkmalsauspraegungen(){
		return merkmalsauspraegungen;
	}

	@Override
	public String getName() {
		return "2012";
	}
}