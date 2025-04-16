package aliyar.mostafa.project.library.objects;

public enum Order {
    ORDER(0),
    CUSTOMER_MENU(1),
    INSERT_CUSTOMER (11),
    UPDATE_CUSTOMER (12),
    READ_CUSTOMER (13),
    DELETE_CUSTOMER (14),
    EXIT_CUSTOMER (15),
    BOOKS_MENU(2),
    INSERT_BOOKS (21),
    UPDATE_BOOKS (22),
    READ_BOOKS (23),
    DELETE_BOOKS (24),
    LENDING_BOOKS (25),
    BACK_BOOKS (26),
    EXIT_BOOKS (27),
    EXIT(3);
    private final int value;
    private Order(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
