package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.User;
import util.DBConnection;

public class UserDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

	public int checkUser(User user) {
		conn = DBConnection.getJDBCConnection();
		String sql = "SELECT username, password FROM user WHERE username LIKE ? AND password LIKE ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		System.out.println(dao.checkUser(new User("admin", "123456")));
	}
}
