package br.com.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.hangman.core.Utils.RandomUtils;
import br.com.hangman.game.GameException;

public class Dictionary {

	private static final String FILE_NAME = "dictionary.txt";
	
	private static Dictionary instance;
	
	private List<String> words = new ArrayList<>();
	
	private Dictionary() {
		load();
	}
	
	public static Dictionary getInstance() {
		if(instance == null) {
			instance = new Dictionary();
		}
		return instance;
	}
	
	private void load() {
		try(Scanner sc = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			while(sc.hasNextLine()) {
				String word = sc.nextLine().trim();
				words.add(word);
			}
			if(words.size() == 0) {
				throw new GameException("Word list can not be empty.");
			}
		}
				
	}
	
	public Word nextWord() {
		int position = RandomUtils.newRandomNumber(0, words.size());
		
		return new Word(words.get(position));
	}
	
	
}
