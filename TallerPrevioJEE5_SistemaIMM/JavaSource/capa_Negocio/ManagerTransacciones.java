package capa_Negocio;


import capa_Persistencia.ManagerPersistencia;
import webserviceIMM.DatatypeVenta;

public class ManagerTransacciones {
	
	//Singleton ManagerTransacciones //comentario para prueba Git desde maquina de Hector 16/10/2016
		private static ManagerTransacciones managerTransacciones;
		private ManagerTransacciones(){
			}
		public static ManagerTransacciones getInstance(){
			 if (managerTransacciones==null) {
			 	 managerTransacciones=new ManagerTransacciones();
			 }
			 return managerTransacciones;
		}
	
	
	public DatatypeVenta Venta (DatatypeVenta datatypeVenta){
		Long idAgencia = datatypeVenta.getIdAgencia();
		String secretoAgencia = datatypeVenta.getSecretoAgencia();
		boolean autenticar = AutenticarAgencia(idAgencia, secretoAgencia);
		if (autenticar){
			ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
			Integer minutos = datatypeVenta.getMinutos();
			Long importe = this.ObtenerImporte(minutos);
			datatypeVenta.setImporte(importe);
			try {
				datatypeVenta = managerPersistencia.altaTicket(datatypeVenta);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			datatypeVenta.setMensaje("400");
		}
		return datatypeVenta;
	}
	
	
	public boolean AutenticarAgencia(Long idAgencia, String secretoAgencia){
		ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
		managerPersistencia.probarConexion();
		return managerPersistencia.AutenticarAgencia(idAgencia, secretoAgencia);
	}
	
	
	
	public Long ObtenerImporte(Integer minutos){
		Long importe;
		importe = minutos*12L;
		return importe;
	}
	
	public boolean cancelarTicket(long NroTicket, long idAgencia, String secretoAgencia){
		
		boolean resultado = false;
		
		try {
			if(AutenticarAgencia(idAgencia, secretoAgencia)){
			
				ManagerPersistencia managerPersistencia = ManagerPersistencia.getInstance();
				
				if(managerPersistencia.cancelarTicket(NroTicket)){
					resultado = true;
					System.out.println("[SistemaImm][ManagerTransacciones]Cancelado ticket Nro " + NroTicket);
				}else{
					System.out.println("[SistemaImm][ManagerTransacciones]Error al cancelar ticket Nro " + NroTicket);
				}
			
			}else{
				System.out.println("[SistemaImm][ManagerTransacciones]Error al autenticar agencia en cancelarTicket Nro " + NroTicket + " con Agencia " + idAgencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultado;
		
}	
	
}
