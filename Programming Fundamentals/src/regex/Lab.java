package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String regex = "\\b[A-Z][a-z]+[ ][A-Z][a-z]+\\b";
		
		Pattern p = Pattern.compile(regex);
		System.out.println(p.pattern());		
		
		String name = "Ivaylo Ivanov";
		
		Matcher m = p.matcher(name);
		System.out.println(m.find());
		System.out.println(m.group(0));
		System.out.println(m.start());
		System.out.println(m.end());
		System.out.println(m.groupCount());
		
		System.out.println(name.matches(regex));
		System.out.println(Pattern.matches(regex, name));
		
		System.out.println("--------------------------------");
		String phoneRegex = "(?<=^|\\s)\\+359(-|\\s)2\\1\\d{3}\\1\\d{4}\\b";
		Pattern p1 = Pattern.compile(phoneRegex);
		Matcher m1 = p1.matcher("+359 2 222 2222 +359-2-222-2222");
//		System.out.println(m1.find());
		
//		System.out.println(m1.matches());
		int count = 0;
		while(m1.find()){
			count++;
			System.out.println(m1.group());
		}
		System.out.println(count);
		
		

	}

}
