package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.model.CompanyEntity;
import homies.goats.projet_jee.model.TutorEntity;
import homies.goats.projet_jee.model.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

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

    public CompanyEntity getCompanyById(int idCompany){
        try {
            TypedQuery<CompanyEntity> query = entityManager.createQuery(SQLQueries.GET_COMPANY_BY_ID.getQueryString(), CompanyEntity.class);
            query.setParameter("idCompany", idCompany);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

