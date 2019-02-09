package teste;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        AddP add = new AddP();


        add.readBook(s);
        System.out.println();

        add.readBook(s);
        System.out.println();

        add.readPen(s);
        System.out.println();

        add.readPen(s);
        System.out.println();

        add.readBook(s);
        System.out.println();

        add.readBook(s);
        System.out.println();

        add.readPen(s);
        System.out.println();

        add.readPen(s);
        System.out.println();

        add.readNotebook(s);
        System.out.println();

        add.readNotebook(s);
        System.out.println();

        add.readNotebook(s);
        System.out.println();


        add.writeAll();
        System.out.println();


    }
}
