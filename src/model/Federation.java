package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Federation {
	
	private Participant raiz;
	private Inscribed first;
	
	public Federation() {
	}

	public Participant getRaiz() {
		return raiz;
	}

	public void setRaiz(Participant raiz) {
		this.raiz = raiz;
	}

	public Inscribed getFirst() {
		return first;
	}

	public void setFirst(Inscribed first) {
		this.first = first;
	}
	public boolean vacio() {
		return (raiz==null);
	}
	
	public void chargerWorld(String url) throws IOException, ParseException {
		String persona = "";
		File archive = new File(url);
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		String text;
		while((text = reader.readLine())!= null) {
			persona = text;
			String [] campos = persona.split(",");
			Participant a = new Participant(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], changeDate(campos[6]));
			addParticipant(a);
		}
		reader.close();
	}
	public Date changeDate(String date) throws ParseException {
		SimpleDateFormat change = new SimpleDateFormat("dd/mm/yyyy");
		Date fecha = change.parse(date);
		return fecha;
	}
	
	public void addParticipant(Participant a) {
		if(vacio() == true) {
			raiz = a;
		}
		else {
			raiz.add(a);
		}
	}

	public void searchParticipant(String id) {
	
		
	}
	
	public int weight() {
		if(vacio() == true) {
			return 0;
		}
		else {
			return raiz.weightTree();
		}
	}
	
	
}
