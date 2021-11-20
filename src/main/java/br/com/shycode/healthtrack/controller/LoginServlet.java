package br.com.shycode.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.bo.EmailBO;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.exception.EmailException;
import br.com.shycode.healthtrack.factory.DAOFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientDAO dao;
	private EmailBO bo;

	public LoginServlet() {
		dao = DAOFactory.getClientDAO();
		bo = new EmailBO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		Client client = new Client(email, senha);

		if (dao.validateClient(client)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			String message = "Um login foi realizado";
			try {
				bo.enviarEmail(email, "Login Realizado", message);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
