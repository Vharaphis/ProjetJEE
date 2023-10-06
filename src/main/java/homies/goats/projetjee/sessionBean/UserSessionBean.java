package homies.goats.projetjee.sessionBean;

import homies.goats.projetjee.model.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.mindrot.jbcrypt.BCrypt;

@Stateless
public class UserSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void registerUser(UserEntity user, String password) {
        String salt = generateSalt();
        String passwordHash = hashPasswordWithSalt(password, salt);

        user.setSalt(salt);
        user.setPasswordHash(passwordHash);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    private String generateSalt() {
        return BCrypt.gensalt();
    }

    private String hashPasswordWithSalt(String password, String salt) {
        return BCrypt.hashpw(password, salt);
    }
}

