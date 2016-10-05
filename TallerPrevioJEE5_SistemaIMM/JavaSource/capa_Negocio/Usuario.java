package capa_Negocio;

public class Usuario {
	private Integer IdUsuario;
	private String nombre;
	private String password;
	public Integer getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
