package homies.goats.projetjee.servlet;

import homies.goats.projetjee.constant.UserType;
import homies.goats.projetjee.model.UserEntity;
import homies.goats.projetjee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //take parameter from the form
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

        System.out.println("We're in signupServlet creating user : " + user);

        //Send userEntity to the session bean
        userSessionBean.registerUser(user, password);

        //redirect website user to the login page
        response.sendRedirect("login.jsp");
    }
}
