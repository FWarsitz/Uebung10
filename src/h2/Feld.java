package h2;

public class Feld {

	private boolean boese;
	private char direction;
	
	
	public boolean isBoese() {
		return boese;
	}
	public void setBoese(boolean boese) {
		this.boese = boese;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	//Konstruktor
	public Feld(boolean boese, char direction) {
		setBoese(boese);
		setDirection(direction);
	}
	
	
	
}
