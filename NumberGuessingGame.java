import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rdm = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        System.out.println("\uD83C\uDFAE Welcome to the Guess the Number Game!");

        while (playAgain) {
            int targetNumber = rdm.nextInt(100) + 1;
            int maxAttempts = 10;  //the maximum attempts available
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n ➤ Round " + round);
            System.out.println("✔ let's think of a number between 1 and 100...");
            System.out.println("✔ You have " + maxAttempts + " attempts to guess it! ");

            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess == targetNumber) {
                    System.out.println( "✅ Correct! You've guessed the number in " + attemptsUsed + " attempts.");
                    int score = (maxAttempts - attemptsUsed + 1) * 10;
                    totalScore += score;
                    System.out.println("You earned " + score + " points this round.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("❌ Your guess is lower than the random number! Try again.");
                } else {
                    System.out.println("❌ Your guess is higher than the random number! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" Out of attempts! The number was: " + targetNumber);
            }

            System.out.println("Total Score: " + totalScore);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String reply = scanner.next();
            playAgain = reply.equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("\n \uD83D\uDE80Game Over! Your final score was: " + totalScore);
        scanner.close();
    }
}
