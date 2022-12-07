package br.com.beganinha.campominado.model;


/**
 * O Java permite que se use o nível de restrição de acesso default 
 * se a classe de teste seguir a mesma nomenclatura de pacote da classe a ser testada
 * 
 * Testes de cobertura:
 * Os testes de cobertura nos dizem o quanto de código-fonte foi coberto por testes unitários
 * para execuá-los, utilize o botão ao lado do botão Run. Este botão chama-se Launch
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.beganinha.campominado.exception.ExplosionException;



class SpotTest {
	
	private Spot spot;

	/*
	 * Será executado antes de cada teste
	 */
	@BeforeEach
	void inicializeField() {
		spot = new Spot(3, 3);
	}
	
	@Test
	void testNeighborDistancedByOneOnTheLeft() {
		Spot neighbor = new Spot(3, 2);
		boolean result = spot.addNeighbor(neighbor);
		
		assertTrue(result);
	}

	
	@Test
	void testNeighborDistancedByOneOnTheRight() {
		Spot neighbor = new Spot(3, 4);
		boolean result = spot.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneAbove() {
		Spot neighbor = new Spot(2, 3);
		boolean result = spot.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDistancedByOneBelow() {
		Spot neighbor = new Spot(4, 3);
		boolean result = spot.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNeighborDiagonal() {
		Spot neighbor = new Spot(2, 2);
		boolean result = spot.addNeighbor(neighbor);
		
		assertTrue(result);
	}
	
	@Test
	void testNonNeighbor() {
		Spot neighbor = new Spot(1, 1);
		boolean result = spot.addNeighbor(neighbor);
		
		assertFalse(result);
	}
	
	@Test
	void testIsMarkInitialValue() {
		assertFalse(spot.isMarked());
	}
	
	@Test
	void testSwitchSpotMark() {
		spot.switchSpotMark();
		assertTrue(spot.isMarked());
	}
	
	
	@Test
	void testSwitchSpotMarkCalledTwice() {
		spot.switchSpotMark();
		spot.switchSpotMark();
		assertFalse(spot.isMarked());
	}
	
	@Test
	void testOpenNotMinedAndNotMakedSpot() {
		assertTrue(spot.openSpot());
	}
	
	@Test
	void testOpenNotMinedAndMakedSpot() {
		spot.switchSpotMark();
		assertFalse(spot.openSpot());
	}
	
	@Test
	void testOpenMinedAndMakedSpot() {
		spot.switchSpotMark();
		spot.mineTheSpot();
		assertFalse(spot.openSpot());
	}
	
	@Test
	void testOpenMinedAndNotMakedSpot() {
		spot.mineTheSpot();
		assertThrows(ExplosionException.class, () -> {
			spot.openSpot();
		});
	}
	
	@Test
	void testOpenSpotWithNeighbors() {
		Spot neighbor11 = new Spot(1, 1);
		Spot neighbor22 = new Spot(2, 2);
		
		neighbor22.addNeighbor(neighbor11);
		spot.addNeighbor(neighbor22);
		
		spot.openSpot();
		
		assertTrue(neighbor22.isOpended() && neighbor11.isOpended());
	}
	
	@Test
	void testOpenSpotWithNeighbors2() {
		Spot neighbor11 = new Spot(1, 1);
		Spot neighbor12 = new Spot(1, 2);
		neighbor12.mineTheSpot();
		
		Spot neighbor22 = new Spot(2, 2);
		neighbor22.addNeighbor(neighbor11);
		neighbor22.addNeighbor(neighbor12)
		;
		spot.addNeighbor(neighbor22);
		
		spot.openSpot();
		
		assertTrue(neighbor22.isOpended() && neighbor11.isClosed());
	}
}
