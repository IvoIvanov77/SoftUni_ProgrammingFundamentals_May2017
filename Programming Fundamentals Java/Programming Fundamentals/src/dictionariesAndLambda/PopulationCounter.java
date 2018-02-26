package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Map<String, Map<String, Long>> map = new LinkedHashMap<>();

		while (!line.equals("report")) {
			String[] input = line.trim().split("\\|");			
			String city = input[0];
			String country = input[1];
			Long population = Long.parseLong(input[2]);

			if (map.containsKey(country)) {
				map.get(country).computeIfPresent(city, (k, v) -> v + population);
				map.get(country).computeIfAbsent(city, v -> population);
			} else {
				Map<String, Long> tmp = new LinkedHashMap<>();
				tmp.put(city, population);
				map.put(country, tmp);
			}

			line = sc.nextLine();
		}
		map.entrySet().forEach(es -> es.setValue(sortByValue(es.getValue())));
//		System.out.println(calculateCountryPopulation(map));
		formatOutput(map);
		sc.close();

	}

	private static void formatOutput(Map<String, Map<String, Long>> map) {
		Map<String, Long> countries = calculateCountryPopulation(map);
		countries.entrySet().forEach(es -> {
			System.out.printf("%s (total population: %d)%n", es.getKey(), es.getValue());
			map.get(es.getKey()).entrySet().forEach(city -> {
				System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
			});
		});

	} 
	
	
	
	public static Map<String, Long> calculateCountryPopulation(Map<String, Map<String, Long>> map){
		Map<String, Long> result = new LinkedHashMap<>();
		map.entrySet().forEach(es ->{
			String key = es.getKey();
			Long sum = 0L;
			for (Entry<String, Long> city: es.getValue().entrySet()) {
				sum += city.getValue();
			}
			result.put(key, sum);
		});		
		return sortByValue(result);
	}
	
	public static  Map<String, Long> sortByValue(Map<String, Long> map) {
	    return map.entrySet()
	              .stream()
	              .sorted((es1, es2) -> Long.compare(es2.getValue(), es1.getValue()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}

}
