package model;

import java.util.Date;

public class Inscribed extends Viewer {
	private Inscribed beforeInscribed; 
	private Inscribed nextInscribed;

	public Inscribed(String id, String lastName, String email, String gender, String country, Date dateBorn) {
		super(id, lastName, email, gender, country, dateBorn);
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

}
