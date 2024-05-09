package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CalculateStatistics {
    HashMap<String, Integer> wordsMap = new HashMap<>();
    HashMap<Character, Integer> vowelsMap = new HashMap<>();
    HashMap<Character, Integer> consonantsMap = new HashMap<>();
    int wordCount = 0;

    public void calculateStatistics(String text) {
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

        Map.Entry<Character, Integer> maxVowelEntry = getMaxEntry(vowelsMap);
        System.out.println("Vowel Biggest Frequency: " + maxVowelEntry);

        Map.Entry<Character, Integer> maxConsonantEntry = getMaxEntry(consonantsMap);
        System.out.println("Consonant Biggest Frequency: " + maxConsonantEntry);
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

    public HashMap<Character, Integer> getVowelsMap() {
        return vowelsMap;
    }

    public HashMap<Character, Integer> getConsonantsMap() {
        return consonantsMap;
    }

    public int getWordCount() {
        return wordCount;
    }
}
