//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//
//public class PVJUnit {
//	
//	private int testEmptyArr[] = new int[5];
//	private int test1ElementArr[] = new int[1];
//	private int testGiantArr[] = new int[500000];
//	private int testRegArr[] = new int[100];
//	private int testNegNumArr[] = new int[6];
//
//	
//	@Before
//	public void setUp() {
//		test1ElementArr[0] = 5;	
//		for (int x = 0; x < testGiantArr.length; x++) { //fill array with large number of elements
//			testGiantArr[x] = 4;
//		}
//		for (int i = 0; i < testRegArr.length; i++) { //fill array to normal values up to 100
//			testRegArr[i] = i;
//		}
//		for(int p = -6; p < 0; p++) { //fill array with negative values
//			testNegNumArr[-p-1] = p;
//		}
//	}
//	@Test
//	public void testSumInMarketController() {
//		assertEquals(0, sum(null)); //test if nothing is sent in as parameter, sum should = 0
//		assertEquals(0, sum(testEmptyArr)); //test if empty array is sent in
//		assertEquals(5, sum(test1ElementArr)); //test if array with one element sent in
//		assertEquals(2000000, sum(testGiantArr)); //test if giant array is sent in
//		assertEquals(4950, sum(testRegArr)); //test if regular array is sent in
//		assertEquals(-21, sum(testNegNumArr)); //test if negative numbers are sent in
//	}
//	
//	//Method pasted from MarketController.java for easy submission purposes
//	private int sum(int[] arr) {
//		if (arr == null) { //check added after JUnit created
//			return 0;
//		}
//		int sum = 0;
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		return sum;
//	}
//
//}
