package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.*;
import persistence.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public static List<ClientBean> clientBeans = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<ClientBean> clientBeans = new ArrayList<>();
		BankDAO DAO = new BankDAO();

		if (session.isNew()) {
			// début du servlet avec un nouveau client web
			if (DAO.compterClient() > 0){
				System.out.println("nombre de client en base : " + DAO.compterClient());
				clientBeans = (List<ClientBean>) DAO.lireTousLesClients();
			}

			session.setAttribute("clientBeans", clientBeans);
		} else
			clientBeans = (List<ClientBean>) session.getAttribute("clientBeans");

		ClientBean bean = new ClientBean();

		if (request.getParameterValues("nom") != null) {
			try {
				bean.setNom(request.getParameter("nom"));
				bean.setPrenom(request.getParameter("prenom"));
				bean.setTel(request.getParameter("tel"));
				bean.setEmail(request.getParameter("email"));
				bean.setMdp(request.getParameter("mdp"));

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}
			request.setAttribute("bean", bean);
			if ("".compareTo(bean.getNom()) != 0) { // ajouter les autres
													// controles

				clientBeans.add(bean);
				DAO.ajouterClient(bean);
				// clientBeans.lastIndexOf(clientBeans);

			}

			if ("Retour".equals(request.getParameter("bouton")))
				request.getRequestDispatcher("SaisieClient.jsp").forward(request, response);
			else {
				request.getRequestDispatcher("AfficheClient.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("SaisieClient.jsp").forward(request, response);
		}

	}
}
