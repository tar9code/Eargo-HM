package exercise3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class Test {

	@org.junit.jupiter.api.Test
	void test1() {
		System.out.println("test1");
		ArrayList<Integer> stocks = new ArrayList<Integer>();
		int[] list = {3, 8, 8, 55, 38, 1, 7, 42, 54, 53};
		for (int a: list) {
			stocks.add(a);
		}
		// spot 0 of array is day 1
		System.out.println("Given these stock prices on each day");
		System.out.println(stocks);
		StockPrices prices = new StockPrices(stocks);
		prices.BestDay();
		assertTrue(true);
	}
	
	@org.junit.jupiter.api.Test
	void test2() {
		System.out.println("test2");
		ArrayList<Integer> stocks = new ArrayList<Integer>();
		int[] list = {3, 1, 33, 2, 55, 60, 90, 1, 100, 25, 1, 333, 330, 334, 300, 100, 50};
		for (int a: list) {
			stocks.add(a);
		}
		// spot 0 of array is day 1
		System.out.println("Given these stock prices on each day");
		System.out.println(stocks);
		StockPrices prices = new StockPrices(stocks);
		prices.BestDay();
		assertTrue(true);
	}

}
