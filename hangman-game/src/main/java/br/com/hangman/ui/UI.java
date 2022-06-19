package br.com.hangman.ui;

import java.util.Scanner;

import br.com.hangman.core.InvalidExceptions;

public class UI {

	public static void print(Object object) {
		System.out.println(object);
	}
	
	public static void printNewLine() {
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char readChar(String text) throws InvalidExceptions {
		System.out.println(text + " ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		if(line.trim().isEmpty()) {
			throw new InvalidExceptions("Nothing was typed.");
		} 
		
		if(line.length() > 1) {
			throw new InvalidExceptions("Please, just one letter.");
		}
		
		char c = line.charAt(0);
		
		if(!Character.isLetter(c)) {
			throw new InvalidExceptions("Please, just letters.");
		}
		
		return c;
	}
	
}
