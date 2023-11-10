package homies.goats.projet_jee.servlet.authent;

import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String failed = request.getParameter("failed");
        if(failed != null && failed.equals("true")){
            request.setAttribute("error", true);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userSessionBean.logUser(email, password)) {
            request.getSession().setAttribute("authenticatedUser", userSessionBean.getUserByEmail(email));
            response.sendRedirect("gestion");
        } else {
            response.sendRedirect("login?failed=true");
        }
    }
}
