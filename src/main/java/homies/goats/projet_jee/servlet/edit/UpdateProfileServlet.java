package homies.goats.projet_jee.servlet.edit;

import homies.goats.projet_jee.model.UserEntity;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UpdateProfileServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String failed = request.getParameter("failed");
        if(failed != null && failed.equals("true")){
            request.setAttribute("error", true);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/update-profile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("update") != null) {
            HttpSession session = request.getSession(false);

            if(session != null) {
                UserEntity authenticatedUser = (UserEntity) session.getAttribute("authenticatedUser");
                String name = request.getParameter("lastname");
                String forename = request.getParameter("forename");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String password = request.getParameter("newPassword");
                String confirmPassword = request.getParameter("confirmPassword");

                UserEntity modifiedUser = new UserEntity();
                modifiedUser.setLastname(name);
                modifiedUser.setForename(forename);
                modifiedUser.setEmail(email);
                modifiedUser.setPhone(phone);

                //returns true if it fails
                boolean fail = userSessionBean.updateUser(authenticatedUser, modifiedUser, password, confirmPassword);
                if(fail){
                    response.sendRedirect("update-profile?failed=true");
                } else {
                    response.sendRedirect("gestion");
                }
            } else {
                System.err.println("Session doesn't exist, user not logged in.");
            }
        }
        else if (request.getParameter("return") != null) {
            response.sendRedirect("gestion");
        }
    }
}