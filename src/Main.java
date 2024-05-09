package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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
        HashSet<Character> vowelCharacters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        String[] splitText = text.split(" ");
        int wordCount = splitText.length;
        for (String word : splitText) {
            String cleanWord = "";
            for (Character character : word.toCharArray()) {
                if (!Character.isAlphabetic(character)) continue;

                cleanWord += Character.toLowerCase(character);

                if (vowelCharacters.contains(character)) {
                    updateHashMap(vowelsMap, character);
                } else {
                    updateHashMap(consonantsMap, character);
                }
            }

            updateHashMap(wordsMap, cleanWord);
        }

        System.out.println(wordsMap);
        System.out.println(wordCount);
        System.out.println(vowelsMap);
        System.out.println(consonantsMap);
    }

    private void updateHashMap(HashMap<String, Integer> hashMap, String word) {
        word = word.toLowerCase();
        int mapWordCount = hashMap.getOrDefault(word, 0);
        hashMap.put(word, mapWordCount + 1);
    }

    private void updateHashMap(HashMap<Character, Integer> hashMap, Character character) {
        character = Character.toLowerCase(character);
        int mapCharacterCount = hashMap.getOrDefault(character, 0);
        hashMap.put(character, mapCharacterCount + 1);
    }
}


//Hello, my name is John. How is your day?