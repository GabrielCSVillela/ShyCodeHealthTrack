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

import br.com.shycode.healthtrack.bean.Weight;
import br.com.shycode.healthtrack.dao.WeightDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class HealthServlet
 */
@WebServlet("/weight")
public class WeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WeightDAO daoWeight;

	@Override
	public void init() throws ServletException {
		super.init();
		daoWeight = DAOFactory.getWeightDAO();
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
		List<Weight> list = daoWeight.select();
		request.setAttribute("weights", list);
		request.getRequestDispatcher("weight.jsp").forward(request, response);
	}

	private void openFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idWeight = Integer.parseInt(request.getParameter("id"));
		Weight weight = daoWeight.selectById(idWeight);
		request.setAttribute("weight", weight);
		request.getRequestDispatcher("update-weight.jsp").forward(request, response);
	}

	private void openFormRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register-weight.jsp").forward(request, response);
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
		int idWeight = Integer.parseInt(request.getParameter("id"));
		try {
			daoWeight.delete(idWeight);
			request.setAttribute("msg", "Peso removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		list(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idWeight = Integer.parseInt(request.getParameter("id"));
			Float value = Float.parseFloat(request.getParameter("value"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dateMeasurement = Calendar.getInstance();
			dateMeasurement.setTime(dateFormat.parse(request.getParameter("date_measurement")));

			Calendar dateUpdate = Calendar.getInstance();

			Weight weight = new Weight(idWeight, value, dateMeasurement, dateUpdate);
			daoWeight.update(weight);

			request.setAttribute("msg", "Peso atualizado!");
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
			Float value = Float.parseFloat(request.getParameter("value"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar dateMeasurement = Calendar.getInstance();
			dateMeasurement.setTime(dateFormat.parse(request.getParameter("date_measurement")));

			Calendar dateRecord = Calendar.getInstance();

			Calendar dateUpdate = Calendar.getInstance();

			Weight weight = new Weight(0, value, dateMeasurement, dateRecord, dateUpdate);
			daoWeight.insert(weight);

			request.setAttribute("msg", "Peso cadastrado!");
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
