package mx.fiscoflex.api.usuario;

public class CambioPasswordDTO {

	private String nombreUsuario;
	
	private String passwordAnterior;
	
	private String nuevoPassword;	

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordAnterior() {
		return passwordAnterior;
	}

	public void setPasswordAnterior(String passwordAnterior) {
		this.passwordAnterior = passwordAnterior;
	}

	public String getNuevoPassword() {
		return nuevoPassword;
	}

	public void setNuevoPassword(String nuevoPassword) {
		this.nuevoPassword = nuevoPassword;
	}
}
