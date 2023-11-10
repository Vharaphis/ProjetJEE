package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.model.ApprenticeEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class ApprenticeSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void createApprentice(int userId){
        entityManager.getTransaction().begin();
        ApprenticeEntity apprentice = new ApprenticeEntity();
        apprentice.setUserId(userId);
        apprentice.setIsArchived(false);
        entityManager.persist(apprentice);
        entityManager.getTransaction().commit();
    }

    public ApprenticeEntity getApprenticeByUserId(int id) {
        try {
            TypedQuery<ApprenticeEntity> query = entityManager.createQuery(SQLQueries.GET_APPRENTICE_BY_USER_ID.getQueryString(), ApprenticeEntity.class);
            query.setParameter("userId", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void changeApprenticeArchiveStatus(ApprenticeEntity apprentice){
        apprentice.setIsArchived(!apprentice.getIsArchived());
        entityManager.getTransaction().begin();
        entityManager.merge(apprentice);
        entityManager.getTransaction().commit();
    }

}
