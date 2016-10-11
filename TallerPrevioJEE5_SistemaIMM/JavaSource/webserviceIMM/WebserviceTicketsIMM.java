package webserviceIMM;

import javax.jws.WebService;

import capa_Negocio.ManagerTransacciones;

@WebService
public class WebserviceTicketsIMM {
	public DatatypeVenta Venta (DatatypeVenta dataTypeVenta){
		ManagerTransacciones managerTransacciones = ManagerTransacciones.getInstance();
		return managerTransacciones.Venta(dataTypeVenta);
	}

}
