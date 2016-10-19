package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabla {
	private List<DatatypeRegistroTickets> registrosTickets = new ArrayList<DatatypeRegistroTickets>();

	public List<DatatypeRegistroTickets> getRegistrosTickets() {
		return registrosTickets;
	}

	public void setRegistrosTickets(List<DatatypeRegistroTickets> registrosTickets) {
		this.registrosTickets = registrosTickets;
	}
	
}
