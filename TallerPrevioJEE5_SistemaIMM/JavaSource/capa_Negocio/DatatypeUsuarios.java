package capa_Negocio;


public class DatatypeUsuarios {
	private String nombre;
	private String secretoUsuario;
	public DatatypeUsuarios (String nombre, String secretoUsuario){
		this.nombre = nombre;
		this.secretoUsuario = secretoUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSecretoUsuario() {
		return secretoUsuario;
	}
	public void setSecretoUsuario(String secretoUsuario) {
		this.secretoUsuario = secretoUsuario;
	}

}
	
	
	

