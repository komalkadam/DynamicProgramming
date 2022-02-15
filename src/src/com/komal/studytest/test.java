package com.komal.studytest;

import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		//System.out.println(PosixFilePermissions.fromString("rw-r--r--"));
		Standard S1 = new Standard("ABC","1");
		Standard S2 = new Standard("DEF","2");
		Standard S3 = new Standard("IJK","1");
		Standard S4 = new Standard("LMN","2");
		List<Standard> list = new ArrayList<>();
		list.add(S1);
		list.add(S2);
		list.add(S3);
		list.add(S4);
		
		list.stream().
		
		
		// TODO Auto-generated method stub
		/*Scanner in = new Scanner(System.in);
		int user_input = in.nextInt();
		
		for (int i = 0; i < user_input; i++) {
			String row = "";
			for (int j = 0; j < user_input - 1; j++) {
				row = row + "*";
				if (j != user_input - 2 )
					row= row + " ";
				
			}
			System.out.println(row);
			
		}*/
	}
	
	

}
class Standard{
	private String name;
	private String category;
	public Standard(String name, String category) {
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}