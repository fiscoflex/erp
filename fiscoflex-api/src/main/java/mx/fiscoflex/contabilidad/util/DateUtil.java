package mx.fiscoflex.contabilidad.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

	public static String now() {		
		
		 DateTime dt = new DateTime();
		 DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
		 String str = fmt.print(dt);
		 
		 return str;
	}
}
