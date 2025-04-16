package aliyar.mostafa.project.library.objects;

public enum StateBook {
    REDYE("آماده استفاده"),NOT_REDYE("امانت داده شده");
    private final String value;
    private StateBook(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }


}
