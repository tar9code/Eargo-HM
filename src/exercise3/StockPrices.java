package exercise3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a function to find out the best Buying and Selling day for maximum gain from daily stock prices of the last 10 days. Following are 2 rules,
 * Buy first
 * You can only buy once and sell once
 *
 * @author TTStarck
 *
 */
public class StockPrices {
	private ArrayList<Integer> tenDayStocks;
	
	/**
	 * Set the stocks to be analyzed
	 * @param listOfStocks list of stocks
	 */
	public StockPrices(ArrayList<Integer> listOfStocks) {
		this.tenDayStocks = listOfStocks;
	}
	
	/**
	 * Find the best day to buy and sell a stock
	 * when you can only buy one time and sell one time
	 */
	public void BestDay() {
		// assemble best sell prices for each day in tenDayStocks
		ArrayList<Stock> stocks = this.BestOfDay();
		
		/* test print
		for (Stock s: stocks) {
			System.out.println(s.toString());
		}*/
		
		// sort best stocks of each day by price
		Collections.sort(stocks, new SortByPrice());
		
		// retrieve best stock
		Stock bestStock = stocks.get(0);
		// print out best stocks results
		System.out.println("Best Profit is " + bestStock.toString());
	}
	
	/**
	 * Takes the list of stocks and returns the days to buy and sell with the most profit 
	 * - with only buying and selling once
	 * This is a rework so that complexity is O(n) instead of O(n^2) that BestDay and BestOfDay provide
	 */
	public void findBestDay() {
		int minVal = tenDayStocks.get(0);
		int profit = 0;
		for (int i = 1; i < tenDayStocks.size(); i++) {
			profit = Math.max(profit, tenDayStocks.get(i) - minVal);
			minVal = Math.min(minVal, tenDayStocks.get(i));
		}
		
		// the plus 1 is a offset (otherwise day 0 exists)
		int minDay = tenDayStocks.indexOf(minVal) + 1;
		int maxDay = tenDayStocks.indexOf(minVal + profit) + 1;
		
		System.out.println("best2");
		System.out.println(profit + " if you buy on day " + minDay + " and sell on day " + maxDay);
	}
	
	/**
	 * Find best sell price of each day in tenDayStocks
	 * @return
	 */
	private ArrayList<Stock> BestOfDay() {
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		
		// loop through all days and find best sell price and add to stocks
		for (int i=0; i < tenDayStocks.size(); i++) {
			int buyPrice = tenDayStocks.get(i);
			int bestSellPrice = 0;
			int bestDayToSell = 0;
			// find best day to sell
			for (int j = i; j < tenDayStocks.size(); j++) {
				int sellPrice = tenDayStocks.get(j);
				// if current sell price is better than previous best
				if (sellPrice > bestSellPrice) {
					// change best day to sell
					bestSellPrice = sellPrice;
					bestDayToSell = j;
				}
			}
			// dayToBuy is just to clarify what goes into stock
			int dayToBuy = i;
			// calculate best profit for day
			int profit = bestSellPrice - buyPrice;
			// create best stock for current day
			// the + 1 is to offset the position 0 of arraylist to day 1
			Stock s = new Stock(profit, dayToBuy + 1, bestDayToSell + 1);
			// add stock to list
			stocks.add(s);
		}
		
		return stocks;
	}
	public static void main(String[] args) {
		test1();
		test2();
    }
	
	public static void test1() {
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
		prices.findBestDay();
	}
	
	public static void test2() {
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
		prices.findBestDay();
	}
}
