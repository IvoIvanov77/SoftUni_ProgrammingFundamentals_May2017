package arrays;

import java.util.Scanner;

public class RotateAandSumEasySolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = readArray(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		int n = arr.length;
		int[] result = new int[n];
		for (int i = 1; i <= k; i++) {
			int [] tmp = new int[n];
			for (int j = 0; j < n; j++) {
				tmp[(j + i) % n] = arr[j];				
			}
			result = sumArrays(result, tmp);
		}
		printArray(result);
		sc.close();
	}
	
	private static void printArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}
	
	private  static int[] sumArrays(int[] arr1, int[] arr2){		
		int size = Math.min(arr1.length, arr2.length);
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		return result;
	}
	
	

}
