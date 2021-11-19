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

import br.com.shycode.healthtrack.bean.Activity;
import br.com.shycode.healthtrack.dao.ActivityDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class ActivityServlet
 */
@WebServlet("/activity")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ActivityDAO daoActivity;

	@Override
	public void init() throws ServletException {
		super.init();
		daoActivity = DAOFactory.getActivityDAO();
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
		List<Activity> list = daoActivity.select();
		request.setAttribute("activities", list);
		request.getRequestDispatcher("??.jsp").forward(request, response);
	}

	private void openFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idActivity = Integer.parseInt(request.getParameter("id"));
		Activity activity = daoActivity.selectById(idActivity);
		request.setAttribute("activity", activity);
	}

	private void openFormRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register-activity.jsp").forward(request, response);
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
		int idActivity = Integer.parseInt(request.getParameter("id"));
		try {
			daoActivity.delete(idActivity);
			request.setAttribute("msg", "Cliente removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		list(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idActivity = Integer.parseInt(request.getParameter("id"));
			String nameActivity = request.getParameter("name_activity");
			int calorie = Integer.parseInt(request.getParameter("calorie"));

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
			Calendar timeStart = Calendar.getInstance();
			timeStart.setTime(timeFormat.parse(request.getParameter("time_start")));

			Calendar timeEnd = Calendar.getInstance();
			timeEnd.setTime(timeFormat.parse(request.getParameter("time_end")));

			Calendar dateUpdate = Calendar.getInstance();

			Activity activity = new Activity(idActivity, nameActivity, calorie, timeStart, timeEnd, dateUpdate);
			daoActivity.update(activity);

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
			String nameActivity = request.getParameter("name_activity");
			int calorie = Integer.parseInt(request.getParameter("calorie"));

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
			Calendar timeStart = Calendar.getInstance();
			timeStart.setTime(timeFormat.parse(request.getParameter("time_start")));

			Calendar timeEnd = Calendar.getInstance();
			timeEnd.setTime(timeFormat.parse(request.getParameter("time_end")));

			Calendar dateRecord = Calendar.getInstance();

			Activity activity = new Activity(0, nameActivity, calorie, timeStart, timeEnd, dateRecord);
			daoActivity.insert(activity);

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
