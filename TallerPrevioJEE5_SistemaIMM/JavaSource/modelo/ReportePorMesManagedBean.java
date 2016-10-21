package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import capa_Persistencia.ManagerPersistencia;

@ManagedBean
@RequestScoped
public class ReportePorMesManagedBean {
	
	private Tabla tabla = new Tabla();
	private String anio_mes;
	
	public ReportePorMesManagedBean(){
	}

	public String getAnio_mes() {
		return anio_mes;
	}

	public void setAnio_mes(String anio_mes) {
		this.anio_mes = anio_mes;
	}

	public String accion(){
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		System.out.println("Año y mes ingresado: " + ReportePorMesManagedBean.this.anio_mes );
		tabla = managerPersistencia.getColeccionTicketsPorMes(ReportePorMesManagedBean.this.anio_mes);
		System.out.println("TABLA de reportes por mes cargada ");
		return "reportePorMes.jsp";
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}


}
