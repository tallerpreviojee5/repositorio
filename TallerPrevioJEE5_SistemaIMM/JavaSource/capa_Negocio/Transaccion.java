package capa_Negocio;

import java.util.Date;

public class Transaccion {
	private long idTransaccion;
	private String nroTicket;
	private Agencia agencia;
	private String matriculaAuto;
	private Date fechaVenta;
	private Date fechaInicio;
	private Integer minutos;
	private float importe;
	public enum Estado {
	    ACTIVO, TERMINADO, CANCELADO 
	}
	private Estado estado;
	
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public long getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(long idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public String getMatriculaAuto() {
		return matriculaAuto;
	}

	public void setMatriculaAuto(String matriculaAuto) {
		this.matriculaAuto = matriculaAuto;
	}

	
	
	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	
	public Transaccion(){}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

}
