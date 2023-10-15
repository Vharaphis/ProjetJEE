package homies.goats.projetjee.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws IOException {
        //take parameter from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");


    }
}
