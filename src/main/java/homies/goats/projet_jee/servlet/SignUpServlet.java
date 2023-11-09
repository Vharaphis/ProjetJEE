package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.constant.UserType;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import homies.goats.projet_jee.model.UserEntity;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/signup.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String forename = request.getParameter("forename");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserType userType = UserType.getUserType(request.getParameter("profession"));

        //create a userEntity
        UserEntity user = new UserEntity();
        user.setLastname(name);
        user.setForename(forename);
        user.setEmail(email);
        user.setUserType(userType);

        //Send userEntity to the session bean
        userSessionBean.registerUser(user, password);

        //redirect website user to the login page
        response.sendRedirect("login");
    }
}
