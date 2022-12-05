package br.com.beganinha.cm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.beganinha.campominado.model.Field;

class FieldTest {
	
	private Field field;

	/*
	 * Será executado antes de cada teste
	 */
	@BeforeEach
	void inicializeField() {
		field = new Field(3, 3);
	}
	
	@Test
	void testNeighborDistancedByOneOnTheLeft() {
		Field neighbor = new Field(3, 2);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}

	
	@Test
	void testNeighborDistancedByOneOnTheRight() {
		Field neighbor = new Field(3, 4);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneAbove() {
		Field neighbor = new Field(2, 3);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneBelow() {
		Field neighbor = new Field(4, 3);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDiagonal() {
		Field neighbor = new Field(2, 2);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNonNeighbor() {
		Field neighbor = new Field(1, 1);
		boolean result = field.addNeighbor(neighbor);
		
		assertFalse(result);
	}
}
