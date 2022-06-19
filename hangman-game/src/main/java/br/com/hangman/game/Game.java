package br.com.hangman.game;

import java.util.HashSet;
import java.util.Set;

import br.com.hangman.core.Config;
import br.com.hangman.core.Dictionary;
import br.com.hangman.core.InvalidExceptions;
import br.com.hangman.core.Word;
import br.com.hangman.ui.UI;

public class Game {

	public void start() {

		UI.print("Welcome to the Hangman Game!");
		
		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();
		
		UI.print("The word has " + word.size() + " letters.");
		int errorCount = 0;

		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		
		UI.print("The number of the max errors is " + maxErrors + " times.");
		
		while(true) {
			UI.print(word);
			UI.printNewLine();
			
			char c;
			
			Set<Character> usedChars = new HashSet<>();
			
			try {
				c = UI.readChar("Type one letter: ");
				
				if(usedChars.contains(c)) {
					throw new InvalidExceptions("This letter is already used.");
				}
				
				usedChars.add(c);
				
				if(word.hasChar(c)) {
					UI.print("You found one letter!");
				} else {
					errorCount++;
					if(errorCount < maxErrors) {
						UI.print("You wrong the letter! You can wrong more " + (maxErrors - errorCount) + " time(s).");
					}
				}
				UI.printNewLine();
				
				if(word.victoryWord()) {
					UI.print("Congratulations! You foud the word: " + word.getOriginalWord());
					UI.print("End Game!");
					break;
				}
				
				if(errorCount == maxErrors) {
					UI.print("You Lost! The word was " + word.getOriginalWord());
					UI.print("End Game!");
					break;
				}
				
			}catch(InvalidExceptions e) {
				UI.print("Error: " + e.getMessage());
				UI.printNewLine();
			}
		}
	}

}
