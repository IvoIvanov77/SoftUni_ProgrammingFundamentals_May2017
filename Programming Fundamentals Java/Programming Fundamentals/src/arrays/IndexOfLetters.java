package arrays;

import java.util.Scanner;

public class IndexOfLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] array = sc.nextLine().toCharArray();
		for (char ch : array) {
			int index = ch - 'a';
			System.out.println(ch + " -> " + index);
			
		}
		sc.close();
	}

}
