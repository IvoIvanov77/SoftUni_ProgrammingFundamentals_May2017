package arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		printDayOfWeek(sc);
//		printReverseArrays(sc);
//		lastKNumbersSumsSequence(sc);
//		tripleSum(sc);
//		roundingAwayZero(sc);
//		reverseArrayOfStrings(sc);
//		sumArrays(sc);
//		condenseArrayToNumber(sc);
		extractMiddleElements(sc);

	}
	
	public static void printDayOfWeek(Scanner sc){
		int day = Integer.parseInt(sc.nextLine());
		String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		if(day >= 1 && day <= 7){
			System.out.println(weekDays[day - 1]);
		}else {
			System.out.println("Invalid day!");
		}
	}
	
	public static void printReverseArrays(Scanner sc){
		int n = Integer.parseInt(sc.nextLine());
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(sc.nextLine());
		}
		
		for (int i = array.length -1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void lastKNumbersSumsSequence(Scanner sc){
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		
		long[] array = new long[n];
		array[0] = 1;
		
		for (int i = 1; i < array.length; i++) {
			long sum = 0;
			for(int j = i - 1; j >= i - k; j --){
				if(j >= 0){					
					sum += array[j];
				}else{
					break;
				}
			}
			array[i] = sum;
		}
		printArray(array);
	}
	
	public static void tripleSum(Scanner sc){
		int[] array = readArray(sc.nextLine());
		boolean flag = false;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int sum = array[i] + array[j];
				for (int k = 0; k < array.length; k++) {
					if(array[k] == sum){
						System.out.println(array[i] + " + " + array[j] + " == " + array[k]);
						flag = true;
						break;
					}
				}
			}
		}
		if(flag == false){
			System.out.println("No");
		}
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}
	
	
	private static void printArray(long[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
	
	public static void roundingAwayZero(Scanner sc){
		String[] array = sc.nextLine().trim().split(" ");
		for(String str : array){
			BigDecimal number = new BigDecimal(str);
			number = number.setScale(0, RoundingMode.HALF_UP);
			System.out.println(str + " => " + number);
		}
	}
	
	public static void reverseArrayOfStrings(Scanner sc){
		String[] array = sc.nextLine().trim().split(" ");
		int endIndex = array.length - 1;
		for (int i = 0; i <= endIndex/2; i++) {
			String tmp = array[i];
			array[i] = array[endIndex - i];
			array[endIndex - i] = tmp;
		}
		for (String string : array) {
			System.out.print(string + " ");
		}
	}
	
	public static void sumArrays(Scanner sc){
		String[] arr1 = sc.nextLine().trim().split(" ");
		String[] arr2 = sc.nextLine().trim().split(" ");
		int size = Math.max(arr1.length, arr2.length);
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			int num1 = Integer.parseInt(arr1[i % arr1.length]);
			int num2 = Integer.parseInt(arr2[i % arr2.length]);
			result[i] = num1 + num2;
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
	
	public static void condenseArrayToNumber(Scanner sc){
		String[] strArray = sc.nextLine().trim().split(" ");
		int[] intArr = new int[strArray.length];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(strArray[i]);
		}
		if(intArr.length > 1){
			while(intArr.length > 1){
				int[] condesed = new int[intArr.length - 1];
				for (int i = 0; i < condesed.length; i++) {
					condesed[i] = intArr[i] + intArr[i + 1];
				}
				intArr = condesed;
			}
		}
		System.out.println(intArr[0]);
	}
	
	public static void extractMiddleElements(Scanner sc){
		String[] array = sc.nextLine().trim().split(" ");
		if(array.length == 1){
			System.out.printf("{ %s }", array[0]);
		}else if(array.length % 2 == 0){
			System.out.printf("{ %s, %s }", array[array.length / 2 - 1], array[array.length / 2]);
		}else {
			System.out.printf("{ %s, %s, %s }", array[array.length / 2 - 1], 
					array[array.length / 2], array[array.length / 2 + 1]);
		}
	}

}
