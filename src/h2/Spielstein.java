package h2;

public class Spielstein {

	private int currentRow;
	private int currentCol;
	private Spielbrett brett;
	
	
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	public Spielbrett getBrett() {
		return brett;
	}
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
	
	//Kunstruktor
	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		setCurrentRow(indexRow);
		setCurrentCol(indexCol);
		setBrett(brett);
	}
	
	private boolean movesOut() {
		
		if(getCurrentRow() == 0 && getBrett().getBrett()[getCurrentRow()][getCurrentCol()].getDirection() == 'U') {
			return true;
		}
		else if(getCurrentRow() == getBrett().getDim()-1 && getBrett().getBrett()[getCurrentRow()][getCurrentCol()].getDirection() == 'D'){
			return true;
		}
		else if(getCurrentCol() == 0 && getBrett().getBrett()[getCurrentRow()][getCurrentCol()].getDirection() == 'L') {
			return true;
		}
		else if(getCurrentCol() == getBrett().getDim()-1 && getBrett().getBrett()[getCurrentRow()][getCurrentCol()].getDirection() == 'R') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void go(int n) {
		for(int i = 0; i < n; i++) {
			if(!movesOut() && !getBrett().getBrett()[getCurrentRow()][getCurrentCol()].isBoese()) {
				switch (getBrett().getBrett()[getCurrentRow()][getCurrentCol()].getDirection()) {
				case 'U':
					setCurrentRow(getCurrentRow() - 1);
					break;
				case 'D':
					setCurrentRow(getCurrentRow() + 1);
					break;
				case 'L':
					setCurrentCol(getCurrentCol() -1);
					break;
				case 'R':
					setCurrentCol(getCurrentCol() +1);
					break;
				}
			}
		}
		
	}
	
}
