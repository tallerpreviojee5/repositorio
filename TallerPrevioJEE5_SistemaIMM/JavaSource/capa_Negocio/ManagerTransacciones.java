package capa_Negocio;


import capa_Persistencia.ManagerPersistencia;
import webserviceIMM.DatatypeVenta;

public class ManagerTransacciones {
	
	//Singleton ManagerTransacciones
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
}
