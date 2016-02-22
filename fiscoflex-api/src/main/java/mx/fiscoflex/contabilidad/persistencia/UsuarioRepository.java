package mx.fiscoflex.contabilidad.persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioRepository {

	@PersistenceContext(name = "fiscoflexpu")
	private EntityManager entityManager;
	
	public UsuarioEntity usuarioPorId(String nombreUsuario) {
		UsuarioEntity usuario = entityManager
				.createQuery("FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", UsuarioEntity.class)
				.setParameter("nombreUsuario", nombreUsuario).getSingleResult();
		return usuario;
	}
	
	public UsuarioEntity usuarioPorNombre(String nombreUsuario) {
		UsuarioEntity usuario = entityManager
				.createQuery("FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", UsuarioEntity.class)
				.setParameter("nombreUsuario", nombreUsuario).getSingleResult();
		return usuario;
	}

	public void guardar(UsuarioEntity usuario) {
		// TODO Auto-generated method stub
		
	}
}
