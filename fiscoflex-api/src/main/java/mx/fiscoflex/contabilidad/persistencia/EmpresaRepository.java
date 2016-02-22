package mx.fiscoflex.contabilidad.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmpresaRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public void guardar(EmpresaEntity empresa) {
		// TODO Auto-generated method stub
		
	}

}
