package application.managers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ManagerFiltroLogin
 */
@WebFilter("/ManagerFiltroLogin")
public class ManagerFiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public ManagerFiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest R = (HttpServletRequest) request;		
		if(R.getSession().getAttribute("autenticado") != null){
			System.out.println("Usuario autenticado pasa filtro");	
			chain.doFilter(request, response);
		}
		else{
			String U = R.getRequestURI();
			boolean intento_login = U.contains("login.html")|| U.contains("ManagerLoginReportes");
			if (intento_login){
				chain.doFilter(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.forward(request, response);
				System.out.println("Intento de acceso no autenticado");
			}
		}			

		// pass the request along the filter chain
		// chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
