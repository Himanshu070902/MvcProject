package Controller;

import java.io.IOException;

import Model.DataHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registerPage")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String cpass = req.getParameter("conpassword");

		UsersEntity ue = null;

		if (pass.equals(cpass)) {
			ue = new UsersEntity(name, email, phone, pass);

			DataHandler dh = new DataHandler();
			String mess = dh.insert(ue);
			if (mess.equals("success")) {
				req.setAttribute("message", "Registration success..");
				RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
				rd.forward(req, res);
			} else if (mess.equals("failure")) {
				req.setAttribute("message", "Registration failed...");
				RequestDispatcher rd = req.getRequestDispatcher("/Registration.jsp");
				rd.forward(req, res);
			} else if (mess.equals("Existed record")) {
				req.setAttribute("message", "Record Already Existed...");
				RequestDispatcher rd = req.getRequestDispatcher("/Registration.jsp");
				rd.forward(req, res);
			}

		} else {
			req.setAttribute("message", "Mismatch of Confirm password");
			RequestDispatcher rd = req.getRequestDispatcher("/Registration.jsp");
			rd.forward(req, res);
		}

	}

}
