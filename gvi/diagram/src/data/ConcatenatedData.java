package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import data.*;

public class ConcatenatedData implements Datenbasis {

	public String[] getBeobachtungsraum() {
		String[] months_2012 = data_2012.getBeobachtungsraum();
		String[] months_2013 = data_2013.getBeobachtungsraum();
		String[] months_2014 = data_2014.getBeobachtungsraum();

		Stream<String> m12 = Arrays.stream(months_2012).map(a -> a.concat(", 2012"));
		Stream<String> m13 = Arrays.stream(months_2013).map(a -> a.concat(", 2013"));
		Stream<String> m14 = Arrays.stream(months_2014).map(a -> a.concat(", 2014"));
		
		return Stream.concat(m12,Stream.concat(m13, m14)).toArray(String[]::new);

	}

	public String getNameBeobachtungsraum() {
		return "Monat";
	}

	public String getNameMerkmalsauspraegung() {
		return "Heizwaermebedarf [MWh]";
	}

	public String getTopic() {
		return "Waermebedarf Bau2 aus den Jahren 2012/2013/2014";
	}

	public Number[] getMerkmalsauspraegungen() {
		Number[] months_2012 = data_2012.getMerkmalsauspraegungen();
		Number[] months_2013 = data_2013.getMerkmalsauspraegungen();
		Number[] months_2014 = data_2014.getMerkmalsauspraegungen();
				
		Stream<Number> m12 = Arrays.stream(months_2012);
		Stream<Number> m13 = Arrays.stream(months_2013);
		Stream<Number> m14 = Arrays.stream(months_2014);

		return Stream.concat(m12,Stream.concat(m13, m14)).toArray(Number[]::new);
	}

	@Override
	public String getName() {
		return "2012 - 2014";
	}
	
	private Datenbasis data_2012 = new HeizwaermeBau2_2012();
	private Datenbasis data_2013 = new HeizwaermeBau2_2013();
	private Datenbasis data_2014 = new HeizwaermeBau2_2014();

}
