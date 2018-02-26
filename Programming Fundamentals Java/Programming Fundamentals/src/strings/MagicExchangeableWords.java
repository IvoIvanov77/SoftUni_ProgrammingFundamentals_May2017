package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicExchangeableWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		System.out.println(mapingString(input[0].toLowerCase(), input[1].toLowerCase()));
		sc.close();
	}
	
	
	public static boolean mapingString(String a, String b){
		
		Map<Character, Character> map = new HashMap<>();
		int index = 0;
		while(index < Math.min(a.length(), b.length())){
			if(!map.containsKey(a.charAt(index))){
				map.put(a.charAt(index), b.charAt(index));
			}else {
				if(!map.get(a.charAt(index)).equals(b.charAt(index))){
					return false;
				}
			}
			index ++;
		}
		
		while(index < Math.max(a.length(), b.length())){
			Character ch = null;
			if(a.length() > b.length()){
				ch = a.charAt(index);
			}else {
				ch = b.charAt(index);
			}
			if(!map.containsKey(ch)){
				return false;
			}
			index ++;
		}
		
		return true;
	}

}
