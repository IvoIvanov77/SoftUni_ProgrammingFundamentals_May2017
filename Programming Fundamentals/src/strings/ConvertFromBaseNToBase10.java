package strings;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConvertFromBaseNToBase10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		BigDecimal base = new BigDecimal(input[0]);
		String number = new StringBuilder(input[1]).reverse().toString();	
		
		
		BigDecimal result = new BigDecimal(0);
		
		for (int i = 0; i < number.length(); i++) {
			BigDecimal digit = new BigDecimal(number.substring(i, i +1));
//			System.out.println(digit);
			result = result.add(digit.multiply(base.pow(i)));
		}
		
		System.out.println(result);
		
		sc.close();

	}

}
