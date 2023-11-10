package homies.goats.projet_jee.servlet.authent;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession(false) != null && request.getSession().getAttribute("authenticatedUser") != null) {
            request.getSession().removeAttribute("authenticatedUser");
            request.getSession().invalidate();
        }
        response.sendRedirect("login");
    }
}
