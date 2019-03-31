package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDlo;

/**
 * Servlet implementation class ExcLoteClienteServlet
 */
@WebServlet(
		urlPatterns = { "/ExcLoteClienteServlet" }, 
		initParams = { 
				@WebInitParam(name = "listId", value = "int[50]")
		})
public class ExcLoteClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcLoteClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	/*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ClienteDlo dlo = new ClienteDlo();
		int[] intListaId = new int[50];
		String strListaId = this.getInitParameter("listId");
		
		
		Cliente cliente = dlo.deletarLote(Integer.this.getInitParameter("listId"));
		}*/
}
