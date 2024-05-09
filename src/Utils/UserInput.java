package src.Utils;

import java.util.Scanner;

public class UserInput {
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: \n");

        String text = scanner.nextLine();

        scanner.close();

        return text;
    }
}
