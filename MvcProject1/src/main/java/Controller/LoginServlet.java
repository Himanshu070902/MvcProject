package Controller;

import java.io.IOException;

import Model.DataHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/LoginPage")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("login") != null) {

			String email = req.getParameter("email");
			String pass = req.getParameter("password");

			DataHandler dh = new DataHandler();
			UsersEntity ue = dh.getInfo(email, pass);

			if (ue != null) {
				session.setAttribute("id", ue.getId());
				session.setAttribute("name", ue.getName());
				session.setAttribute("email", ue.getEmail());
				session.setAttribute("phone", ue.getPhone());

				RequestDispatcher rd = req.getRequestDispatcher("/Home.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("message", "Invalid credentials...");
				RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
				rd.forward(req, resp);
			}

		} else if (req.getParameter("logout") != null) {

			session.invalidate();
			RequestDispatcher rd = req.getRequestDispatcher("/Login.jsp");
			rd.forward(req, resp);

		}

	}
}
