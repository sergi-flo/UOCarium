package edu.uoc.uocarium.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KeeperTest {

	@Test
	void testSetId() throws KeeperException {
		Keeper instance = new Keeper("G2956","Sergi","Flo");
		instance.setId("G2345");
		assertEquals("G2345",instance.getId());
		instance.setId("G9756");
		assertEquals("G9756",instance.getId());
		
		Exception exception = assertThrows(KeeperException.class, () -> instance.setId("A1234"));
		assertEquals("[ERROR] A keeper's id must start with letter 'G'!!", exception.getMessage());
		Exception exception1 = assertThrows(KeeperException.class, () -> instance.setId("A21234"));
		assertEquals("[ERROR] A keeper's id must have 5 characters!!", exception1.getMessage());
		Exception exception2 = assertThrows(NullPointerException.class, () -> instance.setId(null));
		assertTrue(exception2.toString().contains("NullPointerException"));
	}

	@Test
	void testAddTank() throws TankException, KeeperException{
		Tank tank1 = new Tank("D1","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank3 = new Tank("D3","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank4 = new Tank("D4","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank5 = new Tank("D5","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank6 = new Tank("D6","Default", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Keeper keeper1 = new Keeper("G2956","Sergi","Flo");
		keeper1.addTank(tank1);
		keeper1.addTank(tank2);
		keeper1.addTank(tank3);
		keeper1.addTank(tank4);
		keeper1.addTank(tank5);
		Exception exception = assertThrows(KeeperException.class, () -> keeper1.addTank(tank6));
		assertEquals("[ERROR] A keeper cannot take care of more than 5 tanks!!", exception.getMessage());
	}

}
