package mx.fiscoflex.erp.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Empresa;

public class EmpresaRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public void guardar(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

}
