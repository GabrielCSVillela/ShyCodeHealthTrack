package br.com.shycode.healthtrack.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.shycode.healthtrack.bean.Meal;
import br.com.shycode.healthtrack.dao.MealDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class MealServlet
 */
@WebServlet("/meal")
public class MealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MealDAO daoMeal;

	@Override
	public void init() throws ServletException {
		super.init();
		daoMeal = DAOFactory.getMealDAO();
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
		List<Meal> list = daoMeal.select();
		request.setAttribute("meals", list);
		request.getRequestDispatcher("??.jsp").forward(request, response);
	}

	private void openFormUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idMeal = Integer.parseInt(request.getParameter("id"));
		Meal meal = daoMeal.selectById(idMeal);
		request.setAttribute("meal", meal);
	}

	private void openFormRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register-meal.jsp").forward(request, response);
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
		int idMeal = Integer.parseInt(request.getParameter("id"));
		try {
			daoMeal.delete(idMeal);
			request.setAttribute("msg", "Refeição removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao excluir");
		}
		list(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idMeal = Integer.parseInt(request.getParameter("id"));
			String nameMeal = request.getParameter("name_meal");
			int calorie = Integer.parseInt(request.getParameter("total_calorie"));

			Calendar dateUpdate = Calendar.getInstance();

			Meal meal = new Meal(idMeal, nameMeal, calorie, dateUpdate);
			daoMeal.update(meal);

			request.setAttribute("msg", "Refeição atualizada!");
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
			String nameMeal = request.getParameter("name_meal");
			int calorie = Integer.parseInt(request.getParameter("total_calorie"));

			Calendar dateRecord = Calendar.getInstance();

			Meal meal = new Meal(0, nameMeal, calorie, dateRecord);
			daoMeal.insert(meal);

			request.setAttribute("msg", "Refeição cadastrada!");
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
