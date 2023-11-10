package homies.goats.projet_jee.utils;

public class utils {

    public static Integer getConvertedToIntIdOrNull(String id){
        if(id == null || id.isBlank()){
            return null;
        }

        int convertedIdCompany;
        try {
            convertedIdCompany = Integer.parseInt(id);
            return convertedIdCompany;
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
