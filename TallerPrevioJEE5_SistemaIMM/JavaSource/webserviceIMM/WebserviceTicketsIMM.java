package webserviceIMM;

import javax.jws.WebService;

import capa_Negocio.ManagerTransacciones;

@WebService
public class WebserviceTicketsIMM {
	public DatatypeVenta Venta (DatatypeVenta dataTypeVenta){
		ManagerTransacciones managerTransacciones = ManagerTransacciones.getInstance();
		return managerTransacciones.Venta(dataTypeVenta);
	}
	
	public void CancelarTicket(long NroTicket, long idAgencia, String secretoAgencia){
		
		ManagerTransacciones managerTransacciones = ManagerTransacciones.getInstance();
		
		managerTransacciones.cancelarTicket(NroTicket, idAgencia, secretoAgencia);
		
	}

}
