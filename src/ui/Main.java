package ui;

import java.io.IOException;
import java.text.ParseException;
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
		charge();
		int i = menu();
		option(i);
	}
	
	public void charge(){
		System.out.println("escriba el url de donde estan los archivos"+"\n"+"si no sabe que escribir escriba esta:"+"\n"+"./docs/espectadores.csv");
		String url = reader.next();
		try {
			relation.chargerWorld(url);
			System.out.println("se han cargado");
		} catch (IOException | ParseException e) {
			System.out.println("no se ha cargado");
		}
	}
	public int menu() {
		int option = 0;
		System.out.println("ingrese el numero de la opcion que deseda realizar");		
		System.out.println("1. buscar a un participante");		
		System.out.println("2. buscar a una persona inscrita");		
		System.out.println("3. ver participantes de un pais");		
		System.out.println("4. ver inscritos de un pais");		
		option = reader.nextInt();
		return option;
	}
	
	public void option(int i) {
		switch(i) {
		case 1:
			System.out.println("escriba el id del participante a buscar");
			String id = reader.next();
			System.out.println(relation.showFoundParticipant(id));
			break;
		case 2:
			System.out.println("escriba el id del inscrito");
			String id1 = reader.next();
			System.out.println(relation.showFoundInscribed(id1));
			break;
		case 3:
			System.out.println("escriba el pais");
			String country = reader.next();
			System.out.println(relation.printTree(country));
			break;
		case 4:	
			System.out.println("escriba el pais");
			String country1 = reader.next();
			System.out.println(relation.printList(country1));
			break;
		}
	}
	

}
