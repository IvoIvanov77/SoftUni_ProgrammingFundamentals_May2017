package arrays;

import java.util.Scanner;

public class CompareCharArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] arr1 = readArray(sc.nextLine());
		char[] arr2 = readArray(sc.nextLine());
		if(compareCharArrays(arr1, arr2) < 0){
			printArray(arr1);
			printArray(arr2);
		}else {
			printArray(arr2);
			printArray(arr1);
		}
		sc.close();
	}
	
	private static void printArray(char[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();		
	}
	
	private static int compareCharArrays(char[] arr1, char[] arr2){
		for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
			int a = arr1[i] - arr2[i];
			if(a != 0){
				return a;
			}
		}
		return arr1.length - arr2.length;
	}
	
	private static char[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		char[] charArray = new char[strArray.length];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = strArray[i].charAt(0);
		}
		return charArray;			
	}

}
