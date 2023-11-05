package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.model.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

@Stateless
public class UserSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void registerUser(UserEntity user, String password) {
        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(password, salt);

        user.setSalt(salt);
        user.setPasswordHash(passwordHash);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public UserEntity getUserByEmail(String email) {
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery(SQLQueries.GET_USER_BY_EMAIL.getQueryString(), UserEntity.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean logUser(String email, String password) {

        UserEntity user = getUserByEmail(email);
        String hashedPassword = user.getPasswordHash();

        boolean passwordMatching = BCrypt.checkpw(password, hashedPassword);
        if (passwordMatching) {
            System.out.println("Pw are the same, logging to dbb");
            return true;
        }
        else {
            System.out.println("Pw are not the same");
            return false;
        }
    }
}

