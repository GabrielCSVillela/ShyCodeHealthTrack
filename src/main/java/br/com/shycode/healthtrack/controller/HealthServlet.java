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

import br.com.shycode.healthtrack.bean.BloodPressure;
import br.com.shycode.healthtrack.dao.BloodPressureDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class HealthServlet
 */
@WebServlet("/health")
public class HealthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BloodPressureDAO daoBloodPressure;

	@Override
	public void init() throws ServletException {
		super.init();
		daoBloodPressure = DAOFactory.getBloodPressureDAO();
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
		List<BloodPressure> list = daoBloodPressure.select();
		request.setAttribute("bloodPressures", list);
		request.getRequestDispatcher("health.jsp").forward(request, response);
	}

	private void openFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idBloodPressure = Integer.parseInt(request.getParameter("id"));
		BloodPressure bloodPressure = daoBloodPressure.selectById(idBloodPressure);
		request.setAttribute("bloodPressure", bloodPressure);
		request.getRequestDispatcher("update-health.jsp").forward(request, response);
	}

	private void openFormRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register-health.jsp").forward(request, response);
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
		int idBloodPressure = Integer.parseInt(request.getParameter("id"));
		try {
			daoBloodPressure.delete(idBloodPressure);
			request.setAttribute("msg", "Pressão removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		list(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idBloodPressure = Integer.parseInt(request.getParameter("id"));
			Float minPress = Float.parseFloat(request.getParameter("min_press"));
			Float maxPress = Float.parseFloat(request.getParameter("max_press"));

			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Calendar timeMeasurement = Calendar.getInstance();
			timeMeasurement.setTime(timeFormat.parse(request.getParameter("time_measurement")));

			Calendar dateUpdate = Calendar.getInstance();

			BloodPressure bloodPressure = new BloodPressure(idBloodPressure, minPress, maxPress, timeMeasurement,
					dateUpdate);
			daoBloodPressure.update(bloodPressure);

			request.setAttribute("msg", "Pressao atualizada!");
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
			Float minPress = Float.parseFloat(request.getParameter("min_press"));
			Float maxPress = Float.parseFloat(request.getParameter("max_press"));

			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
			Calendar timeMeasurement = Calendar.getInstance();
			timeMeasurement.setTime(timeFormat.parse(request.getParameter("time_measurement")));

			Calendar dateRecord = Calendar.getInstance();
			
			Calendar dateUpdate = Calendar.getInstance();

			BloodPressure bloodPressure = new BloodPressure(0, minPress, maxPress, timeMeasurement,
					dateRecord, dateUpdate);
			daoBloodPressure.insert(bloodPressure);

			request.setAttribute("msg", "Pressao cadastrada!");
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
