package br.com.hangman.core;

import java.util.HashSet;
import java.util.Set;

public class Word {
	
	private static final char SECRET_CHAR = '_';
	
	private String originalWord;
	
	private Set<Character> foundChars = new HashSet<>();
	
	private Set<Character> charsUniques = new HashSet<>();
	
	public Word(String originalWord) {
		this.originalWord = originalWord.toUpperCase();
		
		char[] chars = this.originalWord.toCharArray();
		for(char c : chars) {
			charsUniques.add(c);
		}
	}

	public String getOriginalWord() {
		return originalWord;
	}
	
	public int size() {
		return originalWord.length();
	}
	
	public boolean hasChar(char character) {
		character = Character.toUpperCase(character);
		int position = originalWord.indexOf(character);
		if(position > -1) {
			foundChars.add(character);
			return true;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		char[] charArray = originalWord.toCharArray();
		
		for(int i = 0; i<charArray.length; i++) {
			char c = charArray[i];
			if(foundChars.contains(c)) {
				sb.append(c);
			} else {
				sb.append(SECRET_CHAR);
			}
			
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public boolean victoryWord() {
		return foundChars.equals(charsUniques);
	}
	
}
