package strings;

import java.util.Scanner;

public class UnicodeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
//			String str = String.format ("\\u%04x", (int)s.charAt(i));
//			System.out.print(str);
			System.out.print( "\\u" + Integer.toHexString(s.charAt(i) | 0x10000).substring(1) );
		}
		sc.close();

	}

}
