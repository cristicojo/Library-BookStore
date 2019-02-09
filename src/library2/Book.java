package library.library2;

public class Book extends Products implements Mes {

    Book(String title, int id, double price, Book t) {

        super(title, id, price, t);

    }

    @Override
    public String mes() {
        return " metoda din clasa Book";
    }
}
