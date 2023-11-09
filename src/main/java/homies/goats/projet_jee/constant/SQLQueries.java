package homies.goats.projet_jee.constant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public enum SQLQueries {
    /*
    Enum "SQLQueries" allows to store the queries as constants, to avoid unwanted modifications, as well as making their
    use easier. Below, in the queries, elements that have ':' before them are parameters that needs to be set.
     */
    GET_ALL_USERS("SELECT u FROM UserEntity u"),
    GET_USER_BY_ID("SELECT u FROM UserEntity u WHERE u.userId = :userId"),
    GET_USER_BY_EMAIL("SELECT u FROM UserEntity u WHERE u.email = :email"),
    GET_ALL_APPRENTICES("SELECT a FROM ApprenticeEntity a"),
    GET_APPRENTICE_BY_USER_ID("SELECT a FROM ApprenticeEntity a WHERE a.userId = :userId");
    private String query;

    SQLQueries(String query){
        this.query = query;
    }

    public String getQueryString(){
        return this.query;
    }
}
