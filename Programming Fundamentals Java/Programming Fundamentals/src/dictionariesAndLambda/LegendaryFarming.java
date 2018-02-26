package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LegendaryFarming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		Map<String, Long> map = new TreeMap<>();
		map.put("shards", 0L);
		map.put("fragments", 0L);
		map.put("motes", 0L);
		String item = "";
		boolean notEnoughMaterial = true;
		while (notEnoughMaterial) {
			String line = sc.nextLine().toLowerCase();
			String[] input = line.trim().split(" ");			
			for (int i = 0; i < input.length; i++) {
				Long quantity = Long.parseLong(input[i]);
				String material = input[++i];
				map.computeIfPresent(material, (k, v) -> v + quantity);
				map.computeIfAbsent(material, v -> quantity);
				
				if(map.get(material) >= 250 && !isJunk(material)){
					item = getItem(material);
					map.compute(material, (k, v) -> v - 250);
					notEnoughMaterial = false;
					break;
				}
				
			}			

//			line = sc.nextLine();
		}
//		System.out.println(sortByValue(map));
		formatOutput(map, item);

		sc.close();

	}
	
	public static String getItem(String material){
		switch (material) {
		case "shards": return "Shadowmourne";
		case "fragments": return "Valanyr";
		case "motes": return "Dragonwrath";
		default: return "junk";			
		}
	}
	
	public static boolean isJunk(String material){
		return getItem(material).equals("junk");
	}

	private static void formatOutput(Map<String, Long> map, String item) {
		Map<String, Long> result = sortByValue(map);
		System.out.printf("%s obtained!%n", item);
		result.entrySet().forEach(es -> {
			System.out.printf("%s: %d%n", es.getKey(), es.getValue());
			
		});

	} 		
	
	
	public static  Map<String, Long> sortByValue(Map<String, Long> map) {
	    Map<String, Long> result =  map.entrySet()
	              .stream().filter(es -> !isJunk(es.getKey()))
	              .sorted((es1, es2) -> Long.compare(es2.getValue(), es1.getValue()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	    result.putAll(map);
//	    map.entrySet().forEach(es -> {
//	    	result.computeIfAbsent(es.getKey(), v -> es.getValue());
//	    });
	    return result;
	}

}
