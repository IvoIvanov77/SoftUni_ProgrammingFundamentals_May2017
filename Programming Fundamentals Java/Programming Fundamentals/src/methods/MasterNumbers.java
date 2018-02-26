package methods;

import java.util.Scanner;

public class MasterNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= number; i++) {
			if(isMasterNumber(i)){
				System.out.println(i);
			}
		}
		sc.close();

	}	

	
	public static int reverseNumber(int n){
		int result = 0;
		while(n != 0){
			int lastDigit = n % 10;
			result = result * 10 + lastDigit;
			n /= 10;
		}
		return result;
	}
	
	public static boolean isSimmetric(int n){
		return n == reverseNumber(n);
	}
	
	public static boolean isSumDivisibleBy(int number, int divisor){
		int result = 0;
		while(number != 0){
			int lastDigit = number % 10;
			result += lastDigit;
			number /= 10;
		}
		return result % divisor == 0;
	}
	
	public static boolean hasEvenDigit(int number){
		while(number != 0){
			int lastDigit = number % 10;
			if(lastDigit % 2 == 0){
				return true;
			}
			number /= 10;
		}
		return false;
	}
	
	public static boolean isMasterNumber(int number){
		return isSimmetric(number) && isSumDivisibleBy(number, 7) && hasEvenDigit(number);
	}

}
