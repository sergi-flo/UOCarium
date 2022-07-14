package edu.uoc.uocarium.model;

public class Tetra extends Fish{
    
    public Tetra(double xCoord, double yCoord, Gender gender, int age, int energy, Tank tank) throws AnimalException, ItemException, MovableException{
        super(xCoord, yCoord, "./images/tetra/tetra", 64.0, 64.0, gender, age, 0.5, 0.3, 0.002, Color.RED, energy, tank);	
    }

    @Override
    public int getOxygenConsumption() {
        return 10;
    }

    @Override
    public void breathe() {
        // TODO Auto-generated method stub
    }

    @Override
    public String toString() {
        return super.toString()+" : Tetra\n";
    }
}