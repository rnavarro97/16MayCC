package stackMin;

import java.util.Arrays;
import java.util.LinkedList;
import sumList.SumList;

public class Main {
	/**
	 * A separate class used for the main method. Feel free to change
	 * this method for the purposes of testing.
	 */
	public static void main (String[] args) {
		StackMin<Integer> stackMin1 = new StackMin<>();
		
		/*
		 * Some simple example inputs to test basic push/pop functionality
		 */
		stackMin1.push(1);
		stackMin1.push(2);
		stackMin1.push(-5);
		stackMin1.push(8);
		stackMin1.push(7);
		stackMin1.push(-6);
		System.out.println(stackMin1.minimum());
		stackMin1.pop();
		System.out.println(stackMin1.minimum());
		
		/*
		 * A second test stack to test construction based on a collection parameter
		 */
		StackMin<Integer> stackMin2 = new StackMin<>(stackMin1);
		System.out.println(stackMin2);
		System.out.println(stackMin2.minimum());
		
		SumList sumList = new SumList();
		
		LinkedList<Integer> num1 = new LinkedList<>(Arrays.asList(7,1,6));
		LinkedList<Integer> num2 = new LinkedList<>(Arrays.asList(5,9,2));
		System.out.println(num1);
		System.out.println(num2);
		
		int reverseSum = sumList.reverseOrderSum(num1, num2);
		System.out.println(reverseSum);
		
		int forwardSum = sumList.forwardOrderSum(num1, num2);
		System.out.println(forwardSum);
	}
}
