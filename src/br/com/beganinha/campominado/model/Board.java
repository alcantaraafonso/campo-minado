package br.com.beganinha.campominado.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private int quantityMines;
	private int lines;
	private int columns;
	
	private final List<Spot> spots = new ArrayList<>();

	public Board(int quantityMines, int lines, int columns) {
		super();
		this.quantityMines = quantityMines;
		this.lines = lines;
		this.columns = columns;

		generateSpots();
		neighborhoodRelationship();
		putMinesOnBoard();
	}

	private void generateSpots() {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < columns; j++) {
				spots.add(new Spot(i, j));
			}
		}
		
	}
	

	private void neighborhoodRelationship() {
		for(Spot s1: spots) {
			for(Spot s2: spots) {
				s1.addNeighbor(s2);
			}
		}
		
	}
	
	/*
	 * To put mines randomly in the board
	 */
	private void putMinesOnBoard() {
		int armedMine = 0;
		do {
			armedMine = (int)spots.stream()
					.filter(m -> m.isMined())
					.count();
			//a operação de multiplicação está entre parênteses para ter preferência sobre
			//a operação de casting. Sem os parênteses, a operação de casting seria executada antes da 
			//multiplicação
			int random = (int)(Math.random() * spots.size());
			spots.get(random).putMineInTheSpot();
			
		} while(armedMine < quantityMines);
		
	}
	
	public boolean goalAccomplished() {
		return spots.stream().allMatch(spot -> spot.goalAccomplished());
	}
	
	public void restartGame() {
		spots.stream()
			.forEach(spot -> spot.restart());
		putMinesOnBoard();
	}

	public String toString() {
		return "";
	}
	
}
