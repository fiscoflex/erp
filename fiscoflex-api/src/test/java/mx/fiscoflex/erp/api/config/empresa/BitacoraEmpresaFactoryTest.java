package mx.fiscoflex.erp.api.config.empresa;

import java.util.UUID;

import junit.framework.Assert;
import mx.fiscoflex.erp.api.bitacora.BitacoraDTO;
import mx.fiscoflex.erp.api.config.empresa.BitacoraEmpresaFactory;
import mx.fiscoflex.erp.api.config.empresa.EmpresaDTO;
import mx.fiscoflex.erp.api.seguridad.sesion.SesionDTO;

import org.junit.Test;

public class BitacoraEmpresaFactoryTest {

	@Test
	public void crearBitacora() {
		
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setCurp("HBA6003222");
		empresaDTO.setRfc("HBA6003222K3");
		empresaDTO.setNombre("ENRIQUE ILLAN GARCIA");
		
		SesionDTO sesionDTO = new SesionDTO();
		
		String nombreUsuario = "admin";
		String idSesion = UUID.randomUUID().toString();
		String ip = "localhost";
		
		sesionDTO.setIdSesion(idSesion);
		sesionDTO.setNombreUsuario(nombreUsuario);
		sesionDTO.setIp(ip);
		
		BitacoraEmpresaFactory bitacoraEmpresaFactory = new BitacoraEmpresaFactory();
		BitacoraDTO bitacoraDTO = bitacoraEmpresaFactory.crear(empresaDTO, sesionDTO);
		
		System.out.println(bitacoraDTO.getEntrada());
		
		Assert.assertNotNull(bitacoraDTO.getDescripcion());
		Assert.assertNotNull(bitacoraDTO.getEntrada());
		Assert.assertNotNull(bitacoraDTO.getFecha());
		Assert.assertNotNull(bitacoraDTO.getHora());
		Assert.assertNotNull(bitacoraDTO.getIdBitacora());
		Assert.assertNotNull(bitacoraDTO.getIdEvento());
		Assert.assertNotNull(bitacoraDTO.getIdSesion());
		Assert.assertNotNull(bitacoraDTO.getIp());
		
		// La salida debe ser vacia
		Assert.assertNull(bitacoraDTO.getSalida());		
		
		// La descripcion de la bitacora es el RFC y el nombre de la Empresa
		String descripcion = "RFC: " + empresaDTO.getRfc() + " Empresa: " + empresaDTO.getNombre();
		Assert.assertEquals(descripcion, bitacoraDTO.getDescripcion());
		
	}
}
