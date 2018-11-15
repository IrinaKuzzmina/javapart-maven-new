package homework16;

public enum Gender {
    MAN ("м"),
    WOMAN("ж" );

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
   String getGender(){
        return gender;
   }


}
