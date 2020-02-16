package hangman;

import java.util.Scanner;

public class GallowsUI {
    Gallows game = null;
    public GallowsUI() {
    }
    public void start() {
        System.out.println(
                "Welcome to Hangman!\n" +
                "Please enter a word or press Enter to randomly pick on");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.isEmpty()) {
            // Pressed ENTER
            System.out.println("Randomly picking a word.");
            this.game = new Gallows();
        }
        else {
            System.out.println("Using your selected word.");
            this.game = new Gallows(input);
        }

        if(this.game != null) {
            while(true) {
                this.printInformation();

                if(!this.game.isFinished()) {
                    this.game.guessLetter(scanner.next().charAt(0));
                } else {
                    System.out.println("Game over!");
                    break;
                }
            }

        }
    }
    public void printInformation() {
        System.out.println("Remaining mistakes: " + game.getRemainingGuesses() + "\n" +
        "Guessed letters: [" + game.getGuessedLetters() + "]\n" +
        "Word: " + game.getWordSoFar());
    }

}
