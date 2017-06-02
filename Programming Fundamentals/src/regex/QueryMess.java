package regex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QueryMess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);		
		String line = sc.nextLine();
		
		while(!line.equals("END")){
			if(line.contains("?")){
				line = line.substring(line.indexOf('?') + 1);
			}
			line = line.replaceAll("(%20|\\+)", " ");
			String[] input = line.split("&");
			
			
			
			Map<String, List<String>> pairs = new LinkedHashMap<>();
			
			for (String string : input) {
				String[] keyValue = string.split("\\s*=\\s*");
				String key = keyValue[0].trim().replaceAll("\\s+", " ");
				String value = keyValue[1].trim().replaceAll("\\s+", " ");
				
				if(pairs.containsKey(key)){
					pairs.get(key).add(value);
				}else{
					List<String> values = new ArrayList<>();
					values.add(value);
					pairs.put(key, values);
				}
			}
			System.out.println(pairs.toString().replaceAll("[{}]", "").replaceAll("(?<=\\]), ", ""));
			
			line = sc.nextLine();
		}
		sc.close();
	}

}
