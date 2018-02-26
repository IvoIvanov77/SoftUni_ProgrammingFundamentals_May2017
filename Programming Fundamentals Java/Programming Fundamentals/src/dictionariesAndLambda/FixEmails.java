package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = "";
		Map<String, String> map = new LinkedHashMap<>();
		while(true){
			line = sc.nextLine();
			String person = line;
			if(line.equals("stop")){
				break;
			}
			line = sc.nextLine();
			String email = line;
			if(!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk")){
				map.put(person, email);
			}
			
		}
		
//		System.out.println(map);
		map.entrySet().forEach(es -> System.out.println(es.getKey() + " -> " + es.getValue()));
		sc.close();	

	}

}
