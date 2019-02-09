package library.library2;

public class Pen extends Products implements Mes {

    Pen(String title, int id, double price, Pen t) {

        super(title, id, price, t);

    }

    @Override
    public String mes() {
        return " metoda din clasa Pen";
    }
}
