package library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadFile {

    private Path path;
    private List<String> productsFile;

    private List<String> bookList = new ArrayList<>();
    private List<String> penList = new ArrayList<>();
    private List<String> notebookList = new ArrayList<>();


    ReadFile() throws IOException {

        path = Paths.get("/Users/cristi/Desktop/produse.txt");
        productsFile = Files.readAllLines(path);

    }


    public void readFileBooks() {

        if (bookList.size() == 0) {
            for (String product : productsFile) {

                StringTokenizer tokenizer = new StringTokenizer(product, ",");

                while (tokenizer.hasMoreTokens()) {

                    if (product.startsWith("C") || product.startsWith("c") || product.startsWith("B") || product.startsWith("b"))

                        bookList.add(tokenizer.nextToken(","));

                    else break;
                }
            }
        }


        for (int i = 0; i < bookList.size(); i++) {

            if (bookList.get(i).equals("nu"))
                System.out.println(bookList.get(i));

            else if (bookList.get(i).equals("da")) {

                System.out.println(bookList.get(i) + "," + bookList.get(i + 1));
                i++;
            } else
                System.out.print(bookList.get(i) + ",");
        }

        System.out.println();

    }

    public void readFileNotebooks() {
        System.out.println();

        if (notebookList.size() == 0) {
            for (String product : productsFile) {

                StringTokenizer tokenizer = new StringTokenizer(product, ",");

                while (tokenizer.hasMoreTokens()) {

                    if (product.startsWith("N") || product.startsWith("n")
                            || product.startsWith("Caiet") || product.startsWith("caiet"))

                        notebookList.add(tokenizer.nextToken(","));

                    else break;
                }
            }
        }

        for (int i = 0; i < notebookList.size(); i++) {

            if (notebookList.get(i).equals("nu"))
                System.out.println(notebookList.get(i));

            else if (notebookList.get(i).equals("da")) {

                System.out.println(notebookList.get(i) + "," + notebookList.get(i + 1));
                i++;
            } else
                System.out.print(notebookList.get(i) + ",");
        }

        System.out.println();
    }


    public void readFilePens() {
        System.out.println();

        if (penList.size() == 0) {
            for (String product : productsFile) {

                StringTokenizer tokenizer = new StringTokenizer(product, ",");

                while (tokenizer.hasMoreTokens()) {

                    if (product.startsWith("P") || product.startsWith("p"))

                        penList.add(tokenizer.nextToken(","));

                    else break;
                }
            }
        }


        for (int i = 0; i < penList.size(); i++) {

            if (penList.get(i).equals("nu"))
                System.out.println(penList.get(i));

            else if (penList.get(i).equals("da")) {

                System.out.println(penList.get(i));
            } else
                System.out.print(penList.get(i) + ",");

        }

        System.out.println();
    }

}
