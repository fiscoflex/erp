package mx.fiscoflex.erp.persistence.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.fiscoflex.erp.persistence.model.Usuario;

@Stateless
public class UsuarioRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public Usuario usuarioPorNombre(String nombreUsuario) {
		Usuario usuario = entityManager
				.createQuery("FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", Usuario.class)
				.setParameter("nombreUsuario", nombreUsuario).getSingleResult();
		return usuario;
	}

	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
