package modelo;

import java.util.Date;

public class DatatypeRegistroTickets {
	private Long nroTicket;
	private Long idAgencia;
	private Date fechaVenta;
	private Date fechaInicioServicio;
	private Integer minutos;
	private float importe;
	private String estado;
	private String matriculaAuto;
	public String getMatriculaAuto() {
		return matriculaAuto;
	}
	public void setMatriculaAuto(String matriculaAuto) {
		this.matriculaAuto = matriculaAuto;
	}
	public Long getNroTicket() {
		return nroTicket;
	}
	public void setNroTicket(Long nroTicket) {
		this.nroTicket = nroTicket;
	}
	public Long getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Date getFechaInicioServicio() {
		return fechaInicioServicio;
	}
	public void setFechaInicioServicio(Date fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
