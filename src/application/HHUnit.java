//package application;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class HHUnit {
//	Player p;
//	
//	@Test
//	public void testPlanetDistance() {
//		p = new Player("hunter", 5, 5, 5, 5, 5);
//		
//		//basic skills
//		assertTrue(p.getEngineer() == 5);
//		assertFalse(p.getEngineer() != 5);
//		assertTrue(p.getFighter() == 5);
//		assertFalse(p.getFighter() != 5);
//		assertTrue(p.getInvestor() == 5);
//		assertFalse(p.getInvestor() != 5);
//		assertTrue(p.getPilot() == 5);
//		assertFalse(p.getPilot() != 5);
//		assertTrue(p.getTrader() == 5);
//		assertFalse(p.getTrader() != 5);
//		
//		//check set money
//		p.setMoney(5);
//		assertTrue(p.getMoney() == 5);
//		assertFalse(p.getMoney() != 5);
//		
//		//check set fuel
//		p.setFuel(5);
//		assertTrue(p.getFuel() == 5);
//		assertFalse(p.getFuel() != 5);
//		
//		//check fuel change
//		p.setFuel(5);
//		p.removeFuel(1);
//		assertTrue(p.getFuel() == 4);
//		assertFalse(p.getFuel() != 4);
//		
//		//check name set
//		assertTrue(p.getName().equals("hunter"));
//	}
//}
