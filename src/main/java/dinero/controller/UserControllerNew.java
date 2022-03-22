
package dinero.controller;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dinero.model.IUserDao;
import dinero.model.UserDao;
import dinero.model.User;
import utils.HibernateUtil;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/UserControllerServlet")
//   /controllerName
public class UserControllerNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao UserDao;

	public void init() {
		UserDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String action = request.getParameter("action");
			if (action == null) {
				action = "list";
			}
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertUser(request, response);
				break;
			case "delete":
				deleteUser(request, response);
				break;
			case "load":
				showEditForm(request, response);
				break;
			
			 case "update": updateUser(request, response);
			 break;
			 
			case "list":
				listUser(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);

		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		UserService service = new UserService(session);		
		List<User> listUser = service.selectAllUser();
		System.out.println(listUser);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profiles/profiles-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("turn page");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("profiles/profiles-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int userID = Integer.parseInt(request.getParameter("userID"));
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		UserService service = new UserService(session);		
		User existingUser = service.selectUser(userID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profiles/update-profiles.jsp");
		request.setAttribute("User", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User newUser = new User(name, email, username, password);

		UserDao.insertUser(newUser);

		listUser(request, response);

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws  IOException, ServletException, SQLException {
		request.setCharacterEncoding("UTF-8");
		int userID = Integer.parseInt(request.getParameter("userID"));
		// int UserID = Integer.parseInt(request.getParameter("UserID"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User updateUser = new User(userID, name, email, username, password);

		UserDao.updateUser(updateUser);

		System.out.println("helo!");

		listUser(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		long userID = Integer.parseInt(request.getParameter("userID"));
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		UserService service = new UserService(session);		


		service.deleteUser(userID);

		listUser(request, response);
	}

}
