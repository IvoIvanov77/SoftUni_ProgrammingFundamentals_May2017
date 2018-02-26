package dictionariesAndLambda;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarmingBetterSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> resources = new TreeMap<>();
		Map<String, Integer> junks = new TreeMap<>();
		resources.put("shards", 0);
		resources.put("fragments", 0);
		resources.put("motes", 0);
		boolean notEnoughMaterial = true;
		Scanner sc = new Scanner(System.in);
		while (notEnoughMaterial) {
			String[] command = sc.nextLine().trim().toLowerCase().split(" ");
			
			for (int i = 0; i < command.length; i++) {
				int quantity = Integer.parseInt(command[i]);
				String material = command[++i];
				
				if (isJunk(material)) {
					junks.computeIfPresent(material, (k, v) -> v + quantity);
					junks.computeIfAbsent(material, v -> quantity);
					
				} else {
					resources.computeIfPresent(material, (k, v) -> v + quantity);
					if (resources.get(material) >= 250) {
						resources.compute(material, (k, v) -> v - 250);
						formatOutput(resources, junks, material);
						notEnoughMaterial = false;
						break;
					}
				}
			}
			
		}
		sc.close();
	}

	private static void formatOutput(Map<String, Integer> resources, Map<String, Integer> junks, 
			String material) {
		System.out.printf("%s obtained!%n", getItem(material));
		
		resources.entrySet().stream().sorted((es1, es2) -> 
		es2.getValue().compareTo(es1.getValue()))
		.forEach(es -> System.out.printf("%s: %d%n", es.getKey(), es.getValue()));
		
		junks.entrySet().forEach(es -> System.out.printf("%s: %d%n", es.getKey(), es.getValue()));
	}

	public static String getItem(String material) {
		switch (material) {
		case "shards":
			return "Shadowmourne";
		case "fragments":
			return "Valanyr";
		case "motes":
			return "Dragonwrath";
		default:
			return "junk";
		}
	}

	public static boolean isJunk(String material) {
		return getItem(material).equals("junk");
	}
	
}
