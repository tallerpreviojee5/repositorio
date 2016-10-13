package application.reportes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReporteVentasDia
 */
@WebServlet("/ReporteVentasDia")
public class ReporteVentasDia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteVentasDia() {
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
		String opt = request.getParameter("opt");
		if (opt.equals("VOLVER")){
			HttpSession httpS = request.getSession();
			httpS.setAttribute("F", null);
			response.sendRedirect(request.getContextPath() + "/opciones.html");
		}else{
			String F = (String) request.getParameter("dia");
			System.out.println("La fecha solicitada es: "+F);
			HttpSession httpS = request.getSession();
			httpS.setAttribute("F", F);
			RequestDispatcher rd = request.getRequestDispatcher("/ventas_dia.jsp");
			rd.forward(request, response);
		}
	}

}
