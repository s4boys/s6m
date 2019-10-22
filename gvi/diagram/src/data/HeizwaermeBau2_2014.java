
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

public class HeizwaermeBau2_2014 implements Datenbasis{

	String[] beobachtungsraum = {"Jan","Feb","Mar","Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"};
	Number[] merkmalsauspraegungen = {
			113.77,
			96.17,
			77.74,
			38.27,
			29.79,
			11.60,
			0,
			0,
			16.85,
			36.14,
			67.55,
			138.00
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
		return "2014";
	}

}