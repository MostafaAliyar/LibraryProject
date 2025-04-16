package aliyar.mostafa.project.library.objects;

public enum Gender {
    MALE('M')
    , FEMALE('F'),
    OTHER('O');
    private char value;
    private Gender(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }
    public static String getGender(Gender gender) {
        String result = "";
        if (gender==Gender.MALE) {
            result = " آقای ";
        } else if (gender==Gender.FEMALE) {
            result = " خانم ";
        }
        return result;
    }


}
