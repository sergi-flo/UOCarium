package edu.uoc.uocarium.model;

public class Kelp extends Item{

	private int growStep = 50;
	
	public Kelp(double xCoord, double yCoord, double length, double height, Tank tank) throws ItemException {
		super(xCoord, yCoord, "./images/kelp/kelp_default.png", length, height, tank);		
	}
}
