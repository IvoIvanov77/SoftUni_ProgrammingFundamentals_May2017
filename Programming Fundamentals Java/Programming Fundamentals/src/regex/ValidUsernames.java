package regex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ValidUsernames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		String line = sc.nextLine();
		String[] ussernames = line.split("[\\s\\/\\\\\\(\\)]+");		
		
		String regex = "(?<=^|\\s)[a-zA-Z]{1}[\\w]{2,24}";			
		
		List<String> validNames = Arrays.asList(ussernames).stream()
		.filter(name -> isValid(name, regex))
		.collect(Collectors.toList());
		
		int bestLenght = 0;
		int bestIndex = 0;
		
		for (int i = 1; i < validNames.size(); i++) {
			int currentLenght = validNames.get(i).length() + validNames.get(i - 1).length();
			if(currentLenght > bestLenght){
				bestLenght = currentLenght;
				bestIndex = i;
			}
		}
		
		System.out.printf("%s%n%s", validNames.get(bestIndex -1), validNames.get(bestIndex));
		
		sc.close();
	}
	
	public static boolean isValid(String name, String regex){
		return name.matches(regex);
	}

}
