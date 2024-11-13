package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classesPetriNet.*;
import classesPetriNet.Void;

class TestArc {
	Place p1 = new Place(2);
	Place p2 = new Place(0);
	Place p3 = new Place(5);
	Place p4 = new Place(1);
	Place p5 = new Place(3);
	Transition t = new Transition();
	InArc a1 = new InArc(1,p1,t);
	OutArc a2 = new OutArc(2,p2,t);
	InArc a0 = new Zero(p3, t);
	InArc av = new Void(p1, t);
	
	
	@Test
	void testArc() {
		assertDoesNotThrow(()->new InArc(1,p5,t));
		assertThrows(IllegalArgumentException.class, ()->new InArc(-1,p5,t));
	}

	@Test
	void testGetWeight() {
		assertEquals(2,a2.getWeight());
	}

	@Test
	void testSetWeight() {
		a1.setWeight(4);
		assertEquals(4,a1.getWeight());
		assertThrows(IllegalArgumentException.class, ()->a1.setWeight(-1));

	}

	@Test
	void testStep() {
		t.addInArc(a1);
		t.addOutArc(a2);
		t.addInArc(new Void(p2,t));
		t.addInArc(a0);
		fail("Not yet implemented");
	}

	@Test
	void testGetPlace() {
		assertEquals(p1,a1.getPlace());
	}

	@Test
	void testGetTransition() {
		assertEquals(t,a1.getTransition());
	}
	
	@Test
	void testEquals() {
		assertEquals(true,a1.equals(av));
	}
	
	@Test
	void testCanStep() {
		assertEquals(true,a1.canStep());
		assertEquals(true,av.canStep());
		assertEquals(false,a0.canStep());

	}

}
