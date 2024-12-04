package org.pneditor.petrinet.tests.imta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.imta.*;

class TestTransition {

	@Test
	void testTransition() {
		assertDoesNotThrow(()->new Transition());
	}

	@Test
	void testAddInArc() {
		Transition t = new Transition();
		Place p = new Place(3);
		InArc a = new InArc(4,p,t);
		assertDoesNotThrow(()->t.addInArc(a));
		Transition t2 = new Transition();
		InArc a2 = new InArc(4,p,t2);
		assertThrows(IllegalArgumentException.class,()->t.addInArc(a2));
		
	}

	@Test
	void testAddOutArc() {
		Transition t = new Transition();
		Place p = new Place(3);
		OutArc a = new OutArc(4,p,t);
		assertDoesNotThrow(()->t.addOutArc(a));
		Transition t2 = new Transition();
		OutArc a2 = new OutArc(4,p,t2);
		assertThrows(IllegalArgumentException.class,()->t.addOutArc(a2));
	}

	@Test
	void testStep() {
		Transition t = new Transition();
		Place p11 = new Place(2);
		Place p12 = new Place(3);
		Place p21 = new Place(4);
		Place p22 = new Place(0);
		InArc a11 = new InArc(2,p11,t);
		InArc a12 = new InArc(1,p12,t);
		OutArc a21 = new OutArc(3,p21,t);
		OutArc a22 = new OutArc(2,p22,t);
		t.addInArc(a11);
		t.addInArc(a12);
		t.addOutArc(a21);
		t.addOutArc(a22);
		t.step();
		assertEquals(0,p11.getTokens());
		assertEquals(2,p12.getTokens());
		assertEquals(7,p21.getTokens());
		assertEquals(2,p22.getTokens());
		t.step();
		assertEquals(0,p11.getTokens());
		assertEquals(2,p12.getTokens());
		assertEquals(7,p21.getTokens());
		assertEquals(2,p22.getTokens());
	}

}
