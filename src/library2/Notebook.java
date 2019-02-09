package library.library2;

public class Notebook extends Products implements Mes {

    Notebook(String title, int id, double price, Notebook t) {

        super(title, id, price, t);
    }

    @Override
    public String mes() {
        return " metoda din clasa Notebook";
    }
}
