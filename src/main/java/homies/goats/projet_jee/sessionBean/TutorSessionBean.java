package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.model.ApprenticeEntity;
import homies.goats.projet_jee.model.TutorEntity;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class TutorSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void createTutor(int userId){
        entityManager.getTransaction().begin();
        TutorEntity tutor = new TutorEntity();
        tutor.setUserId(userId);
        entityManager.persist(tutor);
        entityManager.getTransaction().commit();
    }

    public  List<TutorEntity> getAllTutors(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_TUTORS.getQueryString(), TutorEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public TutorEntity getTutorByUserId(int id){
        try {
            TypedQuery<TutorEntity> query = entityManager.createQuery(SQLQueries.GET_TUTOR_BY_USER_ID.getQueryString(), TutorEntity.class);
            query.setParameter("userId", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public TutorEntity getTutorByTutorId(int id){
        try {
            TypedQuery<TutorEntity> query = entityManager.createQuery(SQLQueries.GET_TUTOR_BY_TUTOR_ID.getQueryString(), TutorEntity.class);
            query.setParameter("idTutor", id);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
