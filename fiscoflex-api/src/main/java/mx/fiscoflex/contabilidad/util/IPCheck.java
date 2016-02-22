package mx.fiscoflex.contabilidad.util;

import java.util.regex.Pattern;

public class IPCheck {

	private static final Pattern PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	public static boolean isIP(String ip) {
		if(ip.equals("localhost")) {
			return true;
		}
		return PATTERN.matcher(ip).matches();
	}
}
