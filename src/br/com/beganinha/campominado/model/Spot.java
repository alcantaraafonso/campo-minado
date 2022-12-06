package br.com.beganinha.campominado.model;

import java.util.ArrayList;
import java.util.List;

import br.com.beganinha.campominado.exception.ExplosionException;

public class Spot {
	
	private boolean isMined = false;
	private boolean isOpened = false;
	private boolean isMarked = false;
	private List<Spot> neighbors = new ArrayList<>();
	
	private final int line;
	private final int column;
	
	Spot(int line, int column) {
		this.line = line;
		this.column = column;
	}

	
	boolean addNeighbor(Spot neighbor) {
		boolean isDifferentLine = line != neighbor.line;
		boolean isDifferentColumn = column != neighbor.column;
		boolean diagonal = isDifferentLine && isDifferentColumn;
		
		int lineGap = Math.abs(line - neighbor.line);
		int columnGap = Math.abs(column - neighbor.column);
		int gap = columnGap + lineGap;
		
		if (gap == 1 && !diagonal) {
			neighbors.add(neighbor);
			return true;
		} else if (gap == 2 && diagonal) {
			neighbors.add(neighbor);
			return true;			
		}
		
		return false;
	}
	
	void chanceSpotMark() {
		if (!isOpened)
			isMarked = !isMarked;
	}
	
	boolean openSpot() {
		//só abre se não estiver aberto e não estiver marcado
		if (!isOpened && !isMarked) {
			//marca como true
			isOpened = true;
			
			//Lança exception caso esteja minado
			if (isMined) {
				throw new ExplosionException();
			}
			
			/*
			 * Aqui é feito um processo de recussividade, onde
			 * o método chama a sí mesmo a aporte da lista de vizinhos.
			 * O método openSpot será executado enquanto a condição do primeiro IF for verdadeira
			 * usa-se um Consumer pois não precisa de um retorno e sim de uma execução para marcar o campo como
			 * aberto
			 */
			if (safeNeighborhood()) {
				neighbors.forEach(n -> n.openSpot());
			}
			
			return true;
		}
		
		return false;
	}
	
	boolean safeNeighborhood() {
		return neighbors.stream()
				.noneMatch(n -> n.isMined);
	}
}
