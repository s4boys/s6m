/*---------------------------------------------------
 * Hochschule fuer Technik Stuttgart
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

public interface Datenbasis {

	public String[] getBeobachtungsraum();
	
	public String getNameBeobachtungsraum();
	
	public String getNameMerkmalsauspraegung();
	
	public String getTopic();
	
	public Number[] getMerkmalsauspraegungen();

	public String getName();
}
