package application;

public class Universe {
	Planet[] universe = new Planet[50];
	public Universe() {
		for (int x = 0; x < universe.length; x++) {
			Planet p = new Planet();
			universe[x] = p;
		}		
	}
}
