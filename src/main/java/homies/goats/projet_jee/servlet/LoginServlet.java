package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userSessionBean.logUser(email, password)) {
            //Session server-side, donc pas de risques spécifiques
            request.getSession().setAttribute("authenticatedUser", email);
            response.sendRedirect("gestion");
        } else {
            response.sendRedirect("login-error.jsp");
        }
    }
}
