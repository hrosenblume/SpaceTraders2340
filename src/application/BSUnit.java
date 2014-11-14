//package application;
//
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import org.junit.Test;
//
//public class BSUnit {
//	Planet p;
//	
//	@Test
//	public void testPickShips() {
//		p = new Planet();
//		Shipyard s = new Shipyard(p);
//		ArrayList<Ship> ships = s.pickShips(p);
//		for (int x = 0; x < ships.size(); x++) {
//			assertTrue(ships.get(x).minTechLevel <= p.getTechLevel());
//			assertFalse(ships.get(x).minTechLevel > p.getTechLevel());
//		}
//	}
//}
