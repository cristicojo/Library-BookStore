package library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class BookStoreRunner {

    public static void main(String[] args) throws IOException, ProductNameTooLongException, PriceTooHighException {

        System.out.println(Texts.mainMenu());

        BookStore bs = new BookStore();
        Scanner s = new Scanner(System.in);
        PrintStream ps = new PrintStream(new FileOutputStream("/Users/cristi/Desktop/produse.txt", true));
        ReadFile rf=new ReadFile();

        Navigation nav = new Navigation(bs, s, ps, rf);

        nav.mainMenu();

    }
}
