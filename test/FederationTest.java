import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import model.*;

class FederationTest {

	@Test
	public void addParticipantTest() {
		Federation a = new Federation();
		Participant a1 = new Participant("347571333","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addParticipant(a1);
		int actual = a.weight();
		assertEquals(1, actual);
	}
	
	@Test
	public void weightTest() {
		Federation a = new Federation();
		Participant a1 = new Participant("2","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Participant a2 = new Participant("1","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Participant a3 = new Participant("3","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addParticipant(a1);
		a.addParticipant(a2);
		a.addParticipant(a3);
		int actual = a.weight();
		assertEquals(3, actual);
	}
	
	@Test
	public void searchParticipantTest() {
		Federation a = new Federation();
		Participant a1 = new Participant("2","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Participant a2 = new Participant("1","soyYo","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Participant a3 = new Participant("3","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addParticipant(a1);
		a.addParticipant(a2);
		a.addParticipant(a3);
		Participant actual = a.searchParticipant("1");
		assertEquals("soyYo", actual.getName());
	}
	@Test
	public void changeWorldTest() throws IOException, ParseException {
		Federation a = new Federation();
		a.chargerWorld("./docs/espectadores.csv");
		int actual = a.weight();
		assertEquals(100000, actual);
	}
	@Test
	public void changeWorld2Test() throws IOException, ParseException {
		Federation a = new Federation();
		a.chargerWorld("./docs/espectadores.csv");
		int actual = a.quantityInscribed();
		assertEquals(50000, actual);
	}
	
	@Test
	public void addInscribedTest() {
		Federation a = new Federation(); 
		Inscribed a1 = new Inscribed("2","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Inscribed a2 = new Inscribed("1","soyYo","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Inscribed a3 = new Inscribed("3","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addInscribed(a1);
		a.addInscribed(a2);
		a.addInscribed(a3);
		int actual = a.quantityInscribed();
		assertEquals(3, actual);
	}
	
	@Test
	public void quantityInscribedTest() {
		Federation a = new Federation(); 
		Inscribed a1 = new Inscribed("2","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Inscribed a2 = new Inscribed("1","soyYo","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		Inscribed a3 = new Inscribed("3","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addInscribed(a1);
		a.addInscribed(a2);
		a.addInscribed(a3);
		int actual = a.quantityInscribed();
		assertEquals(3, actual);
	}
	
}
