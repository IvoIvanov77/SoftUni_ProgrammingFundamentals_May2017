package arrays;

import java.util.Scanner;

public class MostFrequentNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int[] array = readArray(sc.nextLine());
		int result = array[0];
		int maxCount = countOfOccurs(array, array[0]);;
		for (int i : array) {
			if(i != result){
				int count = countOfOccurs(array, i);
				if(count > maxCount){
					maxCount = count;
					result = i;
				}
			}
		}
		System.out.println(result);
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
	
	private static int countOfOccurs(int[] array, int number){
		int count = 0;
		for (int i : array) {
			if(i == number){
				count ++;
			}
		}
		return count;
	}

}
