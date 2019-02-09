package library;

import java.io.PrintStream;
import java.util.*;

public class BookStore {
    private List<Book> books = new ArrayList<>();
    private List<Pen> pens = new ArrayList<>();
    private List<Notebook> notebooks = new ArrayList<>();

    private double totalB;
    private double total1B;

    private double totalN;
    private double total1N;

    private double totalP;

    public void addBook(Book book) {

        books.add(book);
    }

    public void addPen(Pen pen) {

        pens.add(pen);
    }

    public void addNotebook(Notebook notebook) {

        notebooks.add(notebook);
    }

    public void printBooks(PrintStream ps) {

        ps.println();

        for (Book z : books) {

            String q;
            if (z.isOnOffer() == true)
                q = "da";
            else
                q = "nu";

            System.out.println("Carte: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                    + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPrice());

            ps.println("Carte: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                    + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPrice());
        }
    }

    public void printPens(PrintStream ps) {
        ps.println();

        for (Pen z : pens) {

            String q;
            if (z.isOnOffer() == true)
                q = "da";
            else
                q = "nu";

            if (z.isOnOffer() == true) {
                System.out.println("Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPricee());
                ps.println("Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPricee());
            } else {
                System.out.println("Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.getPrice());
                ps.println("Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.getPrice());
            }


        }
    }


    public void printNotebooks(PrintStream ps) {
        ps.println();

        for (Notebook z : notebooks) {
            String q;
            if (z.isOnOffer() == true)
                q = "da";
            else
                q = "nu";

            System.out.println("Notebook: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                    + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPrice());

            ps.println("Notebook: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                    + q + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.CalculatedDiscountedPrice());
        }
    }

    public void printProducts(PrintStream ps) {

        printBooks(ps);
        printNotebooks(ps);
        printPens(ps);

    }


    public void readBook(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
        System.out.print("Dati numele cartii pe care vrei sa o adaugi: ");
        s.nextLine();
        String tempName = s.nextLine();

        if (tempName.length() > 32) {
            throw new ProductNameTooLongException("numele nu trebuie sa depaseasca 32 de caractere");
        } else
            ps.print("Carte: " + tempName);

        System.out.print("Dati id: ");
        int tempId = s.nextInt();
        ps.print("," + tempId);

        System.out.print("Dati pretul: ");
        double tempPret = s.nextDouble();

        if (tempPret > 5000) {
            throw new PriceTooHighException("pretul nu trebuie sa fie mai mare de 5000");
        } else
            ps.print("," + tempPret);

        System.out.print("Este la oferta: ");
        s.nextLine();
        boolean tempisOnOffer = false;

        int tempofferDiscount = 0;
        if (s.nextLine().equals("da")) {

            tempisOnOffer = true;

            ps.print(",da");

            System.out.print("Cat oferiti discount: ");
            tempofferDiscount = s.nextInt();

            if (tempofferDiscount > 100) {
                throw new DiscountTooHighException("discountul nu trebuie sa fie mai mare de 100");

            } else
                ps.println("," + tempofferDiscount);
        } else
            ps.println(",nu");


        Book b = new Book(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addBook(b);

        if (tempisOnOffer) {
            System.out.println("Pretul cartii " + s.nextLine() + "cu discount de " + tempofferDiscount + " este " + b.CalculatedDiscountedPrice());

            totalB = totalB + b.CalculatedDiscountedPrice();

        } else
            total1B = total1B + tempPret;


        System.out.println(totalB + total1B);

    }

    public double totalBooks() {

        return totalB + total1B;
    }


    public void sortBooksA() {

        Collections.sort(books, Comparator.comparing(Book::getTitle));

    }

    public void sortBooksD() {

        Collections.sort(books, Comparator.comparing(Book::getTitle).reversed());

    }

    public void sortBooksAI() {

        Collections.sort(books, Comparator.comparing(Book::getId));

    }

    public void sortBooksDI() {

        Collections.sort(books, Comparator.comparing(Book::getId).reversed());

    }


    public void readPen(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
        System.out.print("Dati numele pixului pe care vrei sa il adaugi: ");
        s.nextLine();
        String tempName = s.nextLine();

        if (tempName.length() > 32) {
            throw new ProductNameTooLongException("numele nu trebuie sa depaseasca 32 de caractere");
        } else
            ps.print("Pix: " + tempName);

        System.out.print("Dati id: ");
        int tempId = s.nextInt();
        ps.print("," + tempId);

        System.out.print("Dati pretul: ");
        double tempPret = s.nextDouble();

        if (tempPret > 5000) {
            throw new PriceTooHighException("pretul nu trebuie sa fie mai mare de 5000");
        } else
            ps.print("," + tempPret);

        System.out.print("Este la oferta: ");
        s.nextLine();
        boolean tempisOnOffer = false;


        if (s.nextLine().equals("da")) {
            tempisOnOffer = true;

            ps.println(",da");

            System.out.println("Ne pare rau!! Am ramas fara pixuri la oferta!!!!");

        } else
            ps.println(",nu");


        int tempofferDiscount = 0;

        Pen p = new Pen(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addPen(p);

        totalP = totalP + tempPret;

        System.out.println(totalP);


    }


    public double totalPens() {

        return totalP;
    }


    public void sortPensA() {

        Collections.sort(pens, Comparator.comparing(Pen::getTitle));

    }

    public void sortPensD() {

        Collections.sort(pens, Comparator.comparing(Pen::getTitle).reversed());

    }

    public void sortPensAI() {

        Collections.sort(pens, Comparator.comparing(Pen::getId));

    }

    public void sortPensDI() {

        Collections.sort(pens, Comparator.comparing(Pen::getId).reversed());

    }


    public void readNotebook(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
        System.out.print("Dati numele notebook-ului pe care vrei sa il adaugi: ");
        s.nextLine();
        String tempName = s.nextLine();

        if (tempName.length() > 32) {
            throw new ProductNameTooLongException("numele nu trebuie sa depaseasca 32 de caractere");
        } else
            ps.print("Notebook: " + tempName);

        System.out.print("Dati id: ");
        int tempId = s.nextInt();
        ps.print("," + tempId);

        System.out.print("Dati pretul: ");
        double tempPret = s.nextDouble();

        if (tempPret > 5000) {
            throw new PriceTooHighException("pretul nu trebuie sa fie mai mare de 5000");
        } else
            ps.print("," + tempPret);

        System.out.print("Este la oferta: ");
        s.nextLine();
        boolean tempisOnOffer = false;

        int tempofferDiscount = 0;
        if (s.nextLine().equals("da")) {
            tempisOnOffer = true;

            ps.print(",da");

            System.out.print("Cat oferiti discount: ");
            tempofferDiscount = s.nextInt();

            if (tempofferDiscount > 100) {
                throw new DiscountTooHighException("discountul nu trebuie sa fie mai mare de 100");

            } else
                ps.println("," + tempofferDiscount);
        } else
            ps.println(",nu");


        Notebook n = new Notebook(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addNotebook(n);
        if (tempisOnOffer) {
            System.out.println("Pretul notebook-ului " + s.nextLine() + "cu discount de " + tempofferDiscount + " este " + n.CalculatedDiscountedPrice());

            totalN = totalN + n.CalculatedDiscountedPrice();

        } else
            total1N = total1N + tempPret;

        System.out.println(totalN + total1N);
    }

    public double totalNotebooks() {

        return totalN + total1N;
    }

    public double totalProducts() {

        return totalBooks() + totalPens() + totalNotebooks();
    }

    public void sortNotebooksA() {

        Collections.sort(notebooks, Comparator.comparing(Notebook::getTitle));

    }

    public void sortNotebooksD() {

        Collections.sort(notebooks, Comparator.comparing(Notebook::getTitle).reversed());

    }

    public void sortNotebooksAI() {

        Collections.sort(notebooks, Comparator.comparing(Notebook::getId));

    }

    public void sortNotebooksDI() {

        Collections.sort(notebooks, Comparator.comparing(Notebook::getId).reversed());
    }
}
