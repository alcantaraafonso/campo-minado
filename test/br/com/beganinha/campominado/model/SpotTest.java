package br.com.beganinha.campominado.model;


/**
 * O Java permite que se use o nível de restrição de acesso default 
 * se a classe de teste seguir a mesma nomenclatura de pacote da classe a ser testada
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.beganinha.campominado.model.Spot;

class SpotTest {
	
	private Spot field;

	/*
	 * Será executado antes de cada teste
	 */
	@BeforeEach
	void inicializeField() {
		field = new Spot(3, 3);
	}
	
	@Test
	void testNeighborDistancedByOneOnTheLeft() {
		Spot neighbor = new Spot(3, 2);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}

	
	@Test
	void testNeighborDistancedByOneOnTheRight() {
		Spot neighbor = new Spot(3, 4);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneAbove() {
		Spot neighbor = new Spot(2, 3);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneBelow() {
		Spot neighbor = new Spot(4, 3);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDiagonal() {
		Spot neighbor = new Spot(2, 2);
		boolean result = field.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNonNeighbor() {
		Spot neighbor = new Spot(1, 1);
		boolean result = field.addNeighbor(neighbor);
		
		assertFalse(result);
	}
}
