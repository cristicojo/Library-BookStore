package library;

import java.io.PrintStream;
import java.util.Scanner;

public class Navigation {

    BookStore bookstore;
    Scanner s;
    PrintStream ps;

    public Navigation(BookStore bookstore, Scanner s, PrintStream ps) {

        this.bookstore = bookstore;
        this.s = s;
        this.ps = ps;
    }

    public void mainMenu() throws ProductNameTooLongException, PriceTooHighException {
        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                addProduct();

            case 2:
                listProduct();

            case 3:
                buyProduct();

            case 4:
                sortProduct();

            case 5:
                System.exit(0);
        }

    }

    public void addProduct() throws ProductNameTooLongException, PriceTooHighException {
        System.out.println();
        System.out.println(Texts.addProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();


        switch (n) {
            case 1:
                System.out.println();
                bookstore.readBook(s, ps);
                addProduct();

            case 2:
                System.out.println();
                bookstore.readNotebook(s, ps);
                addProduct();

            case 3:
                System.out.println();
                bookstore.readPen(s, ps);
                addProduct();

            case 4:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }

    }

    public void listProduct() throws ProductNameTooLongException, PriceTooHighException {
        System.out.println();
        System.out.println(Texts.listProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                System.out.println();
                bookstore.printBooks(ps);
                listProduct();

            case 2:
                System.out.println();
                bookstore.printNotebooks(ps);
                listProduct();

            case 3:
                System.out.println();
                bookstore.printPens(ps);
                listProduct();

            case 4:
                System.out.println();
                bookstore.printProducts(ps);
                listProduct();

            case 5:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }

    }

    public void buyProduct() throws ProductNameTooLongException, PriceTooHighException {
        System.out.println();
        System.out.println(Texts.buyProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                System.out.println();
                addProduct();
                buyProduct();

            case 2:
                System.out.println();
                System.out.println("Total carti: " + bookstore.totalBooks());
                System.out.println("Total caiete: " + bookstore.totalNotebooks());
                System.out.println("Total pixuri: " + bookstore.totalPens());
                System.out.println("Total produse: " + bookstore.totalProducts());
                buyProduct();

            case 3:
                System.out.println();
                listProduct();

            case 4:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }
    }

    public void sortProduct() throws ProductNameTooLongException, PriceTooHighException {
        System.out.println();
        System.out.println(Texts.sortProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                bookstore.sortBooksA();
                System.out.println();
                bookstore.printBooks(ps);
                sortProduct();

            case 2:
                bookstore.sortBooksD();
                System.out.println();
                bookstore.printBooks(ps);
                sortProduct();

            case 3:
                bookstore.sortBooksAI();
                System.out.println();
                bookstore.printBooks(ps);
                sortProduct();

            case 4:
                bookstore.sortBooksDI();
                System.out.println();
                bookstore.printBooks(ps);
                sortProduct();

            case 5:
                bookstore.sortNotebooksA();
                System.out.println();
                bookstore.printNotebooks(ps);
                sortProduct();

            case 6:
                bookstore.sortNotebooksD();
                System.out.println();
                bookstore.printNotebooks(ps);
                sortProduct();

            case 7:
                bookstore.sortNotebooksAI();
                System.out.println();
                bookstore.printNotebooks(ps);
                sortProduct();

            case 8:
                bookstore.sortNotebooksDI();
                System.out.println();
                bookstore.printNotebooks(ps);
                sortProduct();

            case 9:
                bookstore.sortPensA();
                System.out.println();
                bookstore.printPens(ps);
                sortProduct();

            case 10:
                bookstore.sortPensD();
                System.out.println();
                bookstore.printPens(ps);
                sortProduct();

            case 11:
                bookstore.sortPensAI();
                System.out.println();
                bookstore.printPens(ps);
                sortProduct();

            case 12:
                bookstore.sortPensDI();
                System.out.println();
                bookstore.printPens(ps);
                sortProduct();

            case 13:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }


    }


}
