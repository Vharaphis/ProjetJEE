package homies.goats.projet_jee.servlet.update;

import homies.goats.projet_jee.model.CompanyEntity;
import homies.goats.projet_jee.sessionBean.CompanySessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static homies.goats.projet_jee.utils.utils.getConvertedToIntIdOrNull;

public class UpdateCompanyServlet extends HttpServlet {

    @EJB
    CompanySessionBean companySessionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer idCompany = getConvertedToIntIdOrNull(request.getParameter("companyId"));

        if(idCompany == null){
            response.sendRedirect("gestion?type=company");
            return;
        }

        CompanyEntity company = companySessionBean.getCompanyById(idCompany);
        request.setAttribute("company", company);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resources/views/update-company.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer idCompany = getConvertedToIntIdOrNull(request.getParameter("idCompany"));
        if(idCompany == null){
            response.sendRedirect("gestion?type=company");
            return;
        }

        CompanyEntity company = companySessionBean.getCompanyById(idCompany);

        String socialReason = request.getParameter("socialReason");
        String companyAddress = request.getParameter("companyAddress");
        String companyInfos = request.getParameter("companyInfos");

        if(companySessionBean.updateCompany(socialReason, companyAddress, companyInfos, company)){
            response.sendRedirect("gestion?error=true&type=company");
        }
        response.sendRedirect("gestion?type=company");
    }
}
