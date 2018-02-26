package arrays;

import java.util.Scanner;

public class PairsByDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = readArray(sc.nextLine());
		int difference = Integer.parseInt(sc.nextLine());
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if(Math.abs(array[i] - array[j]) == difference){
					count ++;
				}
			}
		}
		System.out.println(count);
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
	

}
