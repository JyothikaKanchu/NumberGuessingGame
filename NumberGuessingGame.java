import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Maximum number of attempts allowed
    static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100. Can you guess it?");
            
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (" + (MAX_ATTEMPTS - attempts) + " attempts left): ");
                int userGuess;

                // Validate input
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    score += 10; // Increase score on correct guess
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("🔼 Too low! Try a higher number.");
                } else {
                    System.out.println("🔽 Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😞 You've used all attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);

            // Ask if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing! Your final score: " + score);
        scanner.close();
    }
}
