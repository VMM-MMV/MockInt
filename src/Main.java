package src;

import src.Utils.UserInput;

public class Main {
    public static void main(String[] args) {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        UserInput userInputClass = new UserInput();
        String userInput = userInputClass.getUserInput();
        statisticsCalculator.calculateStatistics(userInput);
    }
}

// Hello, my name is John. How is your day?