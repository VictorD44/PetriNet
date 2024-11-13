package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classesPetriNet.Arc;
import classesPetriNet.InArc;
import classesPetriNet.OutArc;
import classesPetriNet.PetriNet;
import classesPetriNet.Place;
import classesPetriNet.Transition;

class TestPetriNet {
	Place p1 = new Place(3);
	Place p2 = new Place(4);
	Transition t = new Transition();
	InArc a1 = new InArc(2,p1,t);
	OutArc a2 = new OutArc(3,p2,t);
	
	@Test
	void testPetriNet() {
		assertDoesNotThrow(()->new PetriNet());
	}

	@Test
	void testPetriNetArrayListOfArcArrayListOfPlaceArrayListOfTransition() {
		t.addInArc(a1);
		t.addOutArc(a2);
		ArrayList<Arc> arcs = new ArrayList<Arc>();
		arcs.add(a1);
		arcs.add(a2);
		ArrayList<Place> places = new ArrayList<Place>();
		places.add(p1);
		places.add(p2);
		ArrayList<Transition> transitions = new ArrayList<Transition>();
		transitions.add(t);
		assertDoesNotThrow(()->new PetriNet(arcs,places,transitions));
		InArc a3 = new InArc(2,p1,t);
		t.addInArc(a3);
		arcs.add(a3);
		assertThrows(IllegalArgumentException.class,()->new PetriNet(arcs,places,transitions));
		
		
	}

	@Test
	void testAddPlace() {
		Place p3 = new Place(7);
		PetriNet pn = new PetriNet();
		assertDoesNotThrow(()->pn.addPlace(p3));
		assertThrows(IllegalArgumentException.class,()->pn.addPlace(p3));
	}

	@Test
	void testAddArc() {
		Place p3 = new Place(7);
		InArc a3 = new InArc(4,p3,t);
		t.addInArc(a3);
		PetriNet pn = new PetriNet();
		assertDoesNotThrow(()->pn.addArc(a3));
		assertThrows(IllegalArgumentException.class,()->pn.addArc(a3));
		InArc a4 = new InArc(3,p3,t);
		t.addInArc(a4);
		assertThrows(IllegalArgumentException.class,()->pn.addArc(a4));
	}

	@Test
	void testAddTransition() {
		Transition t2 = new Transition();
		InArc a3 = new InArc(2,p2,t2);
		OutArc a4 = new OutArc(3,p1,t2);
		t2.addInArc(a3);
		t2.addOutArc(a4);
		PetriNet pn = new PetriNet();
		assertDoesNotThrow(()->pn.addTransition(t2));
		assertThrows(IllegalArgumentException.class,()->pn.addTransition(t2));
	}

	@Test
	void testRemovePlace() {
		Place p3 = new Place(3);
		PetriNet pn = new PetriNet();
		pn.addPlace(p3);
		assertDoesNotThrow(()->pn.removePlace(p3));
		assertThrows(IllegalArgumentException.class,()->pn.removePlace(p3));
	}

	@Test
	void testRemoveArc() {
		PetriNet pn = new PetriNet();
		pn.addArc(a1);
		assertDoesNotThrow(()->pn.removeArc(a1));
		assertThrows(IllegalArgumentException.class,()->pn.removeArc(a1));
	}

	@Test
	void testRemoveTransition() {
		PetriNet pn = new PetriNet();
		t.addInArc(a1);
		t.addOutArc(a2);
		pn.addTransition(t);
		assertDoesNotThrow(()->pn.removeTransition(t));
		assertThrows(IllegalArgumentException.class,()->pn.removeTransition(t));
	}

	@Test
	void testPull() {
		PetriNet pn = new PetriNet();
		assertThrows(IllegalArgumentException.class,()->pn.pull(t));
		t.addInArc(a1);
		t.addOutArc(a2);
		pn.addArc(a1);
		pn.addArc(a2);
		pn.addPlace(p1);
		pn.addPlace(p2);
		pn.addTransition(t);
		assertDoesNotThrow(()->pn.pull(t));
		assertEquals(1,p1.getTokens());
		assertEquals(7,p2.getTokens());
	}
	
	@Test
	void testMain() {
		assertDoesNotThrow(()->PetriNet.main(null));
	}

}
