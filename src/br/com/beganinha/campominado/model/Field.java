package br.com.beganinha.campominado.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
	
	private boolean isMinado = false;
	private boolean isOpened = false;
	private boolean isMarked = false;
	private List<Field> neighbors = new ArrayList<>();
	
	private final int line;
	private final int column;
	
	public Field(int line, int column) {
		this.line = line;
		this.column = column;
	}

	
	public boolean addNeighbor(Field neighbor) {
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
	
}
