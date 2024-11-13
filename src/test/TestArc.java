package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import classesPetriNet.*;
import classesPetriNet.Void;

class TestArc {

	@Test
	void testArc() {
		Place p = new Place(2);
		Transition t = new Transition();
		assertDoesNotThrow(()->new InArc(1,p,t));
		assertDoesNotThrow(()->new OutArc(1,p,t));
		assertThrows(IllegalArgumentException.class, ()->new InArc(-1,p,t));
		assertThrows(IllegalArgumentException.class, ()->new OutArc(-1,p,t));

	}

	@Test
	void testGetWeight() {
		Place p = new Place(2);
		Transition t = new Transition();
		Arc a = new InArc(1,p,t);
		assertEquals(1,a.getWeight());
	}

	@Test
	void testSetWeight() {
		Place p = new Place(2);
		Transition t = new Transition();
		Arc a = new InArc(1,p,t);
		a.setWeight(4);
		assertEquals(4,a.getWeight());
		assertThrows(IllegalArgumentException.class, ()->a.setWeight(-1));

	}

	@Test
	void testStep() {
		Place p1 = new Place(3);
		Place p2 = new Place(0);
		Place p3 = new Place(5);
		Place p4 = new Place(0);
		Place p5 = new Place(1);
		Transition t = new Transition();
		InArc a1 = new InArc(1,p1,t);
		InArc a0 = new Zero(p2, t);
		InArc av = new Void(p3, t);
		OutArc a2 = new OutArc(2,p4,t);
		InArc a3 = new InArc(2,p5,t);
		
		assertEquals(false,(new InArc(10,p1,t).canStep()));
		assertEquals(false,(new Zero(p1,t).canStep()));
		assertEquals(true,(new Void(p1,t).canStep()));

		a1.step();
		a0.step();
		av.step();
		a2.step();
		a3.step();
		
		assertEquals(2,p1.getTokens());
		assertEquals(0,p2.getTokens());
		assertEquals(0,p3.getTokens());
		assertEquals(2,p4.getTokens());
		assertEquals(1,p5.getTokens());
	}

	@Test
	void testGetPlace() {
		Place p = new Place(2);
		Transition t = new Transition();
		Arc a = new InArc(1,p,t);
		assertEquals(p,a.getPlace());
	}

	@Test
	void testGetTransition() {
		Place p = new Place(2);
		Transition t = new Transition();
		Arc a = new InArc(1,p,t);
		assertEquals(t,a.getTransition());
	}
	
	@Test
	void testEquals() {
		Place p = new Place(2);
		Transition t = new Transition();
		Arc a1 = new InArc(1,p,t);
		Arc a2 = new Void(p,t);
		Arc a3 = new OutArc(1,p,t);
		Arc a4 = new OutArc(1,p,t);
		assertEquals(true,a1.equals(a2));
		assertEquals(true,a3.equals(a4));
		assertEquals(false,a1.equals(a3));
	}
	
	@Test
	void testCanStep() {
		Place p = new Place(2);
		Place p2 = new Place(0);
		Transition t = new Transition();
		InArc a1 = new InArc(3,p,t);
		InArc av = new Void(p,t);
		InArc a0 = new Zero(p,t);
		InArc a4 = new InArc(2,p,t);
		assertEquals(false,a1.canStep());
		assertEquals(true,av.canStep());
		assertEquals(false,(new Void(p2,t)).canStep());
		assertEquals(false,a0.canStep());
		assertEquals(true,(new Zero(p2,t)).canStep());
		assertEquals(true,a4.canStep());


	}

}
