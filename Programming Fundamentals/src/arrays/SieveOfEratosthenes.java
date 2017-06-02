package arrays;

import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int limit = Integer.parseInt(sc.nextLine());
		boolean[] arr = new boolean[limit + 1];
		for (int i = 2; i < arr.length; i++) {
			arr[i] = true;
		}
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == true){
				for (int j = i * i; j < arr.length; j+=i) {
					arr[j] = false;
				}
			}
		}
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == true){
				System.out.print(i + " ");
			}
		}
		sc.close();
	}

}
