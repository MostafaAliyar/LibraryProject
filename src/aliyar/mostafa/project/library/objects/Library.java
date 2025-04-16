package aliyar.mostafa.project.library.objects;

public class Library {
    private String name;
    public BookLB [] bookLBS;
    public MemberLB [] memberLBS;
    private  int numberCustomer;
    private  int numberBook;

    public Library(String name , int numberCustomer, int numberBook) {
        this.name = name;
        this.numberCustomer = numberCustomer;
        this.numberBook = numberBook;
        bookLBS = new BookLB[this.numberBook];
        memberLBS = new MemberLB[this.numberBook];
    }
    public static int spaceNewMember(MemberLB[] memberLB) {
        for (int i = 0; i < memberLB.length; i++) {
            if (memberLB[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int spaceNewBook(BookLB[] bookLBS) {
        for (int i = 0; i < bookLBS.length; i++) {
            if (bookLBS[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public MemberLB[] getMemberLBS() {
        return memberLBS;
    }

}
