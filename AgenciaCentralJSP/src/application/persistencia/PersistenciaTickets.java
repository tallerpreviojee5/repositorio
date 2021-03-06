package application.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import application.beans.TicketBean;
import application.beans.TicketBean.Estado;
import application.managers.ManagerPersistencia;

public class PersistenciaTickets {
	
	private ManagerPersistencia managerPersistencia = ManagerPersistencia.getPersistencia();
//	private Connection connection = managerPersistencia.conexion_agenciadb();
	private Connection connection = null;
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public boolean alta_ticket_BD(TicketBean ticketBean) throws Exception{
		
		boolean resultado = false;
		
		long nroTicket = ticketBean.getNroTicket();
		String matricula = ticketBean.getMatricula();
		
		Date fechaHoraVenta = ticketBean.getFechaHoraVenta();
		Object sqlFechaHoraVenta = new java.sql.Timestamp(fechaHoraVenta.getTime());
		
		long importe = ticketBean.getImporte();
		long idTerminal = ticketBean.getIdTerminal();
		Estado estado = ticketBean.getEstado();
		
		String query = "INSERT INTO tickets " + 
		               "(nroTicket,matricula,fechaHoraVenta,importe,idTerminal,estado) " +
				       "values(?,?,?,?,?,?)";
		
		try {
			connection = managerPersistencia.conexion_agenciadb();
			pstmt = connection.prepareStatement(query);
			
			pstmt.setLong(1,nroTicket);
			pstmt.setString(2, matricula);
			pstmt.setObject(3, sqlFechaHoraVenta);
			pstmt.setLong(4, importe);
			pstmt.setLong(5, idTerminal);
			pstmt.setString(6, estado.name());
			
			if(pstmt.executeUpdate() > 0){
				resultado = true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw (new Exception());
		}
		
		finally{
			
			try{
				if(pstmt != null){	
					pstmt.close();
				}
				if(connection != null){ 
					connection.close();
				}
				
			} catch (SQLException e) {
				System.out.println("Error al liberar los recursos en alta de ticket");
				e.printStackTrace();
				throw (new Exception());
			}
		}
		
		return resultado;
		
	}
	public ArrayList <TicketBean> lista_ticket_BD(){
		ArrayList <TicketBean> resultado = new ArrayList<TicketBean>();
		String columnas = "nroTicket, matricula, fechaHoraVenta, importe, idTerminal, estado";
		String tabla = "tickets";
		String SQL= "SELECT "+ columnas + " FROM " + tabla;
		System.out.println("Consulta a base: "+ SQL);
		try {
			connection = managerPersistencia.conexion_agenciadb();
			pstmt = connection.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery(SQL);
			while (rs.next()) {
				TicketBean T = new TicketBean();
				System.out.println("=============================================");
				System.out.println("nroTicket "+ rs.getLong("nroTicket"));
				T.setNroTicket(rs.getLong("nroTicket"));
				
				System.out.println("matricula "+ rs.getString("matricula"));
				T.setMatricula(rs.getString("matricula"));
				
				System.out.println("fechaHoraVenta "+ rs.getTimestamp("fechaHoraVenta"));
				T.setFechaHoraVenta(rs.getTimestamp("fechaHoraVenta"));
				
				System.out.println("importe "+ rs.getLong("importe"));
				T.setImporte(rs.getLong("importe"));
				
				System.out.println("idTerminal "+ rs.getLong("idTerminal"));
				T.setIdTerminal(rs.getLong("idTerminal"));
				
				System.out.println("estado "+ rs.getString("estado") );
				Estado estado = Estado.valueOf(rs.getString("estado"));
				System.out.println("=============================================");
				T.setEstado(estado);
				resultado.add(T);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	
public String get_estado_ticket_BD(long nroTicket){
		
		String estado = "";
		String query = "SELECT estado FROM tickets " + 
					   "WHERE nroTicket = ?";
		try{
			connection = managerPersistencia.conexion_agenciadb();
			
			pstmt = connection.prepareStatement(query);
			
			pstmt.setLong(1,nroTicket);
						
			rs = pstmt.executeQuery();
						
			if(rs.next()) {
				estado = rs.getString("estado");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			try{
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if (connection != null) 
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
		return estado;
	}
	
	public void cancelar_ticket_BD(long nroTicket){
		
		try{
			
			connection = managerPersistencia.conexion_agenciadb();
			
			String query = "UPDATE tickets " +
				   	   "SET estado = 'CANCELADO' " +
				       "WHERE nroTicket = ?";
	
			pstmt = connection.prepareStatement(query);
			
			pstmt.setLong(1, nroTicket);
		
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			try{
				if(rs != null)
					rs.close();
				if(connection != null) 
					connection.close();
				if(pstmt != null)
					pstmt.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
}	
	
}

