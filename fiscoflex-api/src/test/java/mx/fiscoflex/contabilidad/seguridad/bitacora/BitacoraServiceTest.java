package mx.fiscoflex.contabilidad.seguridad.bitacora;

import java.util.UUID;

import javax.inject.Inject;

import mx.fiscoflex.contabilidad.seguridad.bitacora.Bitacora;
import mx.fiscoflex.contabilidad.seguridad.bitacora.BitacoraService;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BitacoraServiceTest {
	
	@Inject
	private BitacoraService bitacoraService;

	@Deployment
	 public static WebArchive createArchive() {
		WebArchive webArchive = ShrinkWrap.create(WebArchive.class)
				.addAsResource(EmptyAsset.INSTANCE,"META-INF/beans.xml")
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addPackage("mx.fiscoflex.contabilidad.persistencia.contabilidad")
				.addPackage("mx.fiscoflex.contabilidad.util")
				.addPackage("mx.fiscoflex.contabilidad.exception")
				.addPackage("mx.fiscoflex.contabilidad.seguridad.bitacora");		
		
		  JavaArchive[] lib = Maven.resolver().loadPomFromFile("pom.xml")
				    .resolve("joda-time:joda-time:2.2").withTransitivity()
				    .as(JavaArchive.class);
		  webArchive.addAsLibraries(lib);	
		  
		  lib = Maven.resolver().loadPomFromFile("pom.xml")
				    .resolve("commons-codec:commons-codec:1.9").withTransitivity()
				    .as(JavaArchive.class);
		  webArchive.addAsLibraries(lib);	
		  
		  lib = Maven.resolver().loadPomFromFile("pom.xml")
				    .resolve("org.apache.commons:commons-lang3:3.1").withTransitivity()
				    .as(JavaArchive.class);
		  webArchive.addAsLibraries(lib);
		  
		  lib = Maven.resolver().loadPomFromFile("pom.xml")
				    .resolve("com.google.code.gson:gson:2.2.4").withTransitivity()
				    .as(JavaArchive.class);
		  webArchive.addAsLibraries(lib);	
		  		 
		System.out.println(webArchive.toString(true));
		
		return webArchive;
	 }
	
	@Test
	public void crearBitacora() {
		
		
		Bitacora bitacora = new Bitacora();
		bitacora.setIdBitacora(UUID.randomUUID().toString());
		bitacora.setIdAccion("fydfh");
		bitacoraService.crearBitacora(bitacora);
	}
}
