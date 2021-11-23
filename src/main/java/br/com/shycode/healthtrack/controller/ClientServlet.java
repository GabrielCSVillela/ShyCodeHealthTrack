package br.com.shycode.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class CadastrarRestauranteServlet
 */
@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientDAO daoClient;;

	@Override
	public void init() throws ServletException {
		super.init();
		daoClient = DAOFactory.getClientDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "list":
			list(request, response);
			break;
		case "open-form-update":
			openFormUpdate(request, response);
			break;
		case "open-form-register":
			openFormRegister(request, response);
			break;
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailClient = (String) session.getAttribute("user");
		Client client = daoClient.selectByEmail(emailClient);
		request.setAttribute("client", client);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	private void openFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailClient = (String) session.getAttribute("user");
		Client client = daoClient.selectByEmail(emailClient);
		request.setAttribute("client", client);
		request.getRequestDispatcher("myprofile.jsp").forward(request, response);
	}

	private void openFormRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("create-account2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("action");

		switch (acao) {
		case "register":
			register(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("codigo"));
		try {
			daoClient.delete(idClient);

			request.setAttribute("msg", "Cliente removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		list(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idClient = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");

			SimpleDateFormat birthFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dateBirth = Calendar.getInstance();
			dateBirth.setTime(birthFormat.parse(request.getParameter("birthday")));

			int height = Integer.parseInt(request.getParameter("height"));

			Client client = new Client(idClient, name, lastName, email, password, phone, dateBirth, height);
			daoClient.update(client);

			request.setAttribute("msg", "Cliente atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		list(request, response);
	}

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");

			SimpleDateFormat birthFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dateBirth = Calendar.getInstance();
			dateBirth.setTime(birthFormat.parse(request.getParameter("birthday")));

			int height = Integer.parseInt(request.getParameter("height"));

			Calendar dateRecord = Calendar.getInstance();

			Client client = new Client(0, name, lastName, email, password, phone, dateBirth, height, dateRecord);
			daoClient.insert(client);

			request.setAttribute("msg", "Cliente cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		openFormRegister(request, response);
	}

}
