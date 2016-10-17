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
 * Servlet implementation class ReportesVentasFranja
 */
@WebServlet("/ReportesVentasFranja")
public class ReporteVentasFranja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteVentasFranja() {
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
			httpS.setAttribute("HI", null);
			httpS.setAttribute("HF", null);
			response.sendRedirect(request.getContextPath() + "/opciones.html");
		}else{
			String HI = (String) request.getParameter("h_inicio");
			String HF = (String) request.getParameter("h_fin");
			System.out.println("Hora de Inicio: "+HI);
			System.out.println("Hora de Fin: "+HF);
			HttpSession httpS = request.getSession();
			httpS.setAttribute("HI", HI);
			httpS.setAttribute("HF", HF);
			RequestDispatcher rd = request.getRequestDispatcher("/ventas_hora.jsp");
			rd.forward(request, response);
		}
	}
}

