package src;

import src.Utils.UserInput;

public class Main {
    public static void main(String[] args) {
        CalculateStatistics main = new CalculateStatistics();
        UserInput userInputClass = new UserInput();
        String userInput = userInputClass.getUserInput();
        main.calculateStatistics(userInput);
    }


}

// Hello, my name is John. How is your day?