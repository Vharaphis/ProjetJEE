package homies.goats.projet_jee.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("In Logout beginning");
        if (request.getSession(false) != null && request.getSession().getAttribute("authenticatedUser") != null) {
            System.out.println("Invalidating shit");
            request.getSession().removeAttribute("authenticatedUser");
            request.getSession().invalidate();
        }
        System.out.println("Redirecting");
        response.sendRedirect("login.jsp");
    }
}
