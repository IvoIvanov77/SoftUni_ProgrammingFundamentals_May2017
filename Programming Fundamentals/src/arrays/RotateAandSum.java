package arrays;

import java.util.Scanner;

public class RotateAandSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = readArray(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		if(k == 1){
			printArray(rotate(arr));
		}else{			
			int result[] = new int[arr.length];
			for (int i = 0; i < k; i++) {
				int[] tmp = rotate(arr);
				result = sumArrays(result, tmp);
				arr = tmp;
			}
			printArray(result);
		}
		sc.close();
	}
	
	private static void printArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
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
	
	private  static int[] sumArrays(int[] arr1, int[] arr2){		
		int size = Math.min(arr1.length, arr2.length);
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		return result;
	}
	
	private static int[] rotate(int[] arr){		
		int[] result = new int[arr.length];		
		for (int i = 1; i < arr.length; i++) {
			result[i] = arr[i - 1];
		}
		result[0] = arr[arr.length - 1];
		
		return result;
	}

}
