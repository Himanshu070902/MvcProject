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

@WebServlet(urlPatterns = "/editPage")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		int uid = 0;
		if (id != null) {
			System.out.println("Entered here..");
			id = id.trim();
			System.out.println(id);
			uid = Integer.parseInt(id);
		}
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("email");

		UsersEntity ue = new UsersEntity();
		ue.setId(uid);
		ue.setName(name);
		ue.setEmail(mail);
		ue.setPhone(phone);

		DataHandler de = new DataHandler();
		ue = de.EditDetails(ue);
		if (ue != null) {
			session.setAttribute("name", ue.getName());
			session.setAttribute("phone", ue.getPhone());
			session.setAttribute("email", ue.getEmail());

			request.setAttribute("message", "Updated success");
			RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("message", "Updation failed");
			RequestDispatcher rd = request.getRequestDispatcher("/Edit.jsp");
			rd.forward(request, response);
		}

	}

}
