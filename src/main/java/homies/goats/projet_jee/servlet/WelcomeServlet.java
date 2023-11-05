package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("name", "heheboi");
        request.setAttribute("login", "hahaboi");



        RequestDispatcher dispatcher = request.getRequestDispatcher("/gestion.jsp");
        dispatcher.forward(request, response);
    }
}
