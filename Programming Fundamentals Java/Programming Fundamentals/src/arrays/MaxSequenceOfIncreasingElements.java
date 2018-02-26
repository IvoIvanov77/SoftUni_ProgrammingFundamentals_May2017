package arrays;

import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] array = readArray(sc.nextLine());
		int bestStart = 0;
		int bestEnd = 0;
		int bestCount = 0;
		
		for (int i = 1; i < array.length; i++) {
			int startIndex = i - 1;
			int curentIndex = i;
			int count = 0;
			while(curentIndex < array.length && array[curentIndex] > array[curentIndex - 1] ){
				count ++;				
				curentIndex ++;
				
			}
//			System.out.println(count);
			if(count > bestCount){
				bestCount = count;
				bestStart = startIndex;
				bestEnd = curentIndex;
			}
			i = curentIndex;
		}
		printArray(array, bestStart, bestEnd);
		sc.close();
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}
	
	private static void printArray(int[] array, int start, int end){
		for (int i = start; i < end; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();		
	}

}
