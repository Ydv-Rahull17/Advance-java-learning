package Controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        // basic validation
        if (username != null && !username.trim().isEmpty()
                && pwd != null && !pwd.trim().isEmpty()) {

            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);

            ServletContext context = getServletContext();

            synchronized (context) {
                Set<String> users =
                        (Set<String>) context.getAttribute("loggedUser");

                if (users == null) {
                    users = new HashSet<>();
                }

                users.add(username);
                context.setAttribute("loggedUser", users);
            }

            response.sendRedirect("userHome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
