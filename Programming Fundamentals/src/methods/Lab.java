package methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		printingTriangle(sc);
//		pow(sc);
//		getMax(sc);
		multiplyEvensByOdds(sc);

	}
	
	static void printingTriangle(Scanner sc){
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 1; i < n; i++) {
			printLine(i);
		}
		
		for (int i = n; i > 0; i--) {
			printLine(i);
		}
	}
	
//	helper
	private static void printLine(int n){
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static void pow(Scanner sc){
		double number = Double.parseDouble(sc.nextLine());
		int power = Integer.parseInt(sc.nextLine());
		System.out.println(formatNumber(riseToPower(number, power), "#.########"));
	}
	
	static <T extends Comparable<T>> void getMax(Scanner sc){
		@SuppressWarnings("unused")
		String type = sc.nextLine();
		@SuppressWarnings("unchecked")
		T first = (T) sc.nextLine();
		@SuppressWarnings("unchecked")
		T second = (T) sc.nextLine();
		System.out.println(getMax(first, second));
	}
	
//	helper
	private static <T extends Comparable<T>> T getMax(T first, T second){
		if(first.compareTo(second) >= 0){
			return first;
		}
		return second;
	}
	
	
//	helper
	private static double riseToPower(double number, int power){
		double result = 1;
		for (int i = 1; i <= power; i++) {
			result *= number;
		}
		return result;
	}
	
	public static void multiplyEvensByOdds(Scanner sc){
		int n = Integer.parseInt(sc.nextLine());
		int evensSum = 0;
		int odsSum = 0;
		
		while(n != 0){
			int lastDigit = n % 10;
			if(lastDigit % 2 == 0){
				evensSum += lastDigit;
			}else {
				odsSum += lastDigit;
			}
			
			n /= 10;
		}
		System.out.println(evensSum * odsSum);
	}
	
	
	public static String formatNumber(Number n, String s) {
		return new DecimalFormat(s).format(n);
	}
	
	

}
