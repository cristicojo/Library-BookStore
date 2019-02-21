package library;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Navigation {

    BookStore bookstore;
    Scanner s;
    PrintStream ps;
    ReadFile rf;

    public Navigation(BookStore bookstore, Scanner s, PrintStream ps, ReadFile rf) {

        this.bookstore = bookstore;
        this.s = s;
        this.ps = ps;
        this.rf = rf;
    }

    public void mainMenu() throws ProductNameTooLongException, PriceTooHighException, IOException {
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

    public void addProduct() throws ProductNameTooLongException, PriceTooHighException, IOException{
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

    public void listProduct() throws ProductNameTooLongException, PriceTooHighException, IOException {
        System.out.println();
        System.out.println(Texts.listProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                System.out.println();
                bookstore.printBooks(rf);
                listProduct();

            case 2:
                System.out.println();
                bookstore.printNotebooks(rf);
                listProduct();

            case 3:
                System.out.println();
                bookstore.printPens(rf);
                listProduct();

            case 4:
                System.out.println();
                bookstore.printProducts(rf);
                listProduct();

            case 5:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }

    }

    public void buyProduct() throws ProductNameTooLongException, PriceTooHighException, IOException{
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
                System.out.println("Total carti: " + bookstore.totalPriceBooks());
                System.out.println("Total caiete: " + bookstore.totalPriceNotebooks());
                System.out.println("Total pixuri: " + bookstore.totalPricePens());
                System.out.println("Total produse: " + bookstore.totalPriceProducts());
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

    public void sortProduct() throws ProductNameTooLongException, PriceTooHighException, IOException{
        System.out.println();
        System.out.println(Texts.sortProductsMenu());

        System.out.print("\tdati optiunea: ");
        int n = s.nextInt();

        switch (n) {
            case 1:
                bookstore.sortBooksTA();
                System.out.println();
                sortProduct();

            case 2:
                bookstore.sortBooksTD();
                System.out.println();
                sortProduct();

            case 3:
                bookstore.sortBooksIA();
                System.out.println();
                sortProduct();

            case 4:
                bookstore.sortBooksID();
                System.out.println();
                sortProduct();

            case 5:
                bookstore.sortNotebooksTA();
                System.out.println();
                sortProduct();

            case 6:
                bookstore.sortNotebooksTD();
                System.out.println();
                sortProduct();

            case 7:
                bookstore.sortNotebooksIA();
                System.out.println();
                sortProduct();

            case 8:
                bookstore.sortNotebooksID();
                System.out.println();
                sortProduct();

            case 9:
                bookstore.sortPensTA();
                System.out.println();
                sortProduct();

            case 10:
                bookstore.sortPensTD();
                System.out.println();
                sortProduct();

            case 11:
                bookstore.sortPensIA();
                System.out.println();
                sortProduct();

            case 12:
                bookstore.sortPensID();
                System.out.println();
                sortProduct();

            case 13:
                System.out.println();
                System.out.println(Texts.mainMenu());
                mainMenu();
        }


    }


}
