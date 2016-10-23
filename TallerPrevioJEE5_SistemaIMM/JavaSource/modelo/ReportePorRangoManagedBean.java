package modelo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import capa_Persistencia.ManagerPersistencia;

@ManagedBean
@RequestScoped
public class ReportePorRangoManagedBean {
	private Tabla tabla = new Tabla();
	private String fecha_inicio;
	private String fecha_fin;
	
	public ReportePorRangoManagedBean(){
		
	}


	public String accion(){
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		System.out.println("Fecha de inicio ingresada: " + ReportePorRangoManagedBean.this.fecha_inicio );
		System.out.println("Fecha de fin ingresada: " + ReportePorRangoManagedBean.this.fecha_fin );
		tabla = managerPersistencia.getColeccionTicketsPorMes(ReportePorRangoManagedBean.this.fecha_inicio, ReportePorRangoManagedBean.this.fecha_fin );
		System.out.println("TABLA de reportes por rango cargada ");
		return "reportePorRango.jsp";
	}
	
	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public String getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	
	public Tabla getTabla() {
		return tabla;
	}


	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}	
	

}
