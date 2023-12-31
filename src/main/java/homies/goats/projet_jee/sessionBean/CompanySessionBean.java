package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.model.CompanyEntity;
import homies.goats.projet_jee.model.TutorEntity;
import homies.goats.projet_jee.model.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

import static homies.goats.projet_jee.sessionBean.UserSessionBean.isNullOrBlank;

@Stateless
public class CompanySessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void createCompany(String socialReason, String companyAddress, String companyInfos){
        entityManager.getTransaction().begin();
        CompanyEntity company = new CompanyEntity();
        company.setSocialReason(socialReason);
        company.setCompanyAddress(companyAddress);
        company.setCompanyInfos(companyInfos);
        entityManager.persist(company);
        entityManager.getTransaction().commit();
    }

    public List<CompanyEntity> getAllCompanies(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_COMPANIES.getQueryString(), CompanyEntity.class).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public CompanyEntity getCompanyById(int idCompany){
        try {
            TypedQuery<CompanyEntity> query = entityManager.createQuery(SQLQueries.GET_COMPANY_BY_ID.getQueryString(), CompanyEntity.class);
            query.setParameter("idCompany", idCompany);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean updateCompany(String socialReason, String companyAddress, String companyInfos, CompanyEntity company){
        if(isNullOrBlank(socialReason) || isNullOrBlank(companyAddress) || isNullOrBlank(companyInfos)){
            return true;
        }

        company.setSocialReason(socialReason);
        company.setCompanyAddress(companyAddress);
        company.setCompanyInfos(companyInfos);

        entityManager.getTransaction().begin();
        entityManager.merge(company);
        entityManager.getTransaction().commit();

        return false;
    }
}

