package br.com.shycode.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class CadastrarRestauranteServlet
 */
@WebServlet("/cliente")
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
		String action = request.getParameter("acao");

		switch (action) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> list = daoClient.select();
		request.setAttribute("clientes", list);
		request.getRequestDispatcher("??.jsp").forward(request, response);
	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("codigo"));
		Client client = daoClient.selectById(idClient);
		request.setAttribute("cliente", client);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.getRequestDispatcher("create-account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClient = Integer.parseInt(request.getParameter("codigo"));
		try {
			daoClient.delete(idClient);

			request.setAttribute("msg", "Cliente removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idClient = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");

			SimpleDateFormat birthFormat = new SimpleDateFormat("dd/MM/yyyy");
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
		listar(request, response);
	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");

			SimpleDateFormat birthFormat = new SimpleDateFormat("dd/MM/yyyy");
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
		abrirFormCadastro(request, response);
	}

}
