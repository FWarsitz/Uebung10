package h1;

public class Grid {
	private Cell[][] gridArray;

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}
	
	public Grid(Cell[] cells, int gridRows, int gridCols) {
		gridArray = new Cell[gridRows][gridCols];
		
		for (int i = 0; i < gridRows; i++) {
			for(int j = 0; j < gridCols; j++) {
				gridArray[i][j] = new Cell(i,j);
			}
		}
		
		for(Cell cell : cells) {
			if(cell.getIndexRow() < gridRows && cell.getIndexCol() < gridCols) {
				gridArray[cell.getIndexRow()][cell.getIndexCol()].setAlive(true);
			}
		}
		
		for(Cell[] row : gridArray) {
			for(Cell c : row) {
				c.countLivingNeighbors(gridArray);
			}
		}
	}
	
	public void computeNextGen() {
		
		for(Cell[] cellArray : gridArray) {
			for(Cell cell : cellArray) {
				cell.setAlive(cell.isAliveNextGen());
			}
		}
		for(Cell[] cellArray : gridArray) {
			for(Cell cell : cellArray) {
				cell.countLivingNeighbors(gridArray);
			}
		}
	}
	
	public void computeGeneration(int n) {
		for(int i = 0; i < n; i ++) {
			computeNextGen();
		}
	}
	

}
