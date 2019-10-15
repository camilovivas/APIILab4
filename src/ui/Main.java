package ui;

import java.util.Scanner;

import model.*;

public class Main {
	private Scanner reader;
	private Federation relation;

	public static void main(String[] args) {
		Main m = new Main();
	}
	
	public Main() {
		reader = new Scanner(System.in);
		relation = new Federation();
		int i = menu();
		option(i);
	}
	
	public int menu() {
		int option = 0;
		System.out.println("");		
		System.out.println("");		
		System.out.println("");		
		System.out.println("");		
		
		return option;
	}
	
	public void option(int i) {
		switch(i) {
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:	
		}
	}
	

}
