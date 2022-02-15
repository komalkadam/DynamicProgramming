/**
 * 
 */
package com.reancloud.platform.feignclient;

import java.util.Stack;

/**
 * @author kkadam
 *
 */
public class SampleExample {


	/**
	 * @param args
	 */
	//Stack certain values integers and sort
	
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		addElementToStack(stack1, 3); //3
		addElementToStack(stack1, 4); // 3 - > 4
		addElementToStack(stack1, 5);// 3 -> 4 -> 5
		addElementToStack(stack1, 1); //
		while (stack1.size() > 0)
			System.out.print( stack1.pop()+ " ->");
		
	}

	private static void addElementToStack(Stack<Integer> stack, int current) {
		//List<Integer> tempList = new ArrayList<>();
		Integer temp = null;
		if (stack.isEmpty()) {
			stack.push(current);
			return;
		}
		
		if (stack.peek() < current) {
			stack.push(current);
			return;
		}
			
		if ( stack.peek() > current) {
			temp = stack.pop();
			addElementToStack(stack, current);
			stack.push(temp);
		}
		
		
		/*stack.push(current);
		if (temp != null) {
			addElementToStack(stack, temp);
		}*/
		
	}

}
