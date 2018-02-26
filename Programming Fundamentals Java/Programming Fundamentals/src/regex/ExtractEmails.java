package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		String regex = "(?<=^|\\s)([a-zA-Z0-9]+[\\.|\\-|\\_]*)+[a-zA-Z0-9]+]*@([a-zA-Z]+\\-*[a-zA-Z]+\\.)+[a-zA-Z]+";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		
		while(m.find()){
			System.out.println(m.group());
		}
		sc.close();

	}

}
