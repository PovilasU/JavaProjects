package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Task3 {

    public static void main(String[] args) throws Exception {
        //to write to file
        java.io.File file1 = new java.io.File("results.txt");

        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file1);

        FileReader file = new FileReader("sonnet3.txt");
        //FileReader file = new FileReader("test.txt");
        BufferedReader reader = new BufferedReader(file);
        //remove dublicates

        ArrayList<String> collectionEvenWords = new ArrayList<>();
        ArrayList<String> collectionOddWords = new ArrayList<>();
        ArrayList<String> collectionOfWords = new ArrayList<>();
        ArrayList<String> WordsFreq = new ArrayList<>();
        ArrayList<String> WordsFreqGreaterThanFour = new ArrayList<>();

        int counterCharacter = 0;
        int counterWord = 0;
        int counterWord1 = 0;
        int counterLines = 0;
        int counterEvenWords = 0;
        int counterOddWords = 0;
        int counterEvenWordsNoPunctiations = 0;
        int counterOddWordsNoPunctiations = 0;
        int counterPunctuations = 0;
        int counterPunctuation = 0;

        //inputs
        String evenWord = "\r\n";
        String oddWord = "\r\n";
        String[] evenWords = new String[1000];
        String[] oddWords = new String[1000];
        String stringOfWords = "";
        //String strippedInput = stringOfWords.replaceAll("\\W", "");

        try {
            Scanner readFile = new Scanner(reader);

            while (readFile.hasNext())//keep reading until there is nothing exists
            {

                String currentWord = readFile.next();
                currentWord = currentWord.replaceAll("[\\s.?,:!();&=<>/]", "").toUpperCase();

                if (currentWord.contains("\'")) {
                    if (currentWord.length() % 2 == 0) {
                        collectionOddWords.add(currentWord);
                        counterCharacter = counterCharacter + currentWord.length() - 1;
                    } else {
                        collectionEvenWords.add(currentWord);
                        counterCharacter = counterCharacter + currentWord.length() - 1;
                    }
                }

                if (!currentWord.contains("\'")) {
                    if (currentWord.length() % 2 == 0) {

                        collectionEvenWords.add(currentWord);
                        counterCharacter = counterCharacter + currentWord.length();

                    } //Count Odd words
                    else {
                        collectionOddWords.add(currentWord);
                        counterCharacter = counterCharacter + currentWord.length();
                    }
                }
                collectionOfWords.add(currentWord);

            }
            readFile.close(); //to prevent error messages if I want to use txt file(for examle move to another dir)

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("File analysed: sonnet3.txt");
        System.out.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterCharacter + " letters.");
        System.out.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");

        output.println("File analysed: sonnet3.txt");
        output.println("There were " + (collectionEvenWords.size() + collectionOddWords.size()) + " words and " + counterCharacter + " letters.");
        output.println("There were " + collectionEvenWords.size() + " even words, " + "and " + collectionOddWords.size() + " odd words.");

        Set<String> uniqueWords = new HashSet<String>(collectionOfWords);

        for (String word : uniqueWords) {
            if (Collections.frequency(collectionOfWords, word) >= 4) {
                WordsFreqGreaterThanFour.add(word);
            }
            WordsFreq.add(word + " " + Collections.frequency(collectionOfWords, word));
        }

        Collections.sort(WordsFreq);
        System.out.println();
        System.out.println("Collection of unique words frequency: ");
        output.println();
        output.println("Collection of unique words frequency");
        for (int i = 0; i < WordsFreq.size(); i++) {
            System.out.println(WordsFreq.get(i));
            output.println(WordsFreq.get(i));
        }
        
                Collections.sort(WordsFreqGreaterThanFour);
        System.out.println();
        System.out.println("Collection of unique words with a frequency 4 or greater: ");
        output.println();
        output.println("Collection of unique words with a frequency 4 or greater: ");
        for (int i = 0; i < WordsFreqGreaterThanFour.size(); i++) {
            System.out.println(WordsFreqGreaterThanFour.get(i));
            output.println(WordsFreqGreaterThanFour.get(i));
        }

        //Close the file
        output.close();

    }

}
