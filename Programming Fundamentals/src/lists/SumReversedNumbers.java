package lists;

import java.math.BigDecimal;
import java.util.Scanner;

public class SumReversedNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().trim().split(" ");
		for (int i = 0; i < arr.length; i++) {
			if(!arr[i].isEmpty()){
				arr[i] = reverseString(arr[i]);
			}
		}
		BigDecimal result = new BigDecimal(0);
		for (int i = 0; i < arr.length; i++) {
			BigDecimal tmp = new BigDecimal(arr[i]);
			result = result.add(tmp);
		}
		System.out.println(result);
		sc.close();
	}
	
	private static String reverseString(String string){
		StringBuilder builder = new StringBuilder(string);
		return builder.reverse().toString();
	}

}
