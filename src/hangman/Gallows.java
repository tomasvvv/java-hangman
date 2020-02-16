package hangman;

public class Gallows {
    private StringBuilder guessed = new StringBuilder();
    private String word = new String();
    private int remainingGuesses;

    // Constructors
    public Gallows() {
        WordReader file = new WordReader("words.txt");
        this.word = file.getWord();
        this.remainingGuesses = 10;
    }
    public Gallows(String word) {
        this.word = word;
        this.remainingGuesses = 10;
    }

    // Getters
    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }
    public String getGuessedLetters() {
        return this.guessed.toString();
    }
    public String getWordSoFar() {
        StringBuilder encoded = new StringBuilder();
        for(int i = 0; i < word.length(); i++) { // Loop through our word
            int index_in_guessed = guessed.toString().indexOf( word.charAt(i) );
            if(index_in_guessed != -1) { // If 'guessed' contains char
                encoded.append(guessed.charAt(index_in_guessed));
            }
            else {
                encoded.append(".");
            }
        }
        return encoded.toString();
    }

    public boolean isFinished() {
        if(getWordSoFar().indexOf(".") == -1 || this.remainingGuesses <= 0) return true;
        return false;
    }

    // Functions for input
    public void guessLetter(char letter) {
        // If char is already guessed, do nothing
        if(this.guessed.toString().indexOf(letter) != -1) return;

        // Search for guessed char in our word
        if(this.word.indexOf(letter) != -1) {
            // This letter is indeed in the word.
        } else {
            this.remainingGuesses -= 1;
        }
        this.guessed.append(letter);
    }

}
