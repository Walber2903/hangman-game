package br.com.hangman.game;

import br.com.hangman.core.Dictionary;
import br.com.hangman.core.Word;

public class Game {

	public void start() {

		Dictionary dic = Dictionary.getInstance();
		Word w1 = dic.nextWord();
		System.out.println(w1.getOriginalWord());
	}

}
