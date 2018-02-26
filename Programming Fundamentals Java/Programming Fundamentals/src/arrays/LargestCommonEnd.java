package arrays;

import java.util.Scanner;

public class LargestCommonEnd {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] array1 = sc.nextLine().trim().split(" ");
		String[] array2 = sc.nextLine().trim().split(" ");
		System.out.println(Math.max(scanFromLeft(array1, array2), scanFromRight(array1, array2)));
		sc.close();

	}
	
	private static int scanFromLeft(String[] array1, String[] array2){
		int count = 0;
		int minLength = Math.min(array1.length, array2.length);
		for (int i = 0; i < minLength; i++) {
			if(array1[i].equals(array2[i])){
				count ++;
			}else{
				return count;
			}
		}
		return count;
	}
	
	private static int scanFromRight(String[] array1, String[] array2){
		reverseArrayOfStrings(array1);
		reverseArrayOfStrings(array2);
		return scanFromLeft(array1, array2);
	}
	
	private static void reverseArrayOfStrings(String[] array){		
		int endIndex = array.length - 1;
		for (int i = 0; i <= endIndex/2; i++) {
			String tmp = array[i];
			array[i] = array[endIndex - i];
			array[endIndex - i] = tmp;
		}
		
	}

}
