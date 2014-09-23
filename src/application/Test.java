package application;
import java.util.Arrays;
/*
 * This class will be used to test anything related to this project.
 */
public class Test {
	
	// declare any variables for testing here
	
	/**
	 * Runs the tests.
	 * @param args command line arguments (unused)
	 */
	public static void main(String[] args) {
		Universe u = new Universe();
		MarketController mc = new MarketController();
		mc.setPlanet(Universe.universe[0]);
		mc.displayBuyPrices();
		mc.displaySellPrices();
	}

}
