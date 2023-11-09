package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DetailServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO

        String userId = request.getParameter("userId");

        if(userId == null || userId.isBlank()){
            System.out.println("User is null");
            response.sendRedirect("gestion");
            return;
        }

        int convertedUserId;
        try {
            convertedUserId = Integer.parseInt(userId);
        } catch (NumberFormatException e) {
            System.out.println("Given userId is not numerical.");
            response.sendRedirect("gestion");
            return;
        }

        ApprenticeEntity apprentice = userSessionBean.getApprenticeByUserId(convertedUserId);
        if(apprentice == null){
            System.out.println("Apprentice is null");
            response.sendRedirect("gestion");
            return;
        }

        userSessionBean.changeApprenticeArchiveStatus(apprentice);
        response.sendRedirect("gestion");
    }
}
