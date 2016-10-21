package modelo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import capa_Persistencia.ManagerPersistencia;
import modelo.Usuario;

@ManagedBean
@RequestScoped
public class TablaManagedBean implements Serializable{
	private Tabla tabla = new Tabla();
	private String combo1;
	
	public String getCombo1() {
		return combo1;
	}

	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}

	public TablaManagedBean() {
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		tabla = managerPersistencia.getColeccionTickets();
		DatatypeRegistroTickets datatypeRegistroTickets = tabla.getRegistrosTickets().get(0);
		Long nroTicket = datatypeRegistroTickets.getNroTicket();
		System.out.println("TABLA de transacciones totales cargada ");
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}
	
	public String accion(){
		System.out.println("redirigiendo a pagina index.jsp desde TablaManagedBean");
		return "index.jsp";
	}	
	
	public String accioncombo1(){
		String opcioncombo = this.getCombo1();
		System.out.println("Procesando seleccion de combo1: " + opcioncombo);
		if (opcioncombo.equals("ReportePorMes")){
			return "reportePorMes.jsp";
		}
		else {
			if (opcioncombo.equals("ReportePorRango")){
				return "reportePorRango.jsp";
			}
		}
		return "index.jsp";
	}	

}
