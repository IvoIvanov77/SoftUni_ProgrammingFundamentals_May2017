package arrays;

import java.util.Scanner;

public class EqualSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = readArray(sc.nextLine());
		sc.close();
		for (int i = 0; i < array.length; i++) {			
			if(leftSum(array, i) == rightSum(array, i)){
				System.out.println(i);
				return;
			}
		}
		System.out.println("no");

	}
	
	private static int leftSum(int[]array, int index){
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	private static int rightSum(int[]array, int index){
		int sum = 0;
		for (int i = array.length - 1; i > index; i--) {
			sum += array[i];
		}
		return sum;
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}

}
