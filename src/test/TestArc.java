package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classesPetriNet.*;

class TestArc {
	Place p1 = new Place(2);
	Place p2 = new Place(0);
	Transition t = new Transition();
	Arc a1 = new InArc(1,p1,t);
	Arc a2 = new OutArc(2,p2,t);
	
	
	@Test
	void testArc() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWeight() {
		fail("Not yet implemented");
	}

	@Test
	void testSetWeight() {
		fail("Not yet implemented");
	}

	@Test
	void testStep() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlace() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTransition() {
		fail("Not yet implemented");
	}

}
