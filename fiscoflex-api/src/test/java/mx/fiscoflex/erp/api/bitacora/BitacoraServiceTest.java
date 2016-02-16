package mx.fiscoflex.erp.api.bitacora;

import javax.inject.Inject;

import mx.fiscoflex.erp.api.bitacora.BitacoraDTO;
import mx.fiscoflex.erp.api.bitacora.BitacoraService;

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
				.addPackage("mx.fiscoflex.erp.model")
				.addPackage("mx.fiscoflex.erp.repository")
				.addPackage("mx.fiscoflex.erp.util")
				.addPackage("mx.fiscoflex.erp.api.error")
				.addPackage("mx.fiscoflex.erp.api.bitacora");		
		
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
		  		 
		System.out.println(webArchive.toString(true));
		
		return webArchive;
	 }
	
	@Test
	public void crearBitacora() {
		
		
		BitacoraDTO bitacoraDTO = new BitacoraDTO();
	}
}
