package aliyar.mostafa.project.library.main;

import aliyar.mostafa.project.library.objects.*;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static Library library;
    private static final String msgNameCustomer ="لطفا نام کاربر را وارد کنید!";
    private static final String msgAgeCustomer ="لطفا سن کاربر را ارد کنید!";
    private static final String msgGenderCustomer="لطفا جنسیت کاربر را مشخص کنید M  به معنی مرد و F به معنی زن میباشد.";
//    private static final String msgKeyCustomer="لطفا کد کتابخانه کاربر را وارد کنید!(از ده شروع میشود)";
    private static final String msgLine="==========================================================================";
    private static final String msgNameBook = "لطفا نام کتاب را وارد کنید!";
    private static final String msgPagesBook = "لطفا تعداد صفحه های کتاب را مشخص کنید!";
    private static final String msgWriterBook="لطفا نام نویسنده کتاب را وارد کنید!";
    private static String nameBook;
    private static int index=-3;
    public static void main(String[] args) {
        firstQuestion();
    }

    private static void firstQuestion() {
        System.out.println("به نرم افزار مدیرت کتابخانه خوش آمدید");
        String nameLibrary=getDataString("لطفا اسم کتابخوانه خود را تعریف کنید!");
        int numberCostumer =getDataInt("لطفا تعداد کاربرانی که میخواهید ثبت نام کنید را وارد کنید!");
        int numberBook = getDataInt("لطفا تعداد کتاب هایی که دارید را وارد کنید!");
        createLibrary(nameLibrary,numberCostumer,numberBook);
    }

    private static void createLibrary(String nameLibrary, int numberCostumer, int numberBook) {
        library = new Library(nameLibrary,numberCostumer,numberBook);
        System.out.println("کتابخانه شما با نام "+nameLibrary+" ساخته شد.");
        showMenu(Order.ORDER.getValue());
    }
    // این متد منو اصلی برنامه میباشد که به منو های دیگر دسترسی دارد و میتوان با این منو از برنامه خارج شد.
    private static void showMenu(int order) {

        switch (order) {
            case 0:
                showMenu(mainMenu());
                break;
            case 1:
                showMenu(customerMenu());
                break;
            case 11:
                insertCustomer(Library.spaceNewMember(library.memberLBS));
                showMenu(Order.CUSTOMER_MENU.getValue());
                break;
            case 12:
                index = getDataInt(msgKeyCustomer);
                updateCustomer(getIndexCoustomer(library.memberLBS,index));
                showMenu(Order.CUSTOMER_MENU.getValue());
                break;
            case 13:
                index = getDataInt(msgKeyCustomer);
                readCustomer(getIndexCoustomer(library.memberLBS,index));
                showMenu(Order.CUSTOMER_MENU.getValue());

                break;
            case 14:
                index = getDataInt(msgKeyCustomer);
                deleteCustomer(getIndexCoustomer(library.memberLBS,index));
                showMenu(Order.CUSTOMER_MENU.getValue());
                break;
            case 15:
                showMenu(Order.ORDER.getValue());
                break;
            case 2:
                showMenu(bookMenu());
                break;
            case 21:
                insertBook(Library.spaceNewBook(library.bookLBS));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 22:
                nameBook = getDataString(msgNameBook);
                updateBook(getIndexBook(library.bookLBS,nameBook));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 23:
                nameBook = getDataString(msgNameBook);
                readBook(getIndexBook(library.bookLBS,nameBook));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 24:
                nameBook = getDataString(msgNameBook);
                deleteBook(getIndexBook(library.bookLBS,nameBook));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 25:
                nameBook = getDataString(msgNameBook);
                index = getDataInt(msgKeyCustomer);
                lendingBook(getIndexBook(library.bookLBS,nameBook),getIndexCoustomer(library.getMemberLBS(), index));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 26:
                nameBook = getDataString(msgNameBook);
                index = getDataInt(msgKeyCustomer);
                backBook(getIndexBook(library.bookLBS,nameBook),getIndexCoustomer(library.getMemberLBS(), index));
                showMenu(Order.BOOKS_MENU.getValue());
                break;
            case 27:
                showMenu(mainMenu());
                break;
            case 3:
                System.exit(0);
               break;
            default:
                System.out.println("مقدار وارد شده اشتباه است!");
                showMenu(mainMenu());
                break;
        }
    }

    private static void backBook(int indexBook, int indexMember) {
        if (indexBook==-2){
            System.out.println("کتابی با این اسم تعریف نشده است!");
        } else if (indexMember==-1) {
            System.out.println("کاربری با این کد وجود ندارد!");
        }else {
            if (!library.memberLBS[indexMember].isRentBook()){
                library.bookLBS[indexBook].setStateBook(StateBook.REDYE);
                library.memberLBS[indexMember].setRentBook(true);
                System.out.println("کتاب "+library.memberLBS[indexMember].getNameRentBook()+" از"+Gender.getGender(library.memberLBS[indexMember].getGenderCustomer())+library.memberLBS[indexMember].getNameCustomer()+" پس گرفته شد");
                library.memberLBS[indexMember].setNameRentBook(null);
            }else {
                System.out.println("این کاربر کتابی را به امانت نبرده است!");
            }
        }
    }

    private static void lendingBook(int indexBook, int indexMember) {
        if (indexBook==-2){
            System.out.println("کتابی با این اسم تعریف نشده است!");
        } else if (indexMember==-1) {
            System.out.println("کاربری با این کد وجود ندارد!");
        }else {
            if (library.memberLBS[indexMember].isRentBook()){
                if (library.bookLBS[indexBook].getStateBook()==StateBook.NOT_REDYE){
                    System.out.println("کتاب در کتابخانه موجود نیست و توسط فرد دیگری به امانت برده شده است!");
                }else {
                    library.bookLBS[indexBook].setStateBook(StateBook.NOT_REDYE);
                    library.memberLBS[indexMember].setRentBook(false);
                    library.memberLBS[indexMember].setNameRentBook(library.bookLBS[indexBook].getName());
                    System.out.println("کتاب "+library.memberLBS[indexMember].getNameRentBook()+" به"+Gender.getGender(library.memberLBS[indexMember].getGenderCustomer())+library.memberLBS[indexMember].getNameCustomer()+" امانت داده شد");
                }
            }else {
                System.out.println("این کاربر کتاب "+library.memberLBS[indexMember].getNameRentBook()+" را به امانت برده است ونمیتواند تا برگرداندن آن کتاب دیگری تهیه کند!");
            }
        }

    }

    private static void deleteBook(int index) {
        if (index==-2){
            System.out.println("کتابی با این اسم تعریف نشده است!");
        }else {
            System.out.println(msgLine);
            if (library.bookLBS[index].getStateBook()==StateBook.NOT_REDYE){
                System.out.println("این کتاب در دست امانت میباشد. نمیتوانید آن را حذف کنید!");
            }else {
                library.bookLBS[index]=null;
                System.out.println("کتاب با موفقیت حذف شد");
            }
            System.out.println(msgLine);
        }
    }

    private static void readBook(int index) {
        System.out.println(msgLine);
        if (index==-2){
            System.out.println("همچین کتابی وجود ندارد");
        }else {
            BookLB book = library.bookLBS[index];
            System.out.println("کتاب :"+book.getName());
            System.out.println("تعداد صفحات :"+book.getPages());
            System.out.println("نویسنده :"+book.getWriter());
            System.out.println("وضعیت :"+book.getStateBook().getValue());
        }
        System.out.println(msgLine);
    }

    private static void updateBook(int index) {
        if (index==-2){
            System.out.println("همچین کاربری وجود ندارد");
        } else if (library.bookLBS[index].getStateBook()==StateBook.NOT_REDYE) {
            System.out.println("این کتاب در امانت میباشد امکان آپدیت کردن آن را ندارید");
        } else {
            System.out.println(msgLine);
            library.bookLBS[index].setName(getDataString(msgNameBook));
            library.bookLBS[index].setWriter(getDataString(msgWriterBook));
            library.bookLBS[index].setPages(getDataInt(msgPagesBook));
            System.out.println("اطلاعات کتاب با موفقیت تغیر پیدا کرد!");
            System.out.println(msgLine);
        }
    }

    private static void insertBook(int index) {
        System.out.println(msgLine);
        if (index==-1){
            System.out.println("جای خالی برای کتاب جدید وجود ندارد");
        }else {
            String name = getDataString(msgNameBook);
            String writer = getDataString(msgWriterBook);
            int page= getDataInt(msgPagesBook);
            library.bookLBS[index] = new BookLB(name,page,writer);
            System.out.println("کتاب با موفقیت وارد شد!");
        }
        System.out.println(msgLine);
    }

    private static void deleteCustomer(int index) {
        library.memberLBS[index]=null;
        System.out.println(msgLine);
        System.out.println("کاربر با موفقیت حذف شد");
        System.out.println(msgLine);
    }

    private static void readCustomer(int index) {
        System.out.println(msgLine);
        if (index==-1){
            System.out.println("همچین کاربری وجود ندارد");
        }else {
            MemberLB member = library.memberLBS[index];
            System.out.println("کد کاربری "+member.getKeyCustomer()+" مربوط به"+Gender.getGender(member.getGenderCustomer())+member.getNameCustomer()+" می باشد که "+member.getAgeCustomer()+" سن دارد");
        }
        System.out.println(msgLine);
    }

    private static int getIndexCoustomer(MemberLB[] memberLBS, int keyCustomer) {
        int result = -1;
        for (int i = 0; i < memberLBS.length; i++) {
            if (memberLBS[i]!=null&&memberLBS[i].getKeyCustomer()==keyCustomer) {
                result = i;
            }
        }
        return result;
    }
    private static int getIndexBook(BookLB[] bookLBS, String name) {
        int result = -2;
        for (int i = 0; i < bookLBS.length; i++) {
            if (bookLBS[i]!=null&&bookLBS[i].getName().equals(name)) {
                result = i;
            }
        }
        return result;
    }

    private static void updateCustomer(int index) {
        if (index==-1){
            System.out.println("همچین کاربری وجود ندارد");
        }else {
            System.out.println(msgLine);
            library.memberLBS[index].setNameCustomer(getDataString(msgNameCustomer));
            library.memberLBS[index].setAgeCustomer(getDataInt(msgAgeCustomer));
            library.memberLBS[index].setGenderCustomer(getGender(msgGenderCustomer));
            System.out.println("کاربر با موفقیت تغیر پیدا کرد!");
            System.out.println(msgLine);
        }

    }

    private static int mainMenu() {
        System.out.println(msgLine);
        System.out.println("منو اصلی");
        System.out.println("1) برای رفتن به بخش کاربران کتابخانه");
        System.out.println("2) برای رفتن به بخش کتاب های کتابخانه");
        System.out.println("3) خروج از برنامه");
        System.out.println(msgLine);
        return scanner.nextInt();
    }
    private static int customerMenu() {
        System.out.println(msgLine);
        System.out.println("منو کاربران");
        System.out.println("11)ایجاد کاربر");
        System.out.println("12)آپدیت کاربر");
        System.out.println("13)نشان دادن کاربر");
        System.out.println("14)حذف کاربر");
        System.out.println("15)بازگشت");
        System.out.println(msgLine);
        return scanner.nextInt();
    }
    private static int bookMenu() {
        System.out.println(msgLine);
        System.out.println("منو کتاب ها");
        System.out.println("21)ایجاد کتاب");
        System.out.println("22)آپدیت کتاب");
        System.out.println("23)نشان دادن کتاب");
        System.out.println("24)حذف کتاب");
        System.out.println("25)امانت دادن کتاب");
        System.out.println("26) پس دادن کتاب");
        System.out.println("27)بازگشت");
        System.out.println(msgLine);
        return scanner.nextInt();
    }


    // این متد یه پیغام میگیره و به کاربر نمایش میده و یه رشته از کاربر میگیرهِ
    private static String getDataString (String getStringMassage) {
        System.out.println(getStringMassage);
        return scanner.next();
    }
    // این متد یه پیغام میگیره و به کاربر نمایش میده و یه عدد از کاربر میگیرهِ
    private static int getDataInt (String getStringMassage) {
        System.out.println(getStringMassage);
        return scanner.nextInt();
    }

    /*
    * این متد یه ایندکس میگیره و اگه منفی ۱ نبود
    * داخل آرایه کاربران کتابخانه
    * کاربر جدید ایجاد میکنه
    * */
    private static void insertCustomer(int index) {
        System.out.println(msgLine);
        if (index==-1){
            System.out.println("جای خالی برای کاربر وجود ندارد");
        }else {
            int keyCustomer=10+index;
            String name = getDataString(msgNameCustomer);
            int age= getDataInt(msgAgeCustomer);
            Gender gender = getGender(msgGenderCustomer);
            library.memberLBS[index] = new MemberLB(keyCustomer,age,name,gender);
            System.out.println("کاریر با موفقیت وارد شد!");
        }
        System.out.println(msgLine);
    }
    // این متد یه پیام از کاربر میگیره و پس از نمایش آن جنسیت را با کارکتر اول تولید میکند و برمیگرداند
    private static Gender getGender(String massage) {
        System.out.println(massage);
        char val =scanner.next().charAt(0);
        if (val=='M'){
            return Gender.MALE;
        } else if (val=='F') {
            return Gender.FEMALE;
        }else {
            return Gender.OTHER;
        }
    }


}