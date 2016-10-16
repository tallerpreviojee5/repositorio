package application.managers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import application.beans.UsuarioBean;


/**
 * Servlet implementation class ManagerLoginReportes
 */
@WebServlet("/ManagerLoginReportes")
public class ManagerLoginReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuarioBean;
	private ManagerUsuarios managerUsuarios;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginReportes() {
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
		String N = (String) request.getParameter("usuario");
		String P = (String) request.getParameter("password");
		System.out.println("Ingresa el Usuario: "+N);
		System.out.println("con Password: "+P);
		
		usuarioBean = new UsuarioBean();
        usuarioBean.setNombre(N);
        usuarioBean.setPassword(P);
        usuarioBean.setIdTerminal(0);
        managerUsuarios = new ManagerUsuarios();
		
		if (managerUsuarios.validarUsuario(usuarioBean)){
			// Autenticado OK
			// Falta diferenciar problema Autenticacion de Autorizacion
			RequestDispatcher rd = request.getRequestDispatcher("/opciones.html");
			HttpSession S = request.getSession();
			S.setAttribute("autenticado", true);
			rd.forward(request, response);
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
	}

}
