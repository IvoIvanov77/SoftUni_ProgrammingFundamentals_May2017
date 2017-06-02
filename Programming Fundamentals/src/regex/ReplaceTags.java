package regex;

import java.util.Scanner;

public class ReplaceTags {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String regex = "<a.*?href.*?=(.*)>(.*?)<\\/a>";
		String replacement = "[URL href=$1]$2[/URL]";
		while(!line.equals("end")){
			String result = line.replaceAll(regex, replacement);
			System.out.println(result);
			line = sc.nextLine();
		}
		
		sc.close();
	}

}
