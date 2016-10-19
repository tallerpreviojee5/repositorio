package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import capa_Persistencia.ManagerPersistencia;
import modelo.Usuario;

@ManagedBean
@RequestScoped
public class TablaManagedBean {
	private Tabla tabla = new Tabla();
	
	public TablaManagedBean() {
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		tabla = managerPersistencia.getColeccionTickets();
		DatatypeRegistroTickets datatypeRegistroTickets = tabla.getRegistrosTickets().get(0);
		Long nroTicket = datatypeRegistroTickets.getNroTicket();
		System.out.println("TABLA de transacciones: " + nroTicket);
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

}
