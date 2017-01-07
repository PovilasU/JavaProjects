package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) throws Exception // throws Exception is used to prevent more errors
    {
        //to write to file
        java.io.File file1 = new java.io.File("results.txt");
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file1);

        FileReader file = new FileReader("sonnet1-a.txt");
        BufferedReader reader = new BufferedReader(file);

        ArrayList<String> collectionEvenWords = new ArrayList<>();
        ArrayList<String> collectionOddWords = new ArrayList<>();
        int counterCharacter = 0;

        try {
            Scanner readFile = new Scanner(reader);

            while (readFile.hasNext())//keep reading until there is nothing exists
            {
                String currentWord = readFile.next();
                currentWord = currentWord.toUpperCase();
                counterCharacter = counterCharacter + currentWord.length();

                //Make collection of even words
                if (currentWord.length() % 2 == 0) {
                    collectionEvenWords.add(currentWord);

                } //Make collenction of odd words
                else {
                    collectionOddWords.add(currentWord);
                }

            }
            readFile.close(); //to prevent error messages if I want to use txt file(for examle move to another dir)

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("File analysed: sonnet1-a.txt");
        System.out.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterCharacter + " letters.");
        System.out.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");
        System.out.println();
        output.println("File analysed: sonnet1-a.txt");
        output.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterCharacter + " letters.");
        output.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");
        output.println();

        //remove dublicates
        Set<String> removeDuplicateEvenWords = new HashSet<>(collectionEvenWords);
        collectionEvenWords = new ArrayList<>(removeDuplicateEvenWords);

        Set<String> removeDuplicateOddWords = new HashSet<>(collectionOddWords);
        collectionOddWords = new ArrayList<>(removeDuplicateOddWords);

        Collections.sort(collectionEvenWords);
        Collections.sort(collectionOddWords);

        System.out.println("Collection of unique words with even number of letters: ");
        output.println("Collection of unique words with even number of letters: ");
        for (int i = 0; i < collectionEvenWords.size(); i++) {
            System.out.println(collectionEvenWords.get(i));
            output.println(collectionEvenWords.get(i));
        }

        System.out.println();
        System.out.println("Collection of unique words with odd number of letters: ");
        output.println();
        output.println("Collection of unique words with odd number of letters: ");
        for (int i = 0; i < collectionOddWords.size(); i++) {
            System.out.println(collectionOddWords.get(i));
            output.println(collectionOddWords.get(i));
        }
     
        //Close the file
        output.close();
    }

}
