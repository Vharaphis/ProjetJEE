package homies.goats.projet_jee.sessionBean;

import homies.goats.projet_jee.constant.SQLQueries;
import homies.goats.projet_jee.constant.UserType;
import homies.goats.projet_jee.model.UserEntity;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

@Stateless
public class UserSessionBean {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("projet_jee");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @EJB
    ApprenticeSessionBean apprenticeSessionBean;
    @EJB
    TutorSessionBean tutorSessionBean;

    public void createUser(String name, String forename, String email, UserType userType, String password) {
        UserEntity user = new UserEntity();
        user.setLastname(name);
        user.setForename(forename);
        user.setEmail(email);
        user.setUserType(userType);

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(password, salt);

        user.setSalt(salt);
        user.setPasswordHash(passwordHash);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        if (userType == UserType.Apprentice){
            apprenticeSessionBean.createApprentice(user.getUserId());
        } else if (userType == UserType.Tutor){
            tutorSessionBean.createTutor(user.getUserId());
        } else {
            return;
        }
    }

    //returns true if it fails
    public boolean updateUser(UserEntity authenticatedUser, UserEntity modifiedUser, String newPassword, String passwordConfirmation) {
        //name, forename, email and phone are fields that are automatically set in the .jsp. They shouldn't be nulled.
        if(isNullOrBlank(modifiedUser.getLastname()) || isNullOrBlank(modifiedUser.getForename()) || isNullOrBlank(modifiedUser.getEmail()) || isNullOrBlank(modifiedUser.getPhone())){
            return true;
        }

        authenticatedUser.setLastname(modifiedUser.getLastname());
        authenticatedUser.setForename(modifiedUser.getForename());
        authenticatedUser.setEmail(modifiedUser.getEmail());
        authenticatedUser.setPhone(modifiedUser.getPhone());

        //Password / ConfirmPassword on the other hand can be nulled, but if they are, the user password shouldn't be updated.
        if(!isNullOrBlank(newPassword) && !isNullOrBlank(passwordConfirmation)){
            if(newPassword.equals(passwordConfirmation)){
                String salt = BCrypt.gensalt();
                String passwordHash = BCrypt.hashpw(newPassword, salt);
                authenticatedUser.setSalt(salt);
                authenticatedUser.setPasswordHash(passwordHash);
            }
        }

        entityManager.getTransaction().begin();
        entityManager.merge(authenticatedUser);
        entityManager.getTransaction().commit();

        return false;
    }

    public List<UserEntity> getTutorApprentices(int tutorId){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_APPRENTICES_OF_TUTOR.getQueryString(), UserEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
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

    public UserEntity getUserById(int userId) {
        try {
            TypedQuery<UserEntity> query = entityManager.createQuery(SQLQueries.GET_USER_BY_ID.getQueryString(), UserEntity.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<UserEntity> getAllApprenticesNotArchived(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_APPRENTICES_NOT_ARCHIVED.getQueryString(), UserEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<UserEntity> getAllApprenticesArchived(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_APPRENTICES_ARCHIVED.getQueryString(), UserEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<UserEntity> getAllUsers(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_USERS.getQueryString(), UserEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public List<UserEntity> getAllTutors(){
        try {
            return entityManager.createQuery(SQLQueries.GET_ALL_TUTORS.getQueryString(), UserEntity.class).getResultList();
        } catch (NoResultException e){
            return null;
        }
    }

    public boolean logUser(String email, String password) {
        UserEntity user = getUserByEmail(email);
        if(user == null){return false;}
        String hashedPassword = user.getPasswordHash();

        return BCrypt.checkpw(password, hashedPassword);
    }

    public static boolean isNullOrBlank(String s){
        return (s == null || s.isBlank());
    }
}

