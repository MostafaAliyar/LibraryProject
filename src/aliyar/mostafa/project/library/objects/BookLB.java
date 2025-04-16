package aliyar.mostafa.project.library.objects;

public class BookLB {
    private String name;
    private String writer;
    private int pages;
    private StateBook stateBook = StateBook.REDYE;
    public BookLB(String name, int pages, String writer) {
        this.name = name;
        this.pages = pages;
        this.writer = writer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getName() {
        return name;
    }
    public String getWriter() {
        return writer;
    }
    public int getPages() {
        return pages;
    }
    public StateBook getStateBook() {
        return stateBook;
    }

    public void setStateBook(StateBook stateBook) {
        this.stateBook = stateBook;
    }
}
