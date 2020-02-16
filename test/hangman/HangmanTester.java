package hangman;

public class HangmanTester {

	Gallows game = null;

	public void newGallows(String word) {
		this.game = new Gallows(word);
	}

	public String getWordSoFar() {
		this.game.getWordSoFar();
	}

	public void guessLetter(char c) {
		this.game.guessLetter(c);
	}

	public String getGuessedLetters() {
		this.game.getGuessedLetters();
	}
	
	public boolean isWordGuessed() {
		this.game.isFinished();
	}
}
