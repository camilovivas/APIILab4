package model;

import java.util.Date;

public class Participant extends Viewer {
	private Participant right;
	private Participant left;

	public Participant(String id, String name, String lastName, String email, String gender, String country, Date dateBorn) {
		super(id, name, lastName, email, gender, country, dateBorn);
	}

	public Participant getRight() {
		return right;
	}

	public void setRight(Participant right) {
		this.right = right;
	}

	public Participant getLeft() {
		return left;
	}

	public void setLeft(Participant left) {
		this.left = left;
	}

	public void add(Participant a) {
		if(a.getId().compareTo(getId())<0) {
			right.add(a);
		}
		if(a.getId().compareTo(getId())>0) {
			left.add(a);
		}
	}
	

}
