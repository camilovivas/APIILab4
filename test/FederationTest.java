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
		Participant a1 = new Participant("347571333","Hester","Luciani","hluciani0@rediff.com","Female","Philippines", null);
		a.addParticipant(a1);
		int actual = a.weight();
		assertEquals(1, actual);
	}
}
