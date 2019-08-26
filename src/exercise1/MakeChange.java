package exercise1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a function to calculate change for a given number (number represents cents) 
 * The function will return list, vector or collection of numbers representing the number of 
 * quarters(25), dimes(10), nickels (5), pennies (1) that would yield the correct change.
 * # Example:
 * # For 83¢, the function will return 3 quarters, 0 dimes, 1 nickel, and 3 pennies.

 * @author TStarck
 *
 */
public class MakeChange {
	private static final int QUARTERS = 25;
	private static final int DIMES = 10;
	private static final int NICKELS = 5;
	private static final int PENNIES = 1;
	
	private ArrayList<Integer> typeOfCoins = new ArrayList<Integer>();
	/**
	 * Make change with QUARTERS, DIMES, NICKELS, and PENNIES
	 */
	public MakeChange() {
		typeOfCoins.add(QUARTERS);
		typeOfCoins.add(DIMES);
		typeOfCoins.add(NICKELS);
		typeOfCoins.add(PENNIES);
	}
	
	/**
	 * Make change with specified list of coins
	 * @param list coins to make change with, in order from largest to smallest
	 */
	public MakeChange(ArrayList<Integer> list) {
		Collections.sort(list);
		Collections.reverse(list);
		this.typeOfCoins = list;
	}
	/**
	 * Get the number of quarters, dimes, nickels, and pennies that can be returned from numCents
	 * using the fewest coins possible
	 * @param numCents
	 * @return ArrayList<Integer> of form largest coin to smallest coin
	 */
	public ArrayList<Integer> getChange(int numCents)
	{
		ArrayList<Integer> out = new ArrayList<>();
		// adding numCents to list 
		out.add(numCents);
		
		// make change for QUARTERS, DIMES, NICKELS, and PENNIES
		for (int coin : this.typeOfCoins) {
			out = divisible(out, coin);
		}
		
		// remove numCents from list
		out.remove(0);
		return out;
	}
	
	/**
	 * Find how many times the coin divider can be given as change
	 * @param list containing numCents to make change from and running list of change to give
	 * @param theCoin coin we are trying to give as change
	 * @return list of coins to give as change and numCents to make more change for
	 */
	public ArrayList<Integer >divisible(ArrayList<Integer> list, int theCoin) {
		// retrieve numCents from list
		int numCents = list.get(0);
		int numCoins = 0;
		// find number of coins that can be given as change 
		numCoins = numCents / theCoin;
		// add to list
		list.add(numCoins);
		// update the numCents we need to make change for 
		numCents -= numCoins * theCoin;
		list.set(0, numCents);
		
		return list;
	}
	
	public static void main(String[] args) {
		test1();
        
        test2();
    }
	
	public static void test1( ) {
		System.out.println("Test Basic Coins");
		MakeChange change = new MakeChange();
		ArrayList<Integer> test = change.getChange(102);
        System.out.println(test);
        test = change.getChange(99);
        System.out.println(test);
        test = change.getChange(83);
        System.out.println(test);
	}
	public static void test2() {
		System.out.println("Test Custom Coins");
		ArrayList<Integer> typeCoins = new ArrayList<Integer>();
		typeCoins.add(50);
		typeCoins.add(25);
		typeCoins.add(10);
		typeCoins.add(5);
		typeCoins.add(1);
		
		MakeChange change = new MakeChange(typeCoins);
		ArrayList<Integer> test = change.getChange(102);
        System.out.println(test);
        test = change.getChange(99);
        System.out.println(test);
        test = change.getChange(83);
        System.out.println(test);
	}
}