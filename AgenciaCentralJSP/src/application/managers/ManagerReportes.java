package application.managers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.beans.TicketBean;
import application.persistencia.PersistenciaTickets;



/**
 * Servlet implementation class ManagerReportes
 */
@WebServlet("/ManagerReportes")
public class ManagerReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReportes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String O = (String) request.getParameter("opciones");
				System.out.println("Opción seleccionada: "+O);
				
				 switch (O) {
		         case "cerrar":{
		        	 HttpServletRequest R = (HttpServletRequest) request;
		        	 if (R.getSession() != null) {
		        	     R.getSession().invalidate();
		        	     System.out.println("Se cierra la sesión");
		        	     //RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		     			 //rd.forward(request, response);
		        	     response.sendRedirect(request.getContextPath() + "/login.html");
		        	 }
		        	 break;
		         }
		         case "ventas_d":{
		        	 System.out.println("Se desea reporte de ventas por dia");
		        	 PersistenciaTickets PT = new PersistenciaTickets();
		        	 ArrayList <TicketBean> lista_tickets = new ArrayList<TicketBean>();
		        	 lista_tickets = PT.lista_ticket_BD();
		    		 HttpSession httpS = request.getSession();
		    		 httpS.setAttribute("lista_tickets", lista_tickets);
		    		 RequestDispatcher rd = request.getRequestDispatcher("/ventas_dia.jsp");
		 			 rd.forward(request, response);
		 			 break;
		         }
		         case "ventas_h":{
		        	 System.out.println("Se desea reporte de ventas por hora");
		    	     //RequestDispatcher rd = request.getRequestDispatcher("/alta_pelicula.html");
		 			 //rd.forward(request, response);
		        	 response.sendRedirect(request.getContextPath() + "/ventas_hora.jsp");
		        	 break;
		         }
		         case "listado":{
		        	 System.out.println("Se desea generar un listado");
		        	 RequestDispatcher rd = request.getRequestDispatcher("/listados.jsp");
		 			 rd.forward(request, response);
		 			 break;
		         }
		         
		         case "alq_o_res":{
		        	 System.out.println("Se desea alquilar o reservar una pelicula");
		     		 //socios lista_socios = socios.getInstance();
		    		 //peliculas lista_peliculas = peliculas.getInstance();
		    		 HttpSession httpS = request.getSession();
		    		 //httpS.setAttribute("lista_socios", lista_socios);
		    		 //httpS.setAttribute("lista_peliculas", lista_peliculas);
		        	 RequestDispatcher rd = request.getRequestDispatcher("/alquiler_o_reserva.jsp");
		 			 rd.forward(request, response);
		 			 break;
		         }
		     }
				
			}

		}