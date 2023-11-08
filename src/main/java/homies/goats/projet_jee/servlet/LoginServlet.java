package homies.goats.projet_jee.servlet;

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
            //One session per user, and server side = no risks
            //Putting the user directly into "authenticatedUser" to access its data from the webpages without having to re-query it all the time.
            //However, this means that the user object would not get updated in the webpage if it actually gets updated in database.
            //Therefore, we have to update the attribute "authenticatedUser" everytime its UserEntity changes.
            request.getSession().setAttribute("authenticatedUser", userSessionBean.getUserByEmail(email));
            response.sendRedirect("gestion");
        } else {
            response.sendRedirect("login?failed=true");
        }
    }
}
