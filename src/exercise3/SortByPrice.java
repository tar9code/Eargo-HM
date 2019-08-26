package exercise3;

import java.util.Comparator;

/**
 * comparator to quickly sort arraylist of Stocks
 * @author TTStarck
 *
 */
public class SortByPrice implements Comparator<Stock> {

	@Override
	public int compare(Stock o1, Stock o2) {
		// TODO Auto-generated method stub
		return o2.profit - o1.profit;
	}
	
}