package mx.fiscoflex.contabilidad.seguridad.autenticacion;

import java.util.UUID;

import org.joda.time.DateTime;

import mx.fiscoflex.contabilidad.seguridad.bitacora.Bitacora;

public class BitacoraAutenticacion {

	public static String ACCION_LOGIN = "A020201";
	
	public Bitacora login(String nombreUsuario, String token, String ip, String idUsuario) {		
		
		Bitacora bitacora = new Bitacora();
		bitacora.setActividad("Login");
		bitacora.setEntrada("{'nombreUsuario':'" + nombreUsuario + "','password':'***'}");
		bitacora.setSalida("{'token':' "  + token + "'}");
		bitacora.setFecha(DateTime.now());
		bitacora.setIdAccion(ACCION_LOGIN);
		bitacora.setIdBitacora(UUID.randomUUID().toString());
		bitacora.setIdUsuario(idUsuario);
		bitacora.setIp(ip);
		bitacora.setMarcaTemporal(DateTime.now());		
		return bitacora;
	}
}
