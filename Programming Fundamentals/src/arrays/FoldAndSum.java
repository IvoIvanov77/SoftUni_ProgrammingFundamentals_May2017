package arrays;

import java.util.Scanner;

public class FoldAndSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = readArray(sc.nextLine());
//		printArray(firstAndLastK(array));
		printArray(sumArrays(firstAndLastK(array), midle2xK(array)));
		
		sc.close();
	}
	
	public static int[] firstAndLastK(int[] array){
		int k = array.length / 4;
		int[] result = new int[2*k];
		for(int i = k - 1,
				a = 0,
				n = 2 * k - 1,
				j = 3 * k; 
				i >= 0;
				i --, j ++ , n -- , a++){
			result[i] = array[a];
			result[n] = array[j];
		}
		return result;
	}
	
	public static int[] midle2xK(int[] array){
		int k = array.length / 4;
		int[] result = new int[2*k];
		for (int i = k, j = 0; i < array.length - k; i++, j++) {
			result[j] = array[i];
		}
		return result;
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
