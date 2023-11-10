package homies.goats.projet_jee.servlet.edit;

import homies.goats.projet_jee.sessionBean.CompanySessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateCompanyServlet extends HttpServlet {

    @EJB
    CompanySessionBean companySessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/update-company.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String socialReason = request.getParameter("socialReason");
        String companyAddress = request.getParameter("companyAddress");
        String companyInfos = request.getParameter("companyInfos");

        if(socialReason.isBlank() || companyAddress.isBlank()){
            response.sendRedirect("gestion?error=true");
        }

        companySessionBean.createCompany(socialReason, companyAddress, companyInfos);
        response.sendRedirect("gestion");
    }
}
