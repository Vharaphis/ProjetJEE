package homies.goats.projet_jee.constant;

public enum SQLQueries {
    /*
    Enum "SQLQueries" allows to store the queries as constants, to avoid unwanted modifications, as well as making their
    use easier. Below, in the queries, elements that have ':' before them are parameters that needs to be set.
     */
    GET_ALL_APPRENTICES_NOT_ARCHIVED("SELECT u FROM UserEntity u INNER JOIN ApprenticeEntity a ON a.userId = u.userId WHERE NOT a.isArchived"),
    GET_ALL_APPRENTICES_ARCHIVED("SELECT u FROM UserEntity u INNER JOIN ApprenticeEntity a ON a.userId = u.userId WHERE a.isArchived = TRUE"),
    GET_ALL_USERS("SELECT u FROM UserEntity u"),
    GET_ALL_TUTORS("SELECT u FROM UserEntity u INNER JOIN TutorEntity t ON t.userId = u.userId"),
    GET_USER_BY_ID("SELECT u FROM UserEntity u WHERE u.userId = :userId"),
    GET_USER_BY_ID_TUTOR("SELECT u FROM UserEntity u INNER JOIN TutorEntity t ON t.userId = u.userId WHERE t.idTutor = :idTutor"),
    GET_USER_BY_EMAIL("SELECT u FROM UserEntity u WHERE u.email = :email"),
    GET_ALL_APPRENTICES("SELECT a FROM ApprenticeEntity a"),
    GET_APPRENTICE_BY_USER_ID("SELECT a FROM ApprenticeEntity a WHERE a.userId = :userId"),
    GET_APPRENTICE_BY_ID("SELECT a FROM ApprenticeEntity a WHERE a.idApprentice = :idApprentice"),
    GET_TUTOR_BY_USER_ID("SELECT t FROM TutorEntity t WHERE t.userId = :userId"),
    GET_COMPANY_BY_ID("SELECT c FROM CompanyEntity c WHERE c.idCompany = :idCompany"),
    GET_ALL_COMPANIES("SELECT c FROM CompanyEntity c"),
    GET_ALL_APPRENTICES_OF_TUTOR("SELECT u FROM UserEntity u INNER JOIN ApprenticeEntity a ON a.userId = u.userId WHERE a.idTutor = :idTutor");

    private String query;

    SQLQueries(String query){
        this.query = query;
    }

    public String getQueryString(){
        return this.query;
    }
}
