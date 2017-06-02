package strings;

import java.math.BigInteger;
import java.util.Scanner;

public class ConvertBase10ToBaseN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		BigInteger base = new BigInteger(input[0]);
		BigInteger number = new BigInteger(input[1]);
		StringBuilder builder = new StringBuilder();
		
		while(number.compareTo(BigInteger.ZERO) > 0 ){
			BigInteger[] result = number.divideAndRemainder(base);
			builder.append(result[1]);
			number = result[0];
			
		}
		
		System.out.println(builder.reverse());
		sc.close();

	}

}
