package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SurbianUnleashed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		String line = sc.nextLine();
		Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
		
		while(!line.equals("End")){
			String[] input = formatInput(line);
			line = sc.nextLine();
			if(input.length != 4){
				continue;
			}
//			System.out.println(Arrays.toString(input));
			String singer = input[0];
			String venue = input[1];
			Integer ticketPrice = new Integer(input[2]);
			Integer ticketsCount = new Integer(input[3]);
			Integer totalMoney = ticketPrice * ticketsCount;
//			System.out.println(totalMoney);
			if (map.containsKey(venue)) {
				map.get(venue).computeIfPresent(singer, (k, v) -> v + totalMoney);
				map.get(venue).computeIfAbsent(singer, v -> totalMoney);
			} else {
				Map<String, Integer> tmp = new LinkedHashMap<>();
				tmp.put(singer, totalMoney);
				map.put(venue, tmp);
			}			
			
		}	
//		System.out.println(map);
		map.entrySet().forEach(venue -> {
			System.out.println(venue.getKey());
			venue.getValue().entrySet().stream()
			.sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
			.forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()) );
		});
		sc.close();
	}
	
	public static String[] formatInput(String input){
		String[] result = input.split("\\s@|(\\s(?=\\d))");
		return result;
	}

}
