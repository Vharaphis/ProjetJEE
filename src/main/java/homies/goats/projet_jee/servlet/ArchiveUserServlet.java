package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.model.UserEntity;
import homies.goats.projet_jee.sessionBean.ApprenticeSessionBean;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static homies.goats.projet_jee.utils.utils.getConvertedToIntIdOrNull;

public class ArchiveUserServlet extends HttpServlet {
    @EJB
    private UserSessionBean userSessionBean;
    @EJB
    private ApprenticeSessionBean apprenticeSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer userId = getConvertedToIntIdOrNull(request.getParameter("userId"));
        if(userId == null){
            response.sendRedirect("gestion");
        }

        ApprenticeEntity apprentice = apprenticeSessionBean.getApprenticeByUserId(userId);
        if(apprentice == null){
            response.sendRedirect("gestion");
            return;
        }

        apprenticeSessionBean.changeApprenticeArchiveStatus(apprentice);
        response.sendRedirect("gestion");
    }
}
