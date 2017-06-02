package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitByWordCasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String regex = "[,;:.!()\"\'\\\\/\\[\\] ]";
//		System.out.println(regex);
		
		String[] array = sc.nextLine().trim().split(regex);
//		System.out.println(Arrays.toString(array));
		List<String> lowerCase = new ArrayList<>();
		List<String> upperCase = new ArrayList<>();
		List<String> mixed = new ArrayList<>();
		for (String string : array) {
			if(!string.isEmpty()){				
				if(string.matches("\\p{javaLowerCase}+")){
					lowerCase.add(string);
				}else if(string.matches("\\p{javaUpperCase}+")){
					upperCase.add(string);
				}else {
					mixed.add(string);
				}
			}
		}		
		System.out.printf("Lower-case: %s%n", lowerCase.toString().replaceAll("[\\[\\]]", ""));
		System.out.printf("Mixed-case: %s%n", mixed.toString().replaceAll("[\\[\\]]", ""));
		System.out.printf("Upper-case: %s%n", upperCase.toString().replaceAll("[\\[\\]]", ""));
		
		sc.close();
	}

}
