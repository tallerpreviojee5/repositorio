package capa_Negocio;

public class DatatypeAgencias {
	private Long idAgencia;
	private String secretoAgencia;
	public DatatypeAgencias (Long idAgencia, String secretoAgencia){
		this.idAgencia = idAgencia;
		this.secretoAgencia = secretoAgencia;
	}
	public Long getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getSecretoAgencia() {
		return secretoAgencia;
	}
	public void setSecretoAgencia(String secretoAgencia) {
		this.secretoAgencia = secretoAgencia;
	}
	
	}
