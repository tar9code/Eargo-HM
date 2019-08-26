package exercise3;


/**
 * Container class of best profit of stock, day to buy, and day to sell
 * @author TTStarck
 *
 */
public class Stock {
	int profit;
	private int dayToBuy;
	private int dayToSell;
	
	public Stock(int profit, int buy, int sell) {
		this.profit = profit;
		this.dayToBuy = buy;
		this.dayToSell = sell;
	}
	
	public String toString() {
		return this.profit + " if you buy on day " + this.dayToBuy + " and sell on day " + this.dayToSell;
	}
}


