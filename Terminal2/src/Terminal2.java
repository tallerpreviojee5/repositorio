//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//
//
//public class Terminal2 {
//
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("TERMINAL OO2");
//		Socket clientSocket;
//		try {
//			System.out.println("creando socket en puerto 16000");
//			clientSocket = new Socket("localhost", 16000);
//			System.out.println("creado socket en puerto 16000");
//			
//			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//			BufferedReader in_consola = new BufferedReader( new InputStreamReader(System.in));
//			BufferedReader in_servidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//			
//			boolean AA_OK = false; // Usuario Autenticado y Autorizado
//			String recibido="null";
//			String usuario =null;
//			String password =null; 
//			String terminal = "002";
//			
//			while(!AA_OK){
//				recibido = in_servidor.readLine();
//				System.out.println("Recibido: "+recibido);
//				String[] componentes = recibido.split(" ");
//				switch (componentes[0]){
//				case "401":
//					// Authentication is required and has failed or has not yet been provided
//					switch(componentes[1]){
//					case "AAR":// Autenticado y Autrorizado Requerido
//						System.out.println("Autenticacion / Autorizacion Requeridos");
//						System.out.println("Ingrese Usuario: "); 
//						usuario = in_consola.readLine();
//						System.out.println("Ingrese Password: ");
//						password = in_consola.readLine();
//						out.print(usuario+ "\r\n");  
//						out.print(password + "\r\n");
//						out.print(terminal+ "\r\n");
//				        out.flush();
//						break;
//					case "UPI":// Usuario Password Incorrecto
//						System.out.println("Usuario Password Incorrecto");
//						System.out.println("Ingrese Usuario: "); 
//						usuario = in_consola.readLine();
//						System.out.println("Ingrese Password: ");
//						password = in_consola.readLine();
//						out.print(usuario+ "\r\n");  
//						out.print(password + "\r\n");
//						out.print(terminal+ "\r\n");
//				        out.flush();
//						break;
//					case "TNA":// Terminal No Autorizada
//						System.out.println("Terminal No Autorizada");
//						System.out.println("Ingrese Usuario: "); 
//						usuario = in_consola.readLine();
//						System.out.println("Ingrese Password: ");
//						password = in_consola.readLine();
//						out.print(usuario+ "\r\n");  
//						out.print(password + "\r\n");
//						out.print(terminal+ "\r\n");
//				        out.flush();
//						break;
//					};
//					break;
//				case "200":
//					AA_OK=true;
//					System.out.println("ACCESO AUTORIZADO Y AUTENTICADO ");
//					break;
//				}
//			}
//			
//			
//			
//			String matricula=null;
//			String minutos =null;
//			String opcion = "0";
//			
//			while (!opcion.equals("3")){
//				System.out.println("OPCIONES: ");
//				System.out.println("1) VENTA DE TICKET");
//				System.out.println("2) CANCELAR TICKET");
//				System.out.println("3) SALIR");
//				opcion = in_consola.readLine();
//				switch(opcion){
//				case "1":
//					System.out.println("Ingrese Matricula");
//					matricula = in_consola.readLine();
//					System.out.println("Ingrese Minutos");
//					minutos = in_consola.readLine();
//					System.out.println("Fecha de inicio de servicio (dd-mm-aaaa): ");
//					String fecha_inicio = in_consola.readLine();
//					System.out.println("Hora de inicio del servicio (HH:mm): ");
//					String hora_inicio = in_consola.readLine();
//					out.print(opcion +" "+ matricula +" "+ minutos +" "+ fecha_inicio +" "+hora_inicio+"\r\n");
//					out.flush();
//					
//					recibido = in_servidor.readLine();
//					System.out.println("Recibido: "+recibido);
//					String[] componentes = recibido.split(" ");
//					if (componentes[0].equals("200")){
//						System.out.println("VENTA EXITOSA");
//					}else{
//						System.out.println("VENTA NO EXITOSA");
//					}
//					break;
//					
//					
//				case "2":
//					System.out.println("Ingrese Matricula");
//					matricula = in_consola.readLine();
//					System.out.println("Ingrese Minutos");
//					minutos = in_consola.readLine();
//					out.print(opcion +" "+ matricula +" "+ minutos + "\r\n");
//					out.flush();
//					break;
//				}
//
//			}
//			out.print(opcion + "\r\n");
//			out.flush();
//			clientSocket.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Terminal2 {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String terminal = "002";
		// Identificacion de Terminal no debe ser manipulada por usuario vendedor
		
		String servidor_agencia = "localhost";
		// Nombre de host del servidor central de la agencia no debe ser manipulado por usuario 
		
		System.out.println("ID TERMINAL " + terminal);
		
		Socket clientSocket;
		try {
			clientSocket = new Socket(servidor_agencia, 16000);
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in_consola = new BufferedReader( new InputStreamReader(System.in));
			BufferedReader in_servidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			boolean AA_OK = false; // Usuario Autenticado y Autorizado
			String recibido= null;
			String usuario = null;
			String password =null; 
			
			
			while(!AA_OK){
				recibido = in_servidor.readLine();
				System.out.println("RECIBIDO: "+recibido);
				String[] componentes = recibido.split(" ");
				switch (componentes[0]){
				case "401":
					// Authentication is required and has failed or has not yet been provided
					switch(componentes[1]){
					case "AAR":// Autenticado y Autrorizado Requerido
						System.out.println("Autenticacion / Autorizacion Requeridos");
						System.out.println("Ingrese Usuario: "); 
						usuario = in_consola.readLine();
						System.out.println("Ingrese Password: ");
						password = in_consola.readLine();
						out.print(usuario+ "\r\n");  
						out.print(password + "\r\n");
						out.print(terminal+ "\r\n");
				        out.flush();
						break;
					case "UPI":// Usuario Password Incorrecto
						System.out.println("Usuario Password Incorrecto");
						System.out.println("Ingrese Usuario: "); 
						usuario = in_consola.readLine();
						System.out.println("Ingrese Password: ");
						password = in_consola.readLine();
						out.print(usuario+ "\r\n");  
						out.print(password + "\r\n");
						out.print(terminal+ "\r\n");
				        out.flush();
						break;
					case "TNA":// Terminal No Autorizada
						System.out.println("Terminal No Autorizada");
						System.out.println("Ingrese Usuario: "); 
						usuario = in_consola.readLine();
						System.out.println("Ingrese Password: ");
						password = in_consola.readLine();
						out.print(usuario+ "\r\n");  
						out.print(password + "\r\n");
						out.print(terminal+ "\r\n");
				        out.flush();
						break;
					};
					break;
				case "200":
					AA_OK=true;
					System.out.println("ACCESO AUTORIZADO Y AUTENTICADO ");
					break;
				}
			}
			
			
			
			String opcion = "0";
			
			while (!opcion.equals("3")){
				String matricula="-";
				String minutos ="-";
				String fecha_inicio="99-99-99";
				String hora_inicio="99:99";
				
				
				System.out.println("OPCIONES: ");
				System.out.println("1) VENTA DE TICKET");
				System.out.println("2) CANCELAR TICKET");
				System.out.println("3) SALIR");
				opcion = in_consola.readLine();
				switch(opcion){
				case "1":
					while (!esAlfanumerico(matricula)){
						System.out.println("Ingrese Matricula");
						matricula = in_consola.readLine();
					}
					while (!esNumeroEntero(minutos)){
						System.out.println("Ingrese Minutos");
						minutos = in_consola.readLine();
					}
					while (!formatoFechaOK(fecha_inicio)){
						System.out.println("Ingrese fecha de inicio de servicio (dd-mm-aaaa): ");
						fecha_inicio = in_consola.readLine();
					}
					while (!formatoHoraOK(hora_inicio)){
						System.out.println("Ingrese hora de inicio del servicio (HH:MM): ");
						hora_inicio = in_consola.readLine();
					}
					
					// Datos de entrada OK, se envia a servidor Agencia Central
					out.print(opcion +" "+ matricula +" "+ minutos +" "+ fecha_inicio +" "+hora_inicio+"\r\n");
					out.flush();
					
					recibido = in_servidor.readLine();
					System.out.println("Recibido: "+recibido);
					String[] componentes = recibido.split(" ");
					if (componentes[0].equals("200")){
						System.out.println("VENTA EXITOSA");
						System.out.println("Datos de la venta:");
						System.out.println("-----------------------------------------");
						System.out.println("Nro Ticket: " + componentes[1]);
						System.out.println("Importe: "    + componentes[2]);
						System.out.println("Minutos: "    + componentes[3]);
						System.out.println("Matricula: "  + componentes[4]);
						System.out.println("Fecha/Hora inicio servicio: " + componentes[5]);
						System.out.println("Terminal de venta: " + componentes[6]);
						System.out.println("Fecha/Hora venta: "  + componentes[7]);
						System.out.println("-----------------------------------------");
					}else{
						System.out.println("VENTA NO EXITOSA");
					}
					
					System.out.println("Presione Enter para volver al menu");
					in_consola.readLine();
					break;
					
					
				case "2":
					System.out.println("Ingrese Matricula");
					matricula = in_consola.readLine();
					System.out.println("Ingrese Minutos");
					minutos = in_consola.readLine();
					out.print(opcion +" "+ matricula +" "+ minutos + "\r\n");
					out.flush();
					break;
				}

			}
			out.print(opcion + "\r\n");
			out.flush();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static boolean esAlfanumerico (String entrada){
		boolean resultado = false;
		String regex= "^[a-zA-Z0-9]*$";
		if (entrada.matches(regex)){
			resultado = true;
		}
		return resultado;
		
	}
	private static boolean esNumeroEntero (String entrada){
		boolean resultado = false;
		String regex= "^[0-9]*$";
		if (entrada.matches(regex)){
			resultado = true;
		}
		return resultado;
		
	}
	private static boolean formatoFechaOK (String entrada){
		boolean resultado = false;
		String[] componentes = entrada.split("-");
		// Entrada debe tener formato dd-mm-aaaa
		String dd=componentes[0];
		String mm=componentes[1];
		String aaaa=componentes[2];
		
		String regex_dd= "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])$";
		// dd entre 01 y 31
		
		String regex_mm= "^(0[1-9]|1[0-2])$";
		// mm entre 01 y 12
		
		String regex_aaaa= "^[0-9]{4}$";
		// aaaa numero de 4 digitos
		
		if (dd.matches(regex_dd)){
			//dd OK
			if (mm.matches(regex_mm)){
				// dd OK y mm OK
				if (aaaa.matches(regex_aaaa)){
					// dd OK, mm OK y aaaa OK
					resultado = true;
				}	
			}
		}
		return resultado;	
	}
	private static boolean formatoHoraOK (String entrada){
		boolean resultado = false;
		String[] componentes = entrada.split(":");
		// Entrada debe tener formato dd-mm-aaaa
		String HH=componentes[0];
		String MM=componentes[1];
		
		String regex_HH = "^(0[0-9]|1[0-9]|2[0-3])$";
		// HH entre 00 y 23
		
		String regex_MM= "^(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])$";
		// MM entre 00 y 59
		

		if (HH.matches(regex_HH)){
			//HH OK
			if (MM.matches(regex_MM)){
				// HH OK y MM OK
				resultado = true;
			}
		}
		return resultado;	
	}

}
// Cambio introducido para probar git BLA BLA BLA
