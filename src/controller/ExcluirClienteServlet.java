package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.ClienteDlo;

/**
 * Servlet implementation class ExcluirClienteServlet
 */
@WebServlet(
		urlPatterns = { "/ExcluirClienteServlet" }, 
		initParams = { 
				@WebInitParam(name = "id", value = "int")
		})
public class ExcluirClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirClienteServlet() {
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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		ClienteDlo dlo = new ClienteDlo();
		if(dlo.deletar(Integer.parseInt(this.getInitParameter("id")))) {
			RequestDispatcher rd = request.getRequestDispatcher("/ClienteGridServlet");
			rd.forward(request, response);	
		} else {
			System.out.println("ERRO: não foi possível excluir o cliente " + this.getInitParameter("id"));
		}
			
	}
}
