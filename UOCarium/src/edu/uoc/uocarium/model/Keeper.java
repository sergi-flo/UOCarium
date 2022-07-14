package edu.uoc.uocarium.model;

import java.util.ArrayList;
import java.util.List;

public class Keeper {
    
    private String id;
    private String name;
    private String surename;
    private ArrayList<Tank> tanks;

    public Keeper(String id, String name, String surename) throws KeeperException{
        setId(id);
        setName(name);
        setSurename(surename);
        tanks = new ArrayList<>();
    }

    public void setId(String id) throws KeeperException{
        if (id==null) {
            throw new NullPointerException();
        } else if (id.length()!=5) {
            throw new KeeperException(KeeperException.MSG_ERR_LENGHT_ID);
        } else if (id.charAt(0)!='G') {
            throw new KeeperException(KeeperException.MSG_ERR_UPPERCASE_ID);
        }
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getSurename() {
        return this.surename;
    }

    public void addTank(Tank tank) throws KeeperException{
        if (this.tanks.size()>4) {
            throw new KeeperException(KeeperException.MSG_ERR_TANK);
        } if (!this.tanks.contains(tank)) {
            this.tanks.add(tank);
        }
    }

    @Override
	public String toString() {
		StringBuilder str = new StringBuilder("["+getId()+"] "+getSurename()+", "+getName()+":");
		
		for(Tank tank : this.tanks) { 
			if(tank != null) str.append("\n\t"+tank);
		}
		
        return str.toString();
    }
}