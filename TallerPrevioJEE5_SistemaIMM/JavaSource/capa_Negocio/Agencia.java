package capa_Negocio;

public class Agencia {
	private Long idAgencia;
	private String secreto;
	private Integer nroAgencia;
	private String direccion;
	
	public Long getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getSecreto() {
		return secreto;
	}
	public void setSecreto(String secreto) {
		this.secreto = secreto;
	}
	public Integer getNroAgencia() {
		return nroAgencia;
	}
	public void setNroAgencia(Integer nroAgencia) {
		this.nroAgencia = nroAgencia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
