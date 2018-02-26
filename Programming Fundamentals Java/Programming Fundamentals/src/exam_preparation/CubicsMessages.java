package exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubicsMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		
		while (!line.equals("Over!")) {
			int len = Integer.parseInt(sc.nextLine());
			if(isValid(line, len)){
				String mesage = getMesage(line, len);
				String code = getVerificationCode(extractNumbers(line), mesage);
				System.out.printf("%s == %s%n", mesage, code);
			}
			line = sc.nextLine();
		}
		sc.close();
	}
	
	
	public static boolean isValid(String mesage, int len){
		String regex = String.format("[0-9]+[A-Za-z]{%d}[^A-Za-z]*", len);		
		return mesage.matches(regex);
	}
	
	public static String getMesage(String line, int len){
		String regex = String.format("(?<=\\d+)[a-zA-Z]{%d}(?=[^a-zA-Z]*)", len);	
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		m.find();
		return m.group();
	}
	
	public static List<Integer> extractNumbers(String line){
		List<Integer> numbers = new ArrayList<>();
		for (char ch : line.toCharArray()) {
			if(Character.isDigit(ch)){
				numbers.add((int)(ch - '0'));
			}
		}
		return numbers;				
	}
	
	public static String getVerificationCode(List<Integer> numbers, String mesage){
		StringBuilder b = new StringBuilder();
		for (Integer index : numbers) {
			if(index >= 0 && index < mesage.length()){
				b.append(mesage.charAt(index));
			}else{
				b.append(" ");
			}
		}
		return b.toString();
	}

}


