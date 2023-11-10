package homies.goats.projet_jee.servlet;

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

public class WelcomeServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;
    @EJB
    private ApprenticeSessionBean apprenticeSessionBean;
    @EJB
    private TutorSessionBean tutorSessionBean;
    @EJB
    private CompanySessionBean companySessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String listType = request.getParameter("type");
        listType = listType == null ? "" : listType;
        switch (listType){
            case "tutor":
                request.setAttribute("LIST", userSessionBean.getAllTutors());
                request.setAttribute("LIST_TYPE", "Tutors");
                break;

            case "apprentice_archived":
                request.setAttribute("LIST", userSessionBean.getAllApprenticesArchived());
                request.setAttribute("LIST_TYPE", "Archived Apprentices");
                break;

            case "all":
                request.setAttribute("LIST", userSessionBean.getAllUsers());
                request.setAttribute("LIST_TYPE", "All Users");
                break;

            case "company":
                request.setAttribute("LIST", companySessionBean.getAllCompanies());
                request.setAttribute("LIST_TYPE", "Companies");
                request.setAttribute("company", true);
                break;

            default:
                request.setAttribute("LIST", userSessionBean.getAllApprenticesNotArchived());
                request.setAttribute("LIST_TYPE", "All Current Apprentices");
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/gestion.jsp");
        dispatcher.forward(request, response);
    }
}
