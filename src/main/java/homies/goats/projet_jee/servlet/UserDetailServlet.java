package homies.goats.projet_jee.servlet;

import homies.goats.projet_jee.constant.UserType;
import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.model.CompanyEntity;
import homies.goats.projet_jee.model.TutorEntity;
import homies.goats.projet_jee.model.UserEntity;
import homies.goats.projet_jee.sessionBean.ApprenticeSessionBean;
import homies.goats.projet_jee.sessionBean.CompanySessionBean;
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

public class UserDetailServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;
    @EJB
    private ApprenticeSessionBean apprenticeSessionBean;
    @EJB
    private TutorSessionBean tutorSessionBean;
    @EJB
    private CompanySessionBean companySessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //TODO
        Integer userId = getConvertedToIntIdOrNull(request.getParameter("userId"));
        if(userId == null){
            response.sendRedirect("gestion");
        }
        UserEntity user = userSessionBean.getUserById(userId);
        if(user == null){
            response.sendRedirect("gestion");
            return;
        }
        request.setAttribute("mainUser", user);

        //Si apprenti => on aura "associatedApprentice" mais pas "associatedTutor" et vice-versa
        if(user.getUserType().equals(UserType.Apprentice.getType())){
            ApprenticeEntity associatedApprentice = apprenticeSessionBean.getApprenticeByUserId(user.getUserId());

            Integer idCompany = associatedApprentice.getIdCompany(), idTutor = associatedApprentice.getIdTutor();
            CompanyEntity apprenticeCompany = idCompany != null ? companySessionBean.getCompanyById(associatedApprentice.getIdCompany()) : null;
            UserEntity apprenticeTutor = idTutor != null ? userSessionBean.getUserById(associatedApprentice.getIdTutor()) : null;

            request.setAttribute("associatedApprentice", associatedApprentice);
            request.setAttribute("apprenticeCompany", apprenticeCompany);
            request.setAttribute("apprenticeTutor", apprenticeTutor);

        } else if(user.getUserType().equals(UserType.Tutor.getType())){
            TutorEntity associatedTutor = tutorSessionBean.getTutorByUserId(user.getUserId());
            List<UserEntity> tutorApprentices = associatedTutor != null ? userSessionBean.getTutorApprentices(associatedTutor.getIdTutor()) : null;

            request.setAttribute("associatedTutor", associatedTutor);
            request.setAttribute("tutorApprentices", tutorApprentices);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/details.jsp");
        dispatcher.forward(request, response);
    }
}
