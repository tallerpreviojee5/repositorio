package modelo;

public class ReportePorRangoManagedBean {
	private Tabla tabla = new Tabla();
	private String fecha_inicio;
	private String fecha_fin;
	
	public ReportePorRangoManagedBean(){
		
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


	public String accion(){
		return "menu.jsp";
	}
	

}
