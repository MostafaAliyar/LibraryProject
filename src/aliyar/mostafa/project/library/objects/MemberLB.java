package aliyar.mostafa.project.library.objects;

public class MemberLB {
    private int keyCustomer;
    private int ageCustomer;
    private String nameCustomer;
    private Gender genderCustomer;
    private boolean rentBook = true ;
    private String nameRentBook;
    public MemberLB(int keyCustomer, int ageCustomer, String nameCustomer, Gender genderCustomer) {
        this.keyCustomer = keyCustomer;
        this.ageCustomer = ageCustomer;
        this.nameCustomer = nameCustomer;
        this.genderCustomer = genderCustomer;
    }
    public int getKeyCustomer() {
        return keyCustomer;
    }
    public String getNameCustomer() {
        return nameCustomer;
    }
    public Gender getGenderCustomer() {
        return genderCustomer;
    }
    public int getAgeCustomer() {
        return ageCustomer;
    }
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    public void setAgeCustomer(int ageCustomer) {
        this.ageCustomer = ageCustomer;
    }
    public void setGenderCustomer(Gender genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public void setRentBook(boolean rentBook) {
        this.rentBook = rentBook;
    }
    public boolean isRentBook() {
        return rentBook;
    }

    public void setNameRentBook(String nameRentBook) {
        this.nameRentBook = nameRentBook;
    }
    public String getNameRentBook() {
        return nameRentBook;
    }
}
