package org.pneditor.petrinet.tests.imta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.imta.Place;

class TestPlaces {
	Place p1 = new Place(3);

	@Test
	void testPlace() {
		
		assertThrows(IllegalArgumentException.class,()->new Place(-2));
	}

	@Test
	void testGetTokens() {
		assertEquals(3, p1.getTokens());;
		assertDoesNotThrow(()->p1.getTokens());


	}

	@Test
	void testSetTokens() {
		p1.setTokens(7);
		assertEquals(7,p1.getTokens());
		assertThrows(IllegalArgumentException.class,()->p1.setTokens(-2));
	}

	@Test
	void testAddTokens() {
		p1.addTokens(1);
		assertEquals(4,p1.getTokens());
		assertThrows(IllegalArgumentException.class,()->p1.addTokens(-2));

	}

	@Test
	void testRemoveTokens() {
		p1.removeTokens(1);
		assertEquals(2,p1.getTokens());
		assertThrows(IllegalArgumentException.class,()->p1.removeTokens(10));
	}

}
