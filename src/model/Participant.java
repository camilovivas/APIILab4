package model;

import java.util.Date;

public class Participant extends Viewer {
	private Participant beforeParticipant;
	private Participant nextParticipant;

	public Participant(String id, String name, String lastName, String email, String gender, String country, Date dateBorn) {
		super(id, name, lastName, email, gender, country, dateBorn);
	}

	public Participant getBeforeParticipant() {
		return beforeParticipant;
	}

	public void setBeforeParticipant(Participant beforeParticipant) {
		this.beforeParticipant = beforeParticipant;
	}

	public Participant getNextParticipant() {
		return nextParticipant;
	}

	public void setNextParticipant(Participant nextParticipant) {
		this.nextParticipant = nextParticipant;
	}
	
	

}
