package exercise1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class Test {

	ArrayList<Integer> testChange1 = new ArrayList<Integer>();
	ArrayList<Integer> testChange2 = new ArrayList<Integer>();
	ArrayList<Integer> testChange3 = new ArrayList<Integer>();
	
	ArrayList<Integer> testChange4 = new ArrayList<Integer>();
	ArrayList<Integer> testChange5 = new ArrayList<Integer>();
	ArrayList<Integer> testChange6 = new ArrayList<Integer>();
	
	void helperOne() {
		testChange1.add(4);
		testChange1.add(0);
		testChange1.add(0);
		testChange1.add(2);

		testChange2.add(3);
		testChange2.add(2);
		testChange2.add(0);
		testChange2.add(4);

		testChange3.add(3);
		testChange3.add(0);
		testChange3.add(1);
		testChange3.add(3);
	}
	
	void helperTwo() {
		testChange4.add(2);
		testChange4.add(0);
		testChange4.add(0);
		testChange4.add(0);
		testChange4.add(2);

		testChange5.add(1);
		testChange5.add(1);
		testChange5.add(2);
		testChange5.add(0);
		testChange5.add(4);

		testChange6.add(1);
		testChange6.add(1);
		testChange6.add(0);
		testChange6.add(1);
		testChange6.add(3);
	}
	@org.junit.jupiter.api.Test
	void test() {
		System.out.println("Test Basic Coins");
		helperOne();
		MakeChange change = new MakeChange();
		
		ArrayList<Integer> test = change.getChange(102);
        assertEquals(test, testChange1);
        
        test = change.getChange(99);
        assertEquals(test, testChange2);
        
        test = change.getChange(83);
        assertEquals(test, testChange3);
        
		
	}

	@org.junit.jupiter.api.Test
	void test2() {
		System.out.println("Test Custom Coins");
		helperTwo();
		
		ArrayList<Integer> typeCoins = new ArrayList<Integer>();
		typeCoins.add(50);
		typeCoins.add(25);
		typeCoins.add(10);
		typeCoins.add(5);
		typeCoins.add(1);
		
		MakeChange change = new MakeChange(typeCoins);
		
		ArrayList<Integer> test = change.getChange(102);
		//System.out.println(test);
        //System.out.println(testChange4);
		assertEquals(test, testChange4);
        
        test = change.getChange(99);
        assertEquals(test, testChange5);
        
        test = change.getChange(83);
        assertEquals(test, testChange6);
	}
}
