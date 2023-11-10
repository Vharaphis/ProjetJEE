package homies.goats.projet_jee.servlet.update;

import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.model.TutorEntity;
import homies.goats.projet_jee.model.UserEntity;
import homies.goats.projet_jee.sessionBean.ApprenticeSessionBean;
import homies.goats.projet_jee.sessionBean.TutorSessionBean;
import homies.goats.projet_jee.sessionBean.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static homies.goats.projet_jee.utils.utils.getConvertedToIntIdOrNull;

public class UpdateTutorServlet extends HttpServlet {
    @EJB
    private UserSessionBean userSessionBean;
    @EJB
    private ApprenticeSessionBean apprenticeSessionBean;
    @EJB
    private TutorSessionBean tutorSessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idTutor = getConvertedToIntIdOrNull(request.getParameter("idTutor"));
        if(idTutor == null){
            response.sendRedirect("gestion?type=tutor");
        }

        TutorEntity tutor = tutorSessionBean.getTutorByTutorId(idTutor);
        UserEntity user = userSessionBean.getUserById(tutor.getUserId());
        List<UserEntity> allApprentices = userSessionBean.getAllApprenticesNotArchived();

        request.setAttribute("tutor", tutor);
        request.setAttribute("user", user);
        request.setAttribute("allApprentices", allApprentices);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/update-tutor.jsp");
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
        response.sendRedirect("detail?userId=" + request.getParameter("idUser"));
    }
}
