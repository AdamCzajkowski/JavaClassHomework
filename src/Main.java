
// Author: Adam Czajkowski
// Date: 22nd Feb 2019

import jdk.nashorn.api.scripting.URLReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
// exercise 1
    static void ex1_readStringFromFile() throws FileNotFoundException {
        File file = new File("dane1.txt"); //file with sample text
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){ //until EOF
            System.out.println(scanner.nextLine()); //read next line of file
        }
    }

// exercise 2
    static void ex2_readIntFromFileAndPrintSum() throws FileNotFoundException{
        File file = new File("dane1.txt"); //file with sample numbers
        Scanner scanner = new Scanner(file);

        int sum=0;
        while(scanner.hasNext()){ //hasNext() igonere whitespaces in file
            sum=sum+scanner.nextInt(); //force to read only int
        }
        System.out.println("sum = " + sum);
    }

// exercise 3
    static void ex3_readAllFileByOnce() throws IOException {

        Path file = Paths.get("", "dane2.txt");

        String text = new String(Files.readAllBytes(file));
        System.out.println(text);
    }

// exercise 4
    static void ex4_readFileAndMovePointerToHashText() throws IOException{
        RandomAccessFile plik = new RandomAccessFile("napis.txt", "r"); //only "read" mode
        plik.seek(15464); // set pointer position to 15464 (from description of exercise)
        String tekst =  plik.readLine()+"\n";
        System.out.println(tekst);
    }

// exercise 5
    static void ex5_readFromURLSourceOfPage() throws IOException{
        URL url = new URL("https://www.wp.pl/"); //read source of URL
        Scanner scanner = new Scanner(url.openStream());

        while(scanner.hasNextLine()){ //until EOF
            String next = scanner.nextLine();
            if(next.indexOf("@") != -1) {
                System.out.println(next); //read line of URL which has @ in line
            }
        }
    }

// exercise 6
    static void ex6_readFromURLSourceOfPageAdvance() throws IOException{
        URL url = new URL("http://www.milocin.com.pl/karczma,kontakt.html"); //read source of URL
        Scanner scanner = new Scanner(url.openStream());


        while(scanner.hasNextLine()) { //until EOF
            String next = scanner.nextLine();

            if ((next.indexOf("@") != -1) && (next.indexOf("@media") == -1)){
                System.out.println(next); //read line of URL which has @ in line a
            }
        }
    }

// exercise 7
    static void ex7_readFromURLOnlyEmails() throws IOException{
        URL url = new URL("https://www.wp.pl/"); //read source of URL
        Scanner scanner = new Scanner(url.openStream());


        Pattern objectTypePattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");

        while(scanner.hasNextLine()) { //until EOF
            String next = scanner.nextLine();
            Matcher objectTypeMatcher = objectTypePattern.matcher(next);
            if (objectTypeMatcher.matches()) {
                System.out.println(next);
            } else {
                System.out.println("no result");
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //ex1_readStringFromFile();
        //ex2_readIntFromFileAndPrintSum();
        //ex3_readAllFileByOnce();
        //ex4_readFileAndMovePointerToHashText();
        //ex5_readFromURLSourceOfPage();
        //ex6_readFromURLSourceOfPageAdvance();
        ex7_readFromURLOnlyEmails();
    }
}
