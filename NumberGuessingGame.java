import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRounds = 5;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxRounds + " rounds to play.");
        
        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ":");
            System.out.println("I have generated a number between 1 and 100.");
            
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += attemptsLeft; // Score based on attempts left
                } else if (userGuess < numberToGuess) {
                    attemptsLeft--;
                    System.out.println("Too low! Attempts left: " + attemptsLeft);
                } else {
                    attemptsLeft--;
                    System.out.println("Too high! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame over! Your final score is: " + score);
        scanner.close();
    }
}
