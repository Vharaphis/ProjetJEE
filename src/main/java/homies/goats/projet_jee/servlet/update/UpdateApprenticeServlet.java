package homies.goats.projet_jee.servlet.update;

import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.model.CompanyEntity;
import homies.goats.projet_jee.model.UserEntity;
import homies.goats.projet_jee.sessionBean.ApprenticeSessionBean;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static homies.goats.projet_jee.utils.utils.getConvertedToIntIdOrNull;

public class UpdateApprenticeServlet extends HttpServlet {
    @EJB
    private UserSessionBean userSessionBean;
    @EJB
    private ApprenticeSessionBean apprenticeSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idApprentice = getConvertedToIntIdOrNull(request.getParameter("idApprentice"));
        if(idApprentice == null){
            response.sendRedirect("gestion?type=all");
        }
        ApprenticeEntity apprentice = apprenticeSessionBean.getApprenticeByApprenticeId(idApprentice);
        UserEntity user = userSessionBean.getUserById(apprentice.getUserId());

        request.setAttribute("apprentice", apprentice);
        request.setAttribute("user", user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/update-apprentice.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idApprentice = getConvertedToIntIdOrNull(request.getParameter("idApprentice"));
        if(idApprentice == null){
            response.sendRedirect("gestion?type=all");
        }

        ApprenticeEntity apprentice = apprenticeSessionBean.getApprenticeByApprenticeId(idApprentice);

        String academicYear = request.getParameter("academicYear");
        String program = request.getParameter("program");
        String major = request.getParameter("major");

        apprenticeSessionBean.updateApprentice(academicYear, program, major, apprentice);
        response.sendRedirect("details?userId=" + request.getParameter("idUser"));
    }
}
