package application;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class NSJunit {
	Ship ship;
	HashMap<String, Integer> emptyWeapons = new HashMap<>();
	HashMap<String, Integer> oneP = new HashMap<>();
	HashMap<String, Integer> onePoneB = new HashMap<>();
	HashMap<String, Integer> twoPoneB = new HashMap<>();

	@Before
	public void setUp() throws Exception {
		ship = Ship.ships.get("flea");
		emptyWeapons = new HashMap<>();
		oneP = new HashMap<>();
		oneP.put("pulse", 1);
		onePoneB = new HashMap<>();
		onePoneB.put("pulse", 1);
		onePoneB.put("beam", 1);
		twoPoneB = new HashMap<>();
		twoPoneB.put("pulse", 2);
		twoPoneB.put("beam", 1);
	}

	@Test
	public void test() throws Exception {
		assertEquals(emptyWeapons, ship.getWeapons());
		ship.addWeapon("pulse");
		assertEquals(oneP, ship.getWeapons());
		ship.addWeapon("beam");
		assertEquals(onePoneB, ship.getWeapons());
		ship.addWeapon("pulse");
		assertEquals(twoPoneB, ship.getWeapons());
	}

}