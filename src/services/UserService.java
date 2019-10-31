package services;

import model.bean.User;
import model.dao.UserDAO;

public class UserService {
	
	private UserDAO userDAO = new UserDAO();

	public int check(User user) {
		return userDAO.checkUser(user);
	}
}
