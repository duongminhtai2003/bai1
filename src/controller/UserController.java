package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import services.UserService;

@WebServlet("/check-login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = "54 Nguyen Luong Bang";
		User user = new User(username, password);
		int check = userService.check(user);
		if (check > 0) {
			//thanh cong dive trang welcome
			request.setAttribute("address", address);
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/views/welcome.jsp");
			rd.forward(request, response);
		} else {
			//that bai di ve trang chu
			response.sendRedirect(request.getContextPath()+"/views/login.jsp?msg=loginError");
		}
	}

}
