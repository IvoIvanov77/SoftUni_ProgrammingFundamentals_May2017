package strings;

import java.util.Scanner;

public class SumBigNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = new StringBuilder(sc.nextLine()).reverse().toString();
		String b = new StringBuilder(sc.nextLine()).reverse().toString();
		System.out.println(sum(a, b));
		sc.close();
	}
	
	public static String sum(String a, String b){
		
		
		StringBuilder builder = new StringBuilder();
		int remainder = 0;
		int index = 0;
		while(index < Math.min(a.length(), b.length())){
			int x = Integer.parseInt(a.charAt(index) + "");
			int y = Integer.parseInt(b.charAt(index) + "");
			int sum = x + y + remainder;			
			builder.append(sum % 10);
			remainder = sum /10;
			index ++;
		}
		
		while(index < Math.max(a.length(), b.length())){			
			Integer x = 0;
			if(a.length() > b.length()){
				x =  Integer.parseInt(a.charAt(index) + "");
			}else {
				x =  Integer.parseInt(b.charAt(index) + "");
			}
			int sum = x + remainder;			
			builder.append(sum % 10);
			remainder = sum /10;			
			index ++;
		}
		if(remainder != 0){
			builder.append(remainder);
		}	
		while(builder.toString().endsWith("0")){
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.reverse().toString();
	}
}
