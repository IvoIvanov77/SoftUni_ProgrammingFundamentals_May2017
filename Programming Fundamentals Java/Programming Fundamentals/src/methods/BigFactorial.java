package methods;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine());
//		System.out.println(bigFactorial(number));
		System.out.println(trailingZeroes(bigFactorial(number)));
		sc.close();
	}
	
	public static String bigFactorial(int number){
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= number; i++) {
			String tmp = i + "";
			fact = fact.multiply(new BigInteger(tmp));
		}
		return fact.toString();
	}
	
	public static int trailingZeroes(String s){
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) != '0'){
				return count;
			}
			count ++;
		}
		return count;
	}

}
