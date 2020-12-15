package br.com.ifpb.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletarEmpresaServlet
 */
@WebServlet("/deletarEmpresa")
public class DeletarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		banco.removeEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}

}
