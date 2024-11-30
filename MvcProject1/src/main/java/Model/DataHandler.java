package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.UsersEntity;

public class DataHandler {
	Connection con;

	public DataHandler() {
		String url = "jdbc:mysql://localhost:3306/mvcproject";
		String user = "root";
		String Dpass = "himanshu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, Dpass);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String insert(UsersEntity ue) {
		ResultSet rs;
		String mess = "";
		PreparedStatement ps;
		String check = "SELECT * FROM USER WHERE PHONE = ? OR EMAIL = ? ";

		try {

			ps = con.prepareStatement(check);

			ps.setString(1, ue.getPhone());
			ps.setString(2, ue.getEmail());

			rs = ps.executeQuery();
			if (rs.next()) {
				return "Existed record";
			}

			else {
				ps = con.prepareStatement("INSERT INTO user values(0,?,?,?,?) ");
				ps.setString(1, ue.getName());
				ps.setString(3, ue.getPhone());
				ps.setString(2, ue.getEmail());
				ps.setString(4, ue.getPass());
				int res = ps.executeUpdate();

				if (res > 0) {
					mess = "success";
				} else {
					mess = "failure";
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;

	}

	public UsersEntity getInfo(String mail, String pass) {
		PreparedStatement ps;
		ResultSet rs;
		UsersEntity u = null;
		try {
			ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
			ps.setString(1, mail);
			ps.setString(2, pass);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(4);
				String email = rs.getString(3);
				u = new UsersEntity();
				u.setId(id);

				u.setName(name);
				u.setEmail(email);
				u.setPhone(phone);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return u;
	}

	public UsersEntity EditDetails(UsersEntity ue) {
		PreparedStatement ps;
		String result = "";
		String edit = "update user set name = ?, email = ?, phone = ? where id= ?";
		try {
			ps = con.prepareStatement(edit);
			ps.setString(1, ue.getName());
			ps.setString(3, ue.getPhone());
			ps.setString(2, ue.getEmail());
			ps.setInt(4, ue.getId());
			int res = ps.executeUpdate();
			if (res > 0) {
				result = "success";
			} else {
				result = "failed";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.equals("success")) {
			return ue;
		} else {
			return null;
		}
	}

}
