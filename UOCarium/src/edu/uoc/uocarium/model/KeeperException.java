package edu.uoc.uocarium.model;

public class KeeperException extends Exception{
    
    public static final String MSG_ERR_LENGHT_ID = "[ERROR] A keeper's id must have 5 characters!!";
	public static final String MSG_ERR_UPPERCASE_ID = "[ERROR] A keeper's id must start with letter 'G'!!";		
	public static final String MSG_ERR_TANK = "[ERROR] A keeper cannot take care of more than 5 tanks!!";		
        
    
    public KeeperException() {
		super();
	}
	
	public KeeperException(String msg) {
	    super(msg);
	}
}