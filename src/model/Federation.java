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
		int contador = 0;
		File archive = new File(url);
		BufferedReader reader = new BufferedReader(new FileReader(archive));
		String text;
		while((text = reader.readLine())!= null) {
			persona = text;
			String [] campos = persona.split(",");
			Participant a = new Participant(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], changeDate(campos[6]));
			addParticipant(a);
			if(contador <= 49999) {
				Inscribed e = new Inscribed(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], changeDate(campos[6]));
				addInscribed(e);
				contador++;
			}
		}
		reader.close();
	}
	

	public void addInscribed(Inscribed a) {
		boolean ya = false;
		Inscribed next = first;
		if(first == null) {
			first = a;
		}
		else {
			while(!ya) {
				if(next.getNextInscribed() == null) {
					next.setNextInscribed(a);
					a.setBeforeInscribed(next);
					ya = true;
				}
				else {
					next = next.getNextInscribed();
				}
			}
		}
	}
	
	public int quantityInscribed() {
		int contador = 0;
		Inscribed next = first; 
		while(next != null) {
			contador++;
			next = next.getNextInscribed();
		}
		return contador;
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

	public Participant searchParticipant(String id) {
		Participant found = null;
		if(!vacio()) {
			if(id.compareTo(raiz.getId())==0) {
				found = raiz;
			}
			else {
				found = raiz.search(id);
			}
		}
		return found;
	}
	
	public Inscribed searchInscribed(String id) {
		Inscribed found = null;
		if(first != null) {
			if(first.getId().compareTo(id)== 0) {
				found = first;
			}
			else {
				found = first.search(id);
			}
		}
		
		return found;
	}
	
	public String showFoundParticipant(String id) {
		Participant found  = searchParticipant(id);
		String retorno = "";
		if(found != null) {
			retorno += found.getName()+"\n";
			retorno += found.getLastName()+"\n";
			retorno += found.getEmail()+"\n";
			retorno += found.getGender()+"\n";
			retorno += found.getCountry()+"\n";
			retorno += found.getDateBorn().toString();
		}
		else {
			retorno += "no se encontro";
		}
		return retorno;
	}
	
	public String showFoundInscribed(String id) {
		Inscribed found = searchInscribed(id);
		String retorno = "";
		if(found != null) {
			retorno += found.getName()+"\n";
			retorno += found.getLastName()+"\n";
			retorno += found.getEmail()+"\n";
			retorno += found.getGender()+"\n";
			retorno += found.getCountry()+"\n";
			retorno += found.getDateBorn().toString();
		}
		else {
			retorno += "no se encontro";
		}
		return retorno;
	}
	
	public int weight() {
		if(vacio() == true) {
			return 0;
		}
		else {
			return 1+raiz.weightTree();
		}
	}
	
	public Participant treeParticipantCountry(String country) {
		Federation e = new Federation();
		if(raiz.getCountry().compareToIgnoreCase(country)==0) {
			e.addParticipant(raiz);
		}
		else {
			e.addParticipant(raiz.searchCountry(country));
		}
		
		return e.getRaiz();
	}
	
	public Inscribed listInsccribedCountry(String country) {
		Federation e = new Federation();
		Inscribed next = first;
		Inscribed temp = null;
		while(next!=null) {
			if(next.getCountry().compareTo(country)==0) {
				temp = next;
				next = next.getNextInscribed();
				temp.setNextInscribed(null);
				e.addInscribed(temp);
				}
			else {
				next =  next.getNextInscribed();
			}
		}
		return e.getFirst();
	}
	
	public String printTree(String country) {
		String tree = "";
		Participant e =  treeParticipantCountry(country);
		if(e != null) {
			tree += e.getId();
			tree += e.print();
		}
		
		return tree;
	}
	
	public String printList(String country) {
		String s = "";
		Inscribed a = listInsccribedCountry(country);
		s+= a.getId()+a.print();
		return s;
	}
	
}
