package homies.goats.projet_jee.constant;

public enum UserType {
    Tutor("Tutor"),
    Apprentice("Apprentice");


    private String type;
    UserType(String type){
        this.type = type;
    }

    public static UserType getUserType(String type){
        if(type.equals(Tutor.type)) {
            return Tutor;
        } else {
            return Apprentice;
        }
    }
}
