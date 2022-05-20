package sumList;

import java.util.LinkedList;

public class SumList {
	
	private int expandedFormAscending(LinkedList<Integer> l) {
		int result = 0;
		
		for (int i = 0; i < l.size(); i ++) {
			int digit = l.get(i);
			result += digit*Math.pow(10, i);
		}
		return result;
	}
	
	private int expandedFormDescending(LinkedList<Integer> l) {
		int result = 0;
		int power = l.size()-1;
		
		for(int i = 0; i < l.size(); i++) {
			int digit = l.get(i);
			System.out.println(digit+", "+power);
			result += digit*Math.pow(10,power);
			power --;
		}
		return result;
	}
	
	public int reverseOrderSum (LinkedList<Integer> a, LinkedList<Integer> b) {
		return expandedFormAscending(a)+expandedFormAscending(b);
	}
	
	public int forwardOrderSum (LinkedList<Integer> a, LinkedList<Integer> b) {
		return expandedFormDescending(a)+expandedFormDescending(b);
	}
	
}
