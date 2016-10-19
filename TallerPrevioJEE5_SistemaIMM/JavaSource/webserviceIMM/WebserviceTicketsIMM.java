package webserviceIMM;

import javax.jws.WebService;

import capa_Negocio.ManagerTransacciones;

@WebService
public class WebserviceTicketsIMM {
	public DatatypeVenta Venta (DatatypeVenta dataTypeVenta){
		ManagerTransacciones managerTransacciones = ManagerTransacciones.getInstance();
		return managerTransacciones.Venta(dataTypeVenta);
	}
	
	public boolean CancelarTicket(long NroTicket, long idAgencia, String secretoAgencia){
		
		boolean resultado = false;
		
		try{
			
			ManagerTransacciones managerTransacciones = ManagerTransacciones.getInstance();
		
			if(managerTransacciones.cancelarTicket(NroTicket, idAgencia, secretoAgencia)){
				resultado = true;
				System.out.println("[SistemaImm][WebserviceTickets]Cancelado ticket Nro " + NroTicket);
			}else{
				System.out.println("[SistemaImm][WebserviceTickets]Error al cancelar ticket Nro " + NroTicket);
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
	}

}
