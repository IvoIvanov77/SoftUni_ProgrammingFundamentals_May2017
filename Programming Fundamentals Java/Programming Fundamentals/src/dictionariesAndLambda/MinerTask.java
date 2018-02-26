package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = "";
		Map<String, Integer> map = new LinkedHashMap<>();
		while(true){
			line = sc.nextLine();
			String resource = line;
			if(line.equals("stop")){
				break;
			}
			line = sc.nextLine();
			Integer quantity = new Integer(line);
			
			map.computeIfPresent(resource, (k , v) -> v + quantity);
			map.computeIfAbsent(resource, v -> quantity);
		}
		
//		System.out.println(map);
		map.entrySet().forEach(es -> System.out.println(es.getKey() + " -> " + es.getValue()));
		sc.close();

	}

}
