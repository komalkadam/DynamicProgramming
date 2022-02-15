/**
 * 
 */
package com.reancloud.platform.feignclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kkadam
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> number = Arrays.asList(2,3,4,5);
		List<Integer> squares = number.stream().map(num -> num*num).collect(Collectors.toList());
		//List<Integer> squares = number.stream().map(num -> num*num).collect(Collectors.toMap(keyMapper, valueMapper));
		System.out.println(squares);
		
		List<String> names = Arrays.asList("komal", "parth", "sahil", "amar", "mayuri", "kalpana",
				"arhat", "mohini", "vinod", "sanket", "sarakshi", "snehansh","ramchandra");
		List<String> filteredNames = names.stream().filter(name -> name.startsWith("s")).collect(Collectors.toList());
		System.out.println(filteredNames);
		
		List<String> sortedfilteredNames = names.stream()
				.sorted().collect(Collectors.toList());
		System.out.println(sortedfilteredNames);
		
		number.stream().map(num -> num*num).forEach(square -> System.out.println("Square is:"+square));
		System.out.println("EEven numbers are "+number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i));
		

	}

}
