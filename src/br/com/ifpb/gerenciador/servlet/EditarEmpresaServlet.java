package br.com.ifpb.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarEmpresaServlet
 */
@WebServlet("/editarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		Empresa empresaSelecionada = null;
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		for (Empresa empresa: lista) {
			if (empresa.getId() == id) {
				empresaSelecionada = empresa;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/formEditEmpresa.jsp");
		request.setAttribute("empresa", empresaSelecionada);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();

		Integer idEmpresa = Integer.valueOf(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		Empresa empresaSelecionada = null;
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		for (Empresa empresa: lista) {
			if (empresa.getId() == idEmpresa) {
				empresaSelecionada = empresa;
			}
		}
		
		empresaSelecionada.setNome(nomeEmpresa);
		empresaSelecionada.setDataAbertura(dataAbertura);
		
		
		response.sendRedirect("listaEmpresas");
	}

}
