package dinero.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dinero.model.LoginBean;
import dinero.model.LoginDao;
import dinero.model.User;
import dinero.model.UserDao;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

			if (loginDao.validate(username,password)) {
				UserDao userDao = new UserDao();
				User user = userDao.getUserByUserAccAndPwd(username, password);
				System.out.println(user);
				request.getSession().setAttribute("userNowLogin", user);
//				response.sendRedirect(request.getContextPath()+"//dineroHome.jsp");

				RequestDispatcher dispatcher = request.getRequestDispatcher("profiles/profiles-list.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("NOTIFICATION", "請輸入正確的帳號密碼!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);

				throw new Exception("登入失敗 :)");
			}
		} 

	}

