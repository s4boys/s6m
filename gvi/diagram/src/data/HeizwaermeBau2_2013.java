
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

public class HeizwaermeBau2_2013 implements Datenbasis{

	String[] beobachtungsraum = {"Jan","Feb","Mar","Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"};
	Number[] merkmalsauspraegungen = {
			144.44,
			133.07,
			121.78,
			63.86,
			35.53,
			18.57,
			0,
			0,
			16.56,
			48.53,
			91.88,
			115.2
	};

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
		return "Heizwaermebedarf HFT Stuttgart Bau 2 pro Monat";
	}
	

	public Number[] getMerkmalsauspraegungen(){
		return merkmalsauspraegungen;
	}

	@Override
	public String getName() {
		return "2013";
	}

}