package src.functionality;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StatisticsCalculator {
    private HashMap<String, Integer> wordsMap = new HashMap<>();
    private int wordCount = 0;
    private Map.Entry<Character, Integer> mostFrequentVowel;
    private Map.Entry<Character, Integer> mostFrequentConsonant;

    public void calculateStatistics(String text) {
        HashMap<Character, Integer> vowelsMap = new HashMap<>();
        HashMap<Character, Integer> consonantsMap = new HashMap<>();
        HashSet<Character> vowelCharacters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        String[] splitText = text.split(" ");
        wordCount = splitText.length;

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

        System.out.println("Word Frequency: " + wordsMap);
        System.out.println("Word Count: " + wordCount);

        mostFrequentVowel = getMaxEntry(vowelsMap);
        System.out.println("Most Frequent Vowel: " + mostFrequentVowel);

        mostFrequentConsonant = getMaxEntry(consonantsMap);
        System.out.println("Most Frequent Consonant: " + mostFrequentConsonant);
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

    private Map.Entry<Character, Integer> getMaxEntry(HashMap<Character, Integer> hashMap) {
        return hashMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
    }

    public HashMap<String, Integer> getWordsMap() {
        return wordsMap;
    }

    public int getWordCount() {
        return wordCount;
    }

    public Map.Entry<Character, Integer> getMostFrequentVowel() {
        return mostFrequentVowel;
    }

    public Map.Entry<Character, Integer> getMostFrequentConsonant() {
        return mostFrequentConsonant;
    }
}
