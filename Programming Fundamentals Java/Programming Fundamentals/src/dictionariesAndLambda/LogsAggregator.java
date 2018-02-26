package dictionariesAndLambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int count = 0;
		Map<String, Map<String, Long>> map = new HashMap<>();

		while (count < n) {
			String line = sc.nextLine();
			String[] input = line.trim().split(" ");			
			String ip = input[0];
			String user = input[1];
			Long duration = Long.parseLong(input[2]);

			if (map.containsKey(user)) {
				map.get(user).computeIfPresent(ip, (k, v) -> v + duration);
				map.get(user).computeIfAbsent(ip, v -> duration);
			} else {
				Map<String, Long> tmp = new TreeMap<>();
				tmp.put(ip, duration);
				map.put(user, tmp);
			}

			count ++;
		}
//		map.entrySet().forEach(es -> es.setValue(sortByKey(es.getValue())));
//		System.out.println(calculateCountryPopulation(map));
		formatOutput(map);
		sc.close();

	}

	private static void formatOutput(Map<String, Map<String, Long>> map) {

		Map<String, Long> users = calculateSessionDuration(map);
		users.entrySet().forEach(es -> {
			System.out.printf("%s: %d ", es.getKey(), es.getValue());
			List<String> result = new ArrayList<String>(map.get(es.getKey()).keySet());			
			System.out.println(result);
		});

	} 
	
	
	public static Map<String, Long> calculateSessionDuration(Map<String, Map<String, Long>> map){
		Map<String, Long> result = new TreeMap<>();
		map.entrySet().forEach(es ->{
			String key = es.getKey();
			Long sum = 0L;
			for (Entry<String, Long> ip: es.getValue().entrySet()) {
				sum += ip.getValue();
			}
			result.put(key, sum);
		});		
		return result;
	}
	
	

}
