package mx.fiscoflex.erp.api.config.empresa;

import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mx.fiscoflex.erp.api.bitacora.BitacoraDTO;
import mx.fiscoflex.erp.api.seguridad.sesion.SesionDTO;

public class BitacoraEmpresaFactory {	
	
	public BitacoraDTO crear(EmpresaDTO empresaDTO, SesionDTO sesionDTO) {
		
		BitacoraDTO bitacoraDTO = new BitacoraDTO();
		
		String idBitacora = UUID.randomUUID().toString();		
		bitacoraDTO.setIdBitacora(idBitacora);
		
		bitacoraDTO.setIdEvento(EventoEmpresa.CREAR);
		
		DateTime fechaActual = DateTime.now();
		DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTimeFormatter hf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		String fecha = df.print(fechaActual);		
		String hora = hf.print(fechaActual);
		
		bitacoraDTO.setFecha(fecha);
		bitacoraDTO.setHora(hora);
		
		bitacoraDTO.setIdSesion(sesionDTO.getIdSesion());
		bitacoraDTO.setIp(sesionDTO.getIp());
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();		
		String entrada = gson.toJson(empresaDTO);		
		
		bitacoraDTO.setEntrada(entrada);		
		
		// Descripcion del evento
		String descripcion = "RFC: "  + empresaDTO.getRfc() + " Empresa: " + empresaDTO.getNombre();
		bitacoraDTO.setDescripcion(descripcion);
		
		return bitacoraDTO;
	}
}
