package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("name", prenom);
        request.setAttribute("login", login);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/bienvenue.jsp");
        dispatcher.forward(request, response);
    }
}
