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
		if(a.getId().compareTo(getId())==0) {
			left = a;
		}
		if(a.getId().compareTo(getId())>0) {
			if(right == null) {
				right = a;
			}
			else {
				right.add(a);
			}
		}
		if(a.getId().compareTo(getId())<0) {
			if(left == null) {
				left = a;
			}
			else {
				left.add(a);				
			}
		}
	}

	
	public Participant search(String id) {
		Participant retorno = null;
		if(id.compareTo(getId())==0) {
			retorno = this;
		}
		else {
			if(id.compareTo(getId())>0) {
				if(right != null) {
					retorno = right.search(id);
				}
			}
			if(id.compareTo(getId())<0) {
				if(left != null) {
					retorno = left.search(id);
				}
			}
		}
		return retorno;
	}
	
	public int weightTree() {
		int cant = 0;
		if(right !=null ) {
			cant += 1+right.weightTree();				
		}	
		if(left !=null) {
			cant += 1+left.weightTree();	
		}
		return cant;
	}
	
	public Participant searchCountry(String country) {
		Federation e = new Federation();
		if(country.compareToIgnoreCase(getCountry())==0) {
			e.addParticipant(this);
		}
		else {
			if(right != null) {
				e.addParticipant(right.searchCountry(country));
			}
			if(left !=null) {
				e.addParticipant(left.searchCountry(country));
			}
		}
		return e.getRaiz();
	}
	
	public String findCountry(String theCountry) {
		String msg = "";
		if(getCountry().compareTo(theCountry) == 0) {
			msg += toString()+"\n";
			msg += "|______";
			if(left != null && left.getCountry().equals(theCountry)) {
				msg += left.toString();
			}
			msg += "\n";
			if(right != null && right.getCountry().equals(theCountry)) {
				msg += right.toString();
			}
			msg += "\n";
		}
		if(left != null) {
			msg += left.findCountry(theCountry);
		}
		if(right != null) {
			msg += right.findCountry(theCountry);
		}
		return msg;
	}
	
	public String print() {
		String s = "";
		if(left!= null) {
			s+="|_______"+left.getId()+left.print();
		}
		
		if(right!= null) {
			s+="|_______"+right.getId()+right.print();
		}
		return s;
	}

}
