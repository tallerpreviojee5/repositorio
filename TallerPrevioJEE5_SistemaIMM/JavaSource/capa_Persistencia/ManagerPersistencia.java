package capa_Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import webserviceIMM.DatatypeVenta;
import capa_Negocio.ManagerTransacciones;
import capa_Negocio.DatatypeAgencias;
import capa_Negocio.DatatypeUsuarios;
import modelo.DatatypeRegistroTickets;
import modelo.Usuario;
import modelo.Tabla;


public class ManagerPersistencia {
	
	//Singleton ManagerPersistencia
	private static ManagerPersistencia managerPersistencia;
	private ManagerPersistencia(){
		}
	public static ManagerPersistencia getInstance(){
		 if (managerPersistencia==null) {
		 	 managerPersistencia=new ManagerPersistencia();
		 }
		 return managerPersistencia;
	}
	
	public Tabla getColeccionTickets(){
		System.out.println("metodo ManagerPersistencia.getColeccionTickets");
		Tabla coleccion_Tickets = new Tabla();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=establecer_Conexion_IMM();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM transacciones where FechaInicioServicio >= '2016/10/16 00:00:00' and FechaInicioServicio <= '2016/10/20 23:59:59' ");
			ResultSetMetaData rsm = rs.getMetaData();
			
			Long nroTicket;
			Long idAgencia;
			String matriculaAuto;
			Date fechaHoraVenta;
			Date fechaInicioServicio;
			Integer minutos;
			Long importe;
			String estado;
		
					
			while(rs.next()) {
				
				DatatypeRegistroTickets datatype_RegistroTickets = new DatatypeRegistroTickets();
				nroTicket = rs.getLong("NroTicket");
				idAgencia = rs.getLong("idAgencia");
				matriculaAuto = rs.getString("MatriculaAuto");
				fechaHoraVenta = rs.getTimestamp("FechaVenta");
				fechaInicioServicio = rs.getTimestamp("FechaInicioServicio");
				minutos = rs.getInt("Minutos");
				importe = rs.getLong("Importe");
				estado = rs.getString("Estado");
				
				datatype_RegistroTickets.setNroTicket(nroTicket);
				datatype_RegistroTickets.setIdAgencia(idAgencia);
				datatype_RegistroTickets.setMatriculaAuto(matriculaAuto);
				datatype_RegistroTickets.setFechaVenta(fechaHoraVenta);
				datatype_RegistroTickets.setFechaInicioServicio(fechaInicioServicio);
				datatype_RegistroTickets.setMinutos(minutos);
				datatype_RegistroTickets.setImporte(importe);
				datatype_RegistroTickets.setEstado(estado);
				
				coleccion_Tickets.getRegistrosTickets().add(datatype_RegistroTickets);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());

		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
			
		}
		finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null)	stmt.close();
				if (con!=null) con.close();
//				System.out.println("Recursos liberados correctamente luego de obtener la coleccion de alquileres");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al liberar los recursos luego de obtener la coleccion de alquileres");
				e.printStackTrace();
			}

		}
	
		return coleccion_Tickets;
	}
	
	
	public boolean AutenticarUsuario(modelo.Usuario usuario){
		Hashtable coleccion_usuarios = managerPersistencia.getColeccionUsuarios();
		boolean ok = false;
		if(coleccion_usuarios.containsKey(usuario.getNombre())){
			DatatypeUsuarios datatypeUsuarios= (DatatypeUsuarios) coleccion_usuarios.get(usuario.getNombre());
			String secreto_almacenado = datatypeUsuarios.getSecretoUsuario();
			String secreto_ingresado = usuario.getSecreto();			
			if (secreto_ingresado.equals(secreto_almacenado))
		    	ok = true;
					    
		}
		if(ok){
			System.out.println("Usuario autenticado Nombre: " + usuario.getNombre() );			
		}		
		else
		{
			System.out.println("Fallo autenticacion Nombre: " + usuario.getNombre() );			
		}	
		return ok;
	}
		
	
	
	
	public boolean AutenticarAgencia(Long idAgencia, String secretoAgencia){
		Hashtable coleccion_agencias = managerPersistencia.getColeccionAgencias();
		
		boolean ok = false;
		if(coleccion_agencias.containsKey(idAgencia)){
			DatatypeAgencias datatypeAgencias= (DatatypeAgencias) coleccion_agencias.get(idAgencia);
			String secreto_almacenado_string = datatypeAgencias.getSecretoAgencia();
			
			if (secretoAgencia.equals(secreto_almacenado_string))
		    	ok = true;
					    
		}
		if(ok){
			System.out.println("Agencia autenticada idAgencia: " + idAgencia );			
		}		
		else
		{
			System.out.println("Fallo autenticacion idAgencia: " + idAgencia );			
		}	
		return ok;
	}
	
	
	public Hashtable getColeccionAgencias() {
		Hashtable coleccion_agencias = new Hashtable();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=establecer_Conexion();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM agencias");
			ResultSetMetaData rsm = rs.getMetaData();
			
			Long idAgencia;
			String secretoAgencia;
					
			while(rs.next()) {
				
				idAgencia = rs.getLong("idAgencia");
				secretoAgencia = rs.getString("secretoAgencia");
				DatatypeAgencias datatype_agencias = new DatatypeAgencias(idAgencia, secretoAgencia); 
				coleccion_agencias.put(idAgencia, datatype_agencias);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());

		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
			
		}
		finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null)	stmt.close();
				if (con!=null) con.close();
//				System.out.println("Recursos liberados correctamente luego de obtener la coleccion de alquileres");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al liberar los recursos luego de obtener la coleccion de alquileres");
				e.printStackTrace();
			}

		}
		return coleccion_agencias;
	}
	
	
	public Hashtable getColeccionUsuarios() {
		Hashtable coleccion_usuarios = new Hashtable();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con=establecer_Conexion_Usuarios();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM usuarios");
			ResultSetMetaData rsm = rs.getMetaData();
			
			String usuarioAdmin;
			String secretoUsuario;
					
			while(rs.next()) {
				
				usuarioAdmin = rs.getString("nombre");
				secretoUsuario = rs.getString("secreto");
				DatatypeUsuarios datatype_usuarios = new DatatypeUsuarios(usuarioAdmin, secretoUsuario); 
				coleccion_usuarios.put(usuarioAdmin, datatype_usuarios);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch(SQLException e) {
			System.out.println("SQLException: "+e.getMessage());

		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
			
		}
		finally {
			try {
				if (rs!=null) rs.close();
				if (stmt!=null)	stmt.close();
				if (con!=null) con.close();
//				System.out.println("Recursos liberados correctamente luego de obtener la coleccion de alquileres");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al liberar los recursos luego de obtener la coleccion de alquileres");
				e.printStackTrace();
			}

		}
		return coleccion_usuarios;
	}	
	

	
	
	
	public void probarConexion(){
		Connection con = null;
		try {					
			con=establecer_Conexion();			
//			System.out.println("nivel:"+con.getTransactionIsolation());
//			System.out.println("TRANSACTION_NONE:"+Connection.TRANSACTION_NONE);
//			System.out.println("TRANSACTION_READ_COMMITTED:"+Connection.TRANSACTION_READ_COMMITTED);
//			System.out.println("TRANSACTION_READ_UNCOMMITTED:"+Connection.TRANSACTION_READ_UNCOMMITTED);
//			System.out.println("TRANSACTION_REPEATABLE_READ:"+Connection.TRANSACTION_REPEATABLE_READ);
//			System.out.println("TRANSACTION_SERIALIZABLE:"+Connection.TRANSACTION_SERIALIZABLE);
			
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		finally {
			try {
				if (con!=null) con.close();
//				System.out.println("Recursos liberados correctamente luego de probar conexion a la base");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al liberar los recursos");
				e.printStackTrace();
			}

		}
		
	}
	
	public Connection establecer_Conexion(){
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:/tallerpreviojee5agenciasDS");
			con = ds.getConnection();
			System.out.println(con.toString());
			System.out.println("***Conectado a base tallerpreviojee5agencias OK!!!***");
		}catch (SQLException e){
			System.out.println("Error al obtener la conexion: " + e.getMessage());
		}catch (NamingException e1){
			System.out.println("Error de NamingException: " + e1.getMessage() +"  "+ e1.toString());
		}
		
		
//		Connection con = null;
//		try {					
//			Class.forName("com.mysql.jdbc.Driver");						
//			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tallerj2ee?useSSL=false", "root", "root");			
//		} catch(SQLException e) {
//			System.out.println("Se produjo un error al conectar con la base de datos SQL");
//			//System.out.println("SQLException: "+e.getMessage());
//		} catch (ClassNotFoundException e) {
//			System.out.println("ClassNotFoundException: "+e.getMessage());
//		} catch(Exception e) {
//			System.out.println("Exception: "+e.getMessage());
//		}
		return con;
	}

	
public Connection establecer_Conexion_Usuarios(){
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:/usuariosIMM_DS");
			con = ds.getConnection();
			System.out.println(con.toString());
			System.out.println("***Conectado a base usuariosIMM OK!!!***");
		}catch (SQLException e){
			System.out.println("Error al obtener la conexion: " + e.getMessage());
		}catch (NamingException e1){
			System.out.println("Error de NamingException: " + e1.getMessage() +"  "+ e1.toString());
		}

		return con;
}
	
	
	
	
	
	
public Connection establecer_Conexion_IMM(){
		
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:/tallerpreviojee5DS");
			con = ds.getConnection();
			System.out.println(con.toString());
			System.out.println("***Conectado a base tallerpreviojee5 OK!!!***");
		}catch (SQLException e){
			System.out.println("Error al obtener la conexion: " + e.getMessage());
		}catch (NamingException e1){
			System.out.println("Error de NamingException: " + e1.getMessage() +"  "+ e1.toString());
		}
		return con;
}
	
	public DatatypeVenta altaTicket(DatatypeVenta datatypeVenta) throws Exception{
		
		Long idAgencia = datatypeVenta.getIdAgencia();
		String matriculaAuto = datatypeVenta.getMatriculaAuto();
		Date fechaHoraVenta = datatypeVenta.getFechaVenta();
		Object sqlFechaHoraVenta = new java.sql.Timestamp(fechaHoraVenta.getTime());
		Date fechaInicioServicio = datatypeVenta.getFechaInicioServicio();
		Object sqlFechaInicioServicio = new java.sql.Timestamp(fechaInicioServicio.getTime());
		Integer minutos = datatypeVenta.getMinutos();
		Long idTransaccion = datatypeVenta.getNroTicket();
		Long importe = datatypeVenta.getImporte();
		String estado = "ACTIVO";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		System.out.println("Fecha y hora de venta: " + sqlFechaHoraVenta.toString());
		System.out.println("Fecha y hora de Inicio de Servicio: " + sqlFechaInicioServicio.toString());
		
		try {
			con=establecer_Conexion_IMM();	
	        String insertQuery = "INSERT INTO transacciones (IdAgencia, MatriculaAuto, FechaVenta, FechaInicioServicio, Minutos, Importe, Estado) VALUES(?, ?, ?, ?, ?, ?, ?)";
	        pstmt = con.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
	        pstmt.setFloat(1, idAgencia);
	        pstmt.setString(2, matriculaAuto);
	        pstmt.setObject(3, sqlFechaHoraVenta);
	        pstmt.setObject(4, sqlFechaInicioServicio);
	        pstmt.setInt(5, minutos);
	        pstmt.setFloat(6, importe);
	        pstmt.setString(7, estado);
	        
	        int i = pstmt.executeUpdate();
	        
	        ResultSet tableKeys = pstmt.getGeneratedKeys();
	        tableKeys.next();
	        int autoGeneratedID = tableKeys.getInt(1);

	        datatypeVenta.setNroTicket((long) autoGeneratedID);
	        datatypeVenta.setMensaje("200");
	        
			System.out.println(i+" registro/s ingresado/s");
		
		} catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
			datatypeVenta.setMensaje("400");
			throw (new Exception());
		}
		
		finally {
			try {
				if (pstmt!=null)	pstmt.close();
				if (con!=null) con.close();
//				System.out.println("Recursos liberados correctamente luego de dar de alta la pelicula");
			} catch (SQLException e) {
				System.out.println("Ocurrio un error al liberar los recursos en alta pelicula");
				e.printStackTrace();
			}

		}
		return datatypeVenta;
	}

public boolean cancelarTicket(long NroTicket){
		boolean resultado = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
				
		String query = "UPDATE transacciones " +
					   "SET Estado = 'CANCELADO' " +
					   "WHERE NroTicket = ?";
		
		try{
			connection = establecer_Conexion_IMM();
			
			pstmt = connection.prepareStatement(query);
			
			pstmt.setLong(1, NroTicket);
		
			if(pstmt.executeUpdate() > 0){
				
				resultado = true;
				System.out.println("[SistemaImm][ManagerPersistencia]Cancelado ticket Nro " + NroTicket);
				
			}else{
				
				System.out.println("[SistemaImm][ManagerPersistencia]Error al cancelar ticket Nro " + NroTicket);
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		finally{
			try{
				if(pstmt != null)
					pstmt.close();
				if (connection != null) 
					connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return resultado;
}	
	
}
