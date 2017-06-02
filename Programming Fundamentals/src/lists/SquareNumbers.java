package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SquareNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().trim().split(" ");
		List<BigDecimal> numbers = new ArrayList<>();
		for (String string : array) {
			BigDecimal number = new BigDecimal(string);
			if(isSquare(number)){				
				numbers.add(number);
			}
		}
		numbers.sort((p1, p2) -> p2.compareTo(p1));
		System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
		sc.close();
	}
	
	public static boolean isSquare(BigDecimal number){
		return Math.sqrt(number.intValue()) == (int)Math.sqrt(number.intValue());
	}

}
