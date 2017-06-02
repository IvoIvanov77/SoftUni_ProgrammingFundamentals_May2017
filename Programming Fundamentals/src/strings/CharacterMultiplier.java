package strings;

import java.util.Scanner;

public class CharacterMultiplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		System.out.println(characterMultiplier(input[0], input[1]));
		sc.close();
	}
	
	public static int characterMultiplier(String a, String b){
		int sum = 0;
		
		int len = 0;
		while(len < Math.min(a.length(), b.length())){
			sum += a.charAt(len) * b.charAt(len);
			len ++;
		}
		
		while(len < Math.max(a.length(), b.length())){			
			if(a.length() > b.length()){
				sum += a.charAt(len);
			}else {
				sum += b.charAt(len);
			}
			len ++;
		}
		
		return sum;
	}

}
