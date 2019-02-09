package library.library2;

public class Products<T> {

    private String title;
    private int id;
    private double price;

    private T t;

    public Products(String title, int id, double price, T t) {

        this.title = title;
        this.id = id;
        this.price = price;
        this.t = t;

    }


    public String toString() {
        return
                title + " " + "Id=" + id + " " + "Pret=" + price;

    }

}
