package webserviceIMM;

import java.util.Date;

public class DatatypeVenta {
	private Long IdAgencia;
	private String secretoAgencia;
	private String MatriculaAuto;
	private Date FechaVenta;
	private Date FechaInicioServicio;
	private Integer Minutos;
	private Long NroTicket;
	private Long Importe;
	private String mensaje;
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getSecretoAgencia() {
		return secretoAgencia;
	}
	public void setSecretoAgencia(String secretoAgencia) {
		this.secretoAgencia = secretoAgencia;
	}

	public Long getImporte() {
		return Importe;
	}
	public void setImporte(Long importe) {
		Importe = importe;
	}
	public Long getIdAgencia() {
		return IdAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		IdAgencia = idAgencia;
	}
	public String getMatriculaAuto() {
		return MatriculaAuto;
	}
	public void setMatriculaAuto(String matriculaAuto) {
		MatriculaAuto = matriculaAuto;
	}
	public Date getFechaVenta() {
		return FechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}
	public Date getFechaInicioServicio() {
		return FechaInicioServicio;
	}
	public void setFechaInicioServicio(Date fechaInicioServicio) {
		FechaInicioServicio = fechaInicioServicio;
	}
	public Integer getMinutos() {
		return Minutos;
	}
	public void setMinutos(Integer minutos) {
		Minutos = minutos;
	}
	public Long getNroTicket() {
		return NroTicket;
	}
	public void setNroTicket(Long nroTicket) {
		NroTicket = nroTicket;
	}


}
