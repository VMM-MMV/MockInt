package src.tests;

import org.junit.jupiter.api.Test;
import src.functionality.StatisticsCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testWordFrequency() {
        final HashMap<String, Integer> EXPECTED_WORDS_MAP = new HashMap<>(Map.of("how", 1, "name", 1, "is", 2, "john", 1, "hello", 1, "your", 1, "my", 1, "day", 1));

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String text = "Hello, my name is John. How is your day?";
        statisticsCalculator.calculateStatistics(text);
        HashMap<String, Integer> wordsMap = statisticsCalculator.getWordsMap();

        assertEquals(wordsMap, EXPECTED_WORDS_MAP);
    }

    @Test
    public void testWordCount() {
        final int EXPECTED_WORD_COUNT = 6;

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String text = "Hello, world! It's a great day.";
        statisticsCalculator.calculateStatistics(text);
        int wordCount = statisticsCalculator.getWordCount();

        assertEquals(wordCount, EXPECTED_WORD_COUNT);
    }

    @Test
    public void testFindMostFrequentVowel() {
        final Character EXPECTED_VOWEL = 'o';
        final Integer EXPECTED_FREQUENCY = 4;

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String text = "Hello, my name is John. How is your day?";
        statisticsCalculator.calculateStatistics(text);
        Map.Entry<Character, Integer> mostFrequentVowel = statisticsCalculator.getMostFrequentVowel();

        assertTrue(mostFrequentVowel.getKey() == EXPECTED_VOWEL && Objects.equals(mostFrequentVowel.getValue(), EXPECTED_FREQUENCY));
    }

    @Test
    public void testFindMostFrequentConsonant() {
        final Character EXPECTED_CONSONANT = 'h';
        final Integer EXPECTED_FREQUENCY = 3;

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        String text = "Hello, my name is John. How is your day?";
        statisticsCalculator.calculateStatistics(text);
        Map.Entry<Character, Integer> mostFrequentVowel = statisticsCalculator.getMostFrequentConsonant();

        assertTrue(mostFrequentVowel.getKey() == EXPECTED_CONSONANT && Objects.equals(mostFrequentVowel.getValue(), EXPECTED_FREQUENCY));
    }
}