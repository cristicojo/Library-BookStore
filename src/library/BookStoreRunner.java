package library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BookStoreRunner {


    public static void main(String[] args) throws FileNotFoundException, ProductNameTooLongException, PriceTooHighException {

        System.out.println(Texts.mainMenu());

        BookStore bs = new BookStore();
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream("/Users/cristi/Desktop/produse.txt", true));

        Navigation nav = new Navigation(bs, s, ps);

        nav.mainMenu();


    }
}
