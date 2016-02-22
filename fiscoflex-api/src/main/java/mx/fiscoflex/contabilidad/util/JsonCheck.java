package mx.fiscoflex.contabilidad.util;

import com.google.gson.Gson;

public class JsonCheck {

	public static boolean isJason(String json) {
		try {
			Gson gson = new Gson();
		    gson.fromJson(json, Object.class);
		    return true;
			
		} catch(com.google.gson.JsonSyntaxException ex) { 
			return false;
	    }
	}		
	
}
