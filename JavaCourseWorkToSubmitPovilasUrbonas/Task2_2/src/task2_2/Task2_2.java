package task2_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2_2 {

    public static void main(String[] args) throws Exception // throws Exception is used to prevent more errors
    {

        java.io.File file1 = new java.io.File("results.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(file1);

        FileReader file = new FileReader("sonnet2.txt");
        BufferedReader reader = new BufferedReader(file);
        ArrayList<String> collectionOfWords = new ArrayList<>();
        ArrayList<String> collectionEvenWords = new ArrayList<>();
        ArrayList<String> collectionOddWords = new ArrayList<>();
        int counterDash = 0;
        int counterCharacters = 0;
        int counterChar = 0;

        try {
            Scanner readFile = new Scanner(reader);

            while (readFile.hasNext())//keep reading until there is nothing exists
            {

                String currentWord = readFile.next();
                currentWord = currentWord.toUpperCase();
                currentWord = currentWord.replaceAll("[?,:.()!;]", "");

                if (currentWord.contains("-")) {
                    String[] splitword = currentWord.split("-");
                    for (int i = 0; i < splitword.length; i++) {

                        if (splitword[i].length() % 2 == 0) {
                            collectionEvenWords.add(splitword[i]);
                            counterChar = counterChar + splitword[i].length();
                        } else {
                            collectionOddWords.add(splitword[i]);
                            counterChar = counterChar + splitword[i].length();
                        }

                    }

                } else {
                    collectionOfWords.add(currentWord);
                }

                if (!currentWord.contains("-")) {
                    if (currentWord.length() % 2 == 0) {
                        collectionEvenWords.add(currentWord);
                        counterChar = counterChar + currentWord.length();
                    } else {
                        collectionOddWords.add(currentWord);
                        counterChar = counterChar + currentWord.length();
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("File analysed: sonnet2.txt");
        System.out.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterChar + " letters.");
        System.out.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");

        output.println("File analysed: sonnet2.txt");
        output.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterChar + " letters.");
        output.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");

        //remove duplicates
        Set<String> removeDuplicateEvenWords = new HashSet<>(collectionEvenWords);
        collectionEvenWords = new ArrayList<>(removeDuplicateEvenWords);

        Set<String> removeDuplicateOddWords = new HashSet<>(collectionOddWords);
        collectionOddWords = new ArrayList<>(removeDuplicateOddWords);

        Collections.sort(collectionEvenWords);
        Collections.sort(collectionOddWords);
        
        System.out.println();
        System.out.println("Collection of unique words with even number of letters: ");
        output.println();
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

        output.close();

    }

}
