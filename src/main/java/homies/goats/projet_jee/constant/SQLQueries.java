package homies.goats.projet_jee.constant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public enum SQLQueries {

    GET_USER_BY_EMAIL("SELECT u FROM UserEntity u WHERE u.email = :email");

    private String query;
    SQLQueries(String query){
        this.query = query;
    }

    public String getQuery(){
        return this.query;
    }

    public static <T> TypedQuery<T> createQuery(SQLQueries query, EntityManager em, Class<T> entityClass){
        return em.createQuery(query.getQuery(), entityClass);
    }

}
