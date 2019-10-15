package model;

import java.util.Date;

public class Inscribed extends Viewer {
	private Inscribed beforeInscribed; 
	private Inscribed nextInscribed;

	public Inscribed(String id, String name, String lastName, String email, String gender, String country, Date dateBorn) {
		super(id, name, lastName, email, gender, country, dateBorn);
	}
	
	public Inscribed getBeforeInscribed() {
		return beforeInscribed;
	}

	public void setBeforeInscribed(Inscribed beforeInscribed) {
		this.beforeInscribed = beforeInscribed;
	}

	public Inscribed getNextInscribed() {
		return nextInscribed;
	}

	public void setNextInscribed(Inscribed nextInscribed) {
		this.nextInscribed = nextInscribed;
	}
	
	public Inscribed search(String id) {
		Inscribed found = null;
		if(nextInscribed != null) {
			if(id.compareTo(nextInscribed.getId())== 0) {
				found = nextInscribed;
			}
			else {
				found = nextInscribed.search(id);
			}
		}
		return found;
	}

}
