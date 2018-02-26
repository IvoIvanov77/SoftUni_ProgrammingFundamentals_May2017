package methods;

import java.util.Scanner;

public class Substring {

	public static void main(String[] args) {		

		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		int jump = Integer.parseInt(sc.nextLine());

		char ch = 'p';
		boolean hasMatch = false;

		for (int i = 0; i < text.length(); i++) {
			
			if (text.charAt(i) == ch) {
				
				hasMatch = true;

				int endIndex = i + jump;

				if (endIndex >= text.length()) {
					endIndex = text.length() - 1;
				}

				String matchedString = text.substring(i, endIndex + 1);
				System.out.println(matchedString);
				i += jump;
			}
		}

		if (!hasMatch) {
			System.out.println("no");
		}
		sc.close();
	}

}
