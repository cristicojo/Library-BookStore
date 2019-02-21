package library;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

class BookStore {

    private static final String ANSI_CYAN = "\u001B[96m";
    private static final String ANSI_RESET = "\u001B[0m";

    private List<? super Products> products = new ArrayList<>();

    //pt meniul de sortare
    private List<Book> bookList = new ArrayList<>();
    private List<Pen> penList = new ArrayList<>();
    private List<Notebook> notebookList = new ArrayList<>();


    void addBook(Products<Book> book) {

        products.add(book);
    }

    void addPen(Products<Pen> pen) {

        products.add(pen);
    }


    void addNotebook(Products<Notebook> notebook) {

        products.add(notebook);
    }


    void printBooks(ReadFile rf) {

        int contor = 0;
        for (Object z : products) {
            if (z instanceof Book) {

                String danu;
                if (((Book) z).isOnOffer())
                    danu = "da";
                else
                    danu = "nu";

                contor++;
                System.out.println(contor + ": Carte: Nume --> " + ((Book) z).getTitle() + "; Id --> " + ((Book) z).getId() + "; Pret initial --> " + ((Book) z).getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + ((Book) z).getOfferDiscount() + "; Pret final --> " + ((Book) z).calculatedDiscountedPrice());

            }
        }

        rf.readFileBooks();

    }

    void printNotebooks(ReadFile rf) {

        int contor = 0;
        for (Object z : products) {
            if (z instanceof Notebook) {

                String danu;
                if (((Notebook) z).isOnOffer())
                    danu = "da";
                else
                    danu = "nu";

                contor++;
                System.out.println(contor + ": Notebook: Nume --> " + ((Notebook) z).getTitle() + "; Id --> " + ((Notebook) z).getId() + "; Pret initial --> " + ((Notebook) z).getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + ((Notebook) z).getOfferDiscount() + "; Pret final --> " + ((Notebook) z).calculatedDiscountedPrice());

            }
        }

        rf.readFileNotebooks();
    }

    void printPens(ReadFile rf) {

        int contor = 0;
        for (Object z : products) {
            if (z instanceof Pen) {

                String danu;
                if (((Pen) z).isOnOffer()) {

                    danu = "da";
                    contor++;
                    System.out.println(contor + ": Pix: Nume --> " + ((Pen) z).getTitle() + "; Id --> " + ((Pen) z).getId() + "; Pret initial --> " + ((Pen) z).getPrice() + "; Este la oferta --> "
                            + danu + "; Discount --> " + ((Pen) z).getOfferDiscount() + "; Pret final --> " + ((Pen) z).noPensMessage());
                } else {
                    contor++;
                    danu = "nu";
                    System.out.println(contor + ": Pix: Nume --> " + ((Pen) z).getTitle() + "; Id --> " + ((Pen) z).getId() + "; Pret initial --> " + ((Pen) z).getPrice() + "; Este la oferta --> "
                            + danu + "; Discount --> " + ((Pen) z).getOfferDiscount() + "; Pret final --> " + ((Pen) z).getPrice());
                }

            }

        }

        rf.readFilePens();
    }


    void printProducts(ReadFile rf) {

        int contor = 0;
        for (int i = 0; i < products.size(); i++) {
            contor++;

            if (products.get(i) instanceof Book) {

                Book z = ((Book) products.get(i));

                String danu;
                if (z.isOnOffer())
                    danu = "da";
                else
                    danu = "nu";

                System.out.println(contor + ": Carte: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.calculatedDiscountedPrice());

            } else if (products.get(i) instanceof Notebook) {

                Notebook z = ((Notebook) products.get(i));

                String danu;
                if (z.isOnOffer())
                    danu = "da";
                else
                    danu = "nu";


                System.out.println(contor + ": Notebook: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.calculatedDiscountedPrice());

            } else if (products.get(i) instanceof Pen) {

                Pen z = ((Pen) products.get(i));

                String danu;
                if (z.isOnOffer()) {

                    danu = "da";
                    System.out.println(contor + ": Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                            + danu + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.noPensMessage());
                } else {
                    danu = "nu";
                    System.out.println(contor + ": Pix: Nume --> " + z.getTitle() + "; Id --> " + z.getId() + "; Pret initial --> " + z.getPrice() + "; Este la oferta --> "
                            + danu + "; Discount --> " + z.getOfferDiscount() + "; Pret final --> " + z.getPrice());
                }
            }
        }

        System.out.println();

        System.out.print(ANSI_CYAN+"Toate produsele inclusiv din fisier:");

        System.out.println(ANSI_RESET);
        printBooks(rf);
        printNotebooks(rf);
        printPens(rf);

    }


    void readBook(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
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


        Products<Book> prodBooks = new Book(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addBook(prodBooks);

        if (tempisOnOffer) {
            System.out.println("Pretul cartii " + s.nextLine() + "cu discount de " + tempofferDiscount + " este " + ((Book) prodBooks).calculatedDiscountedPrice());

        }


        //adaugam toate Book-urile din lista de produse in lista de Book-uri (fara a mai instantia o data clasa Book)
        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).equals(prodBooks)) {

                bookList.add(((Book) products.get(i)));
            }
        }


    }

    double totalPriceBooks() {

        double totalPriceB = 0;


        for (Object z : products) {
            if (z instanceof Book) {
                Book book = (Book) z;
                if (book.isOnOffer()) {

                    totalPriceB = totalPriceB + book.calculatedDiscountedPrice();

                } else
                    totalPriceB = totalPriceB + book.price;

            }
        }
        return totalPriceB;
    }


    void readPen(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
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

        Products<Pen> prodPens = new Pen(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addPen(prodPens);


        //adaugam toate Pen-urile din lista de produse in lista de Pen-uri (fara a mai instantia o data clasa Pen)
        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).equals(prodPens)) {

                penList.add(((Pen) products.get(i)));
            }
        }

    }

    double totalPricePens() {

        double totalPriceP = 0;

        for (Object z : products) {
            if (z instanceof Pen) {

                Pen pen = (Pen) z;
                if (pen.isOnOffer())
                    totalPriceP = totalPriceP + pen.offerDiscount;
                else
                    totalPriceP = totalPriceP + pen.price;
            }
        }
        return totalPriceP;
    }


    void readNotebook(Scanner s, PrintStream ps) throws ProductNameTooLongException, PriceTooHighException {
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


        Products<Notebook> prodNotebooks = new Notebook(tempName, tempId, tempPret, tempisOnOffer, tempofferDiscount);
        addNotebook(prodNotebooks);

        if (tempisOnOffer)
            System.out.println("Pretul notebook-ului " + s.nextLine() + "cu discount de " + tempofferDiscount + " este " + ((Notebook) prodNotebooks).calculatedDiscountedPrice());


        //adaugam toate Notebook-urile din lista de produse in lista de Notebook-uri (fara a mai instantia o data clasa Notebook)
        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).equals(prodNotebooks)) {

                notebookList.add(((Notebook) products.get(i)));
            }
        }

    }

    double totalPriceNotebooks() {

        double totalPriceN = 0;


        for (Object z : products) {
            if (z instanceof Notebook) {

                Notebook notebook = (Notebook) z;
                if (notebook.isOnOffer())
                    totalPriceN = totalPriceN + notebook.calculatedDiscountedPrice();
                else
                    totalPriceN = totalPriceN + notebook.price;
            }
        }

        return totalPriceN;
    }

    double totalPriceProducts() {

        return totalPriceBooks() + totalPricePens() + totalPriceNotebooks();
    }

    public void sortBooksTA() {
        System.out.println();

        int contor = 0;

        Collections.sort(bookList, Comparator.comparing(Book::getTitle));

        for (Book b : bookList) {

            String danu;
            if (b.isOnOffer())
                danu = "da";
            else
                danu = "nu";
            contor++;
            System.out.println(contor + ": Carte: Nume --> " + b.getTitle() + "; Id --> " + b.getId() + "; Pret initial --> " + b.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + b.getOfferDiscount() + "; Pret final --> " + b.calculatedDiscountedPrice());

        }
    }

    public void sortBooksTD() {
        System.out.println();

        int contor = 0;

        Collections.sort(bookList, Comparator.comparing(Book::getTitle).reversed());

        for (Book b : bookList) {

            String danu;
            if (b.isOnOffer())
                danu = "da";
            else
                danu = "nu";
            contor++;
            System.out.println(contor + ": Carte: Nume --> " + b.getTitle() + "; Id --> " + b.getId() + "; Pret initial --> " + b.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + b.getOfferDiscount() + "; Pret final --> " + b.calculatedDiscountedPrice());

        }
    }


    public void sortBooksIA() {
        System.out.println();
        int contor = 0;
        Collections.sort(bookList, Comparator.comparing(Book::getId));

        for (Book b : bookList) {

            String danu;
            if (b.isOnOffer())
                danu = "da";
            else
                danu = "nu";
            contor++;
            System.out.println(contor + ": Carte: Nume --> " + b.getTitle() + "; Id --> " + b.getId() + "; Pret initial --> " + b.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + b.getOfferDiscount() + "; Pret final --> " + b.calculatedDiscountedPrice());

        }
    }

    public void sortBooksID() {
        System.out.println();
        int contor = 0;
        Collections.sort(bookList, Comparator.comparing(Book::getId).reversed());

        for (Book b : bookList) {

            String danu;
            if (b.isOnOffer())
                danu = "da";
            else
                danu = "nu";

            contor++;
            System.out.println(contor + ": Carte: Nume --> " + b.getTitle() + "; Id --> " + b.getId() + "; Pret initial --> " + b.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + b.getOfferDiscount() + "; Pret final --> " + b.calculatedDiscountedPrice());

        }
    }


    public void sortPensTA() {
        System.out.println();
        int contor = 0;
        Collections.sort(penList, Comparator.comparing(Pen::getTitle));

        for (Pen p : penList) {

            String danu;

            if (p.isOnOffer()) {

                danu = "da";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.noPensMessage());

            } else {
                danu = "nu";

                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.getPrice());
            }

        }
    }

    public void sortPensTD() {
        System.out.println();
        int contor = 0;
        Collections.sort(penList, Comparator.comparing(Pen::getTitle).reversed());

        for (Pen p : penList) {

            String danu;

            if (p.isOnOffer()) {

                danu = "da";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.noPensMessage());

            } else {
                danu = "nu";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.getPrice());
            }
        }
    }

    public void sortPensIA() {
        System.out.println();
        int contor = 0;
        Collections.sort(penList, Comparator.comparing(Pen::getId));

        for (Pen p : penList) {

            String danu;

            if (p.isOnOffer()) {

                danu = "da";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.noPensMessage());

            } else {
                danu = "nu";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.getPrice());
            }

        }
    }

    public void sortPensID() {
        System.out.println();
        int contor = 0;
        Collections.sort(penList, Comparator.comparing(Pen::getId).reversed());

        for (Pen p : penList) {

            String danu;

            if (p.isOnOffer()) {

                danu = "da";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.noPensMessage());

            } else {
                danu = "nu";
                contor++;
                System.out.println(contor + ": Pix: Nume --> " + p.getTitle() + "; Id --> " + p.getId() + "; Pret initial --> " + p.getPrice() + "; Este la oferta --> "
                        + danu + "; Discount --> " + p.getOfferDiscount() + "; Pret final --> " + p.getPrice());
            }

        }
    }

    public void sortNotebooksTA() {
        System.out.println();
        int contor = 0;
        Collections.sort(notebookList, Comparator.comparing(Notebook::getTitle));

        for (Notebook n : notebookList) {

            String danu;
            if (n.isOnOffer())
                danu = "da";
            else
                danu = "nu";

            contor++;
            System.out.println(contor + ": Caiet: Nume --> " + n.getTitle() + "; Id --> " + n.getId() + "; Pret initial --> " + n.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + n.getOfferDiscount() + "; Pret final --> " + n.calculatedDiscountedPrice());

        }
    }

    public void sortNotebooksTD() {
        System.out.println();
        int contor = 0;
        Collections.sort(notebookList, Comparator.comparing(Notebook::getTitle).reversed());

        for (Notebook n : notebookList) {

            String danu;
            if (n.isOnOffer())
                danu = "da";
            else
                danu = "nu";

            contor++;
            System.out.println(contor + ": Caiet: Nume --> " + n.getTitle() + "; Id --> " + n.getId() + "; Pret initial --> " + n.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + n.getOfferDiscount() + "; Pret final --> " + n.calculatedDiscountedPrice());

        }
    }

    public void sortNotebooksIA() {
        System.out.println();
        int contor = 0;
        Collections.sort(notebookList, Comparator.comparing(Notebook::getId));

        for (Notebook n : notebookList) {

            String danu;
            if (n.isOnOffer())
                danu = "da";
            else
                danu = "nu";

            contor++;
            System.out.println(contor + ": Caiet: Nume --> " + n.getTitle() + "; Id --> " + n.getId() + "; Pret initial --> " + n.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + n.getOfferDiscount() + "; Pret final --> " + n.calculatedDiscountedPrice());

        }
    }

    public void sortNotebooksID() {
        System.out.println();
        int contor = 0;
        Collections.sort(notebookList, Comparator.comparing(Notebook::getId).reversed());

        for (Notebook n : notebookList) {

            String danu;
            if (n.isOnOffer())
                danu = "da";
            else
                danu = "nu";

            contor++;
            System.out.println(contor + ": Caiet: Nume --> " + n.getTitle() + "; Id --> " + n.getId() + "; Pret initial --> " + n.getPrice() + "; Este la oferta --> "
                    + danu + "; Discount --> " + n.getOfferDiscount() + "; Pret final --> " + n.calculatedDiscountedPrice());

        }
    }

}
