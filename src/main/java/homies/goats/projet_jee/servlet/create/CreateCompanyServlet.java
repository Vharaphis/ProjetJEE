package homies.goats.projet_jee.servlet.create;

import homies.goats.projet_jee.sessionBean.CompanySessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateCompanyServlet extends HttpServlet {

    @EJB
    private CompanySessionBean companySessionBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String socialReason = request.getParameter("socialReason");
        String companyAddress = request.getParameter("companyAddress");
        String companyInfos = request.getParameter("companyInfos");

        if(socialReason.isBlank() || companyAddress.isBlank()){
            response.sendRedirect("gestion?error=true");
        }

        companySessionBean.createCompany(socialReason, companyAddress, companyInfos);
        response.sendRedirect("gestion?type=company");
    }
}
