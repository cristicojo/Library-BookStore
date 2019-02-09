package library.library2;

import java.util.*;

public class AddP {

    private List<? super Products> prods = new ArrayList<>();

    private Book b;
    private Pen p;
    private Notebook n;

    public void readBook(Scanner s) {

        System.out.print("Dati nume la carte: ");
        String nume = s.next();
        s.nextLine();


        System.out.print("Dati id la carte: ");
        int id = s.nextInt();

        System.out.print("Dati pret la carte: ");
        double pret = s.nextDouble();


        Products<Book> pb = new Book(nume, id, pret, b);
        prods.add(pb);
    }


    public void readPen(Scanner s) {
        System.out.print("Dati nume la pix: ");
        s.nextLine();
        String nume = s.nextLine();

        System.out.print("Dati id la pix: ");
        int id = s.nextInt();

        System.out.print("Dati pret la pix: ");
        double pret = s.nextDouble();


        Products<Pen> pp = new Pen(nume, id, pret, p);
        prods.add(pp);
    }


    public void readNotebook(Scanner s) {

        System.out.print("Dati nume la notebook: ");
        s.nextLine();
        String nume = s.nextLine();


        System.out.print("Dati id la notebook: ");
        int id = s.nextInt();

        System.out.print("Dati pret la notebook: ");
        double pret = s.nextDouble();

        Products<Notebook> pn = new Notebook(nume, id, pret, n);
        prods.add(pn);
    }


    public void writeAll() {


        for (Object z : prods) {

            if (z instanceof Book) {
                System.out.println("Carte: Nume=" + z.toString() + ((Book) z).mes());
            }

            if (z instanceof Pen) {
                System.out.println("Pix: Nume=" + z.toString() + ((Pen) z).mes());
            }

            if (z instanceof Notebook) {
                System.out.println("Notebook: Nume=" + z.toString() + ((Notebook) z).mes());
            }
        }


    }

}



