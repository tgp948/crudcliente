package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDlo;

/**
 * Servlet implementation class ManterClinteServlet
 */
@WebServlet("/ManterClinteServlet")
public class ManterClinteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterClinteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//esponse.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");	
		String strDate = request.getParameter("datnasc");
		try {
			cliente.setDatnasc(formato.parse(strDate));
		}catch(Exception e) {
			e.getStackTrace();
		}
		cliente.setEstcivil(request.getParameter("estcivil"));
		System.out.println("ATIVO: " + request.getParameter("ativo"));
		//cliente.setAtivo(request.getParameter("ativo"));
		cliente.setSexo(request.getParameter("sexo"));
		
		ClienteDlo dlo = new ClienteDlo();
		dlo.cadastrar(cliente);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index");
        rd.forward(request, response);
        
	}
	
}
