package h1;

public class Cell {
	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;
	
	public int getIndexRow() {
		return indexRow;
	}
	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}
	public int getIndexCol() {
		return indexCol;
	}
	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}
	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}
	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}
	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}
	
	
	//Konstruktor #1
	public Cell(int indexRow, int indexCol, boolean alive) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
		setAlive(alive);
	}
	
	//Konstruktor #2
	public Cell(int indexRow, int indexCol) {
		setIndexRow(indexRow);
		setIndexCol(indexCol);
	}
	
	
	
	public void countLivingNeighbors(Cell[][] gridArray) {
		int numLivingNeighbors = 0;
		int rows = gridArray.length;
		int cols = gridArray[0].length;
		
		for(int i = -1; i <= 1; i ++) {
			for( int j = -1; j <= 1; j++) {
				if(i == 0 && j == 0) continue;
				
				int ni = getIndexRow() + i;
				int nj = getIndexCol() + j;
				
				if(ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
					if(gridArray[ni][nj].isAlive()){
						numLivingNeighbors++;
					}
				}
			}
		}

		
		setNumLivingNeighbors(numLivingNeighbors);
		
		decideNextStatus();
	}
	
	private void decideNextStatus() {
		if(isAlive()) {
			if(getNumLivingNeighbors() == 2 || getNumLivingNeighbors() == 3) {
				setAliveNextGen(true);
			}
			else {
				setAliveNextGen(false);
			}
		}
		else {
			setAliveNextGen(getNumLivingNeighbors() == 3);
			
		}
	}
	
	
}
