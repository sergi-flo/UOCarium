package edu.uoc.uocarium.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import edu.uoc.uocarium.model.AnimalException;
import edu.uoc.uocarium.model.Corydoras;
import edu.uoc.uocarium.model.Danio;
import edu.uoc.uocarium.model.Fish;
import edu.uoc.uocarium.model.Food;
import edu.uoc.uocarium.model.Gender;
import edu.uoc.uocarium.model.Item;
import edu.uoc.uocarium.model.ItemException;
import edu.uoc.uocarium.model.Keeper;
import edu.uoc.uocarium.model.Movable;
import edu.uoc.uocarium.model.MovableException;
import edu.uoc.uocarium.model.SubmarineToy;
import edu.uoc.uocarium.model.Tank;
import edu.uoc.uocarium.model.TankException;
import edu.uoc.uocarium.model.Tetra;

public class UOCariumController {

	Database database;
	String tankSelected;
	
	public UOCariumController(String folderName) throws ItemException {
		database = new Database(folderName);
		tankSelected = (database.getTanks().size()!=0)? database.getTanks().get(0).getId():null;
	}
		
	public String getTankSelected() {
		return tankSelected;
	}
	
	public void setTankSelected(String tankSelected) {
		this.tankSelected = tankSelected;
	}

	public List<Tank> getTanks(){
		List<Tank> tanks = database.getTanks();
		//TODO
		Collections.sort(tanks);
		return tanks;
	}
	
	public Tank getTank(String id) {
		return database.getTank(id);
	}
	
	public List<Item> getMovableItems(){
		//TODO
		List<Item> movableList = new ArrayList<>();
		for(Item movableItem: getTank(getTankSelected()).getItems()){
			if(movableItem instanceof Movable) {
				movableList.add(movableItem);
			}
		}
		return movableList;			
	}
	
	public List<Item> getItems(){		
		return database.getTank(getTankSelected()).getItems();
	}
	
	public void addFish() throws MovableException, ItemException, AnimalException{
		//TODO
		int number = (new Random()).nextInt(11);
		double xCoord = (new Random()).nextDouble()*301;
		double yCoord = (new Random()).nextDouble()*301;
		boolean genderDecision = (new Random()).nextBoolean();
		Gender gender = Gender.FEMALE;
		if (genderDecision) {
			gender = Gender.MALE;
		}
		if (number < 3) {
			new Danio(xCoord, yCoord, gender, 0, 100, getTank(getTankSelected()));
		} else if (3<= number && number<6) {
			new Tetra(xCoord, yCoord, gender, 0, 100, getTank(getTankSelected()));
		} else {
			new Corydoras(xCoord, yCoord, gender, 0, 100, getTank(getTankSelected()));
		}
	}
	
	public SubmarineToy getSubmarineToy() {
		
		Optional<Item> op = database.getTank(getTankSelected()).getItems().stream().filter(p -> p instanceof SubmarineToy).findFirst();
		
		return op.isEmpty()?null:(SubmarineToy) op.get();			
				
	}
	
	public boolean isSubmarineToy() {
		return getSubmarineToy() != null;
	}
	
	public void toggleSubmarineToy() throws ItemException, MovableException{
		//TODO
		if(!isSubmarineToy()){
			new SubmarineToy(50, 50, 100, 50, getTank(getTankSelected()));
		} else {
			getSubmarineToy().setTank(null);
		}
	}
	
	public String getTankInfo() {
		return getTank(getTankSelected()).toString();
	}
	
	public List<Item> removeDeadItems(){
		//TODO
		List<Item> deadItems = getTank(getTankSelected()).getItems();
		
		getTank(getTankSelected()).removeDeadItems();

		return deadItems;
	}
	
	public void feed() throws Exception {
		new Food((new Random()).nextInt(Movable.TANK_PANE_WIDTH-10),0,1,1,5,getTank(getTankSelected()));	
		
	}
	
	public List<Keeper> getKeepers(){
		return database.getKeepers();
	}
}
