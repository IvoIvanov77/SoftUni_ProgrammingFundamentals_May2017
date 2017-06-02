package regex;

import java.util.Scanner;

public class ExtractSentencesByKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();		
		String line = sc.nextLine();
		sc.close();
		
		String[] sentences = line.split("(\\.|\\?|\\!)\\s*");
		
		for (String string : sentences) {
			if(string.matches(".*[^a-zA-Z]+" + word + "[^a-zA-Z]+.*")){
				
				System.out.println(string);
			}
		}		

	}
	
	

}
