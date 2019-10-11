import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class FederationTest {

	@Test
	public void addParticipantTest() {
		Federation a = new Federation();
		Participant a1 = new Participant("347571333","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addParticipant(a1);
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
}
