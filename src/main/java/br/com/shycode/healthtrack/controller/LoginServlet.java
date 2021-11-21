package br.com.shycode.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.factory.DAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientDAO dao;

	public LoginServlet() {
		dao = DAOFactory.getClientDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		Client client = new Client(email, senha);

		if (dao.validateClient(client)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			
		} else {
			request.setAttribute("erro", "Usuario e/ou senha invalidos");
		}
		request.getRequestDispatcher("sign-in.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("sign-in.jsp").forward(request, response);
	}

}
