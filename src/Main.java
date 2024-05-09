package src;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String userInput = main.getUserInput();
        main.calculateStatistics(userInput);
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: \n");

        String text = scanner.nextLine();

        scanner.close();

        return text;
    }

    private void calculateStatistics(String text) {
        HashMap<String, Integer> wordsMap = new HashMap<>();
        HashMap<Character, Integer> vowelsMap = new HashMap<>();
        HashMap<Character, Integer> consonantsMap = new HashMap<>();
//        HashMap

        String[] splitText = text.split(" ");
        int wordCount = splitText.length;
        for (String word : splitText) {
            String cleanWord = "";
            for (Character character : word.toCharArray()) {
                if (!Character.isAlphabetic(character)) continue;

                cleanWord += Character.toLowerCase(character);
            }

            int mapWordCount = wordsMap.getOrDefault(cleanWord, 0);
            wordsMap.put(cleanWord, mapWordCount + 1);
        }

        System.out.println(wordsMap);
        System.out.println(wordCount);
    }
}


//Hello, my name is John. How is your day?