package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Map<String, Map<String, Integer>> map = new TreeMap<>();

		while (!line.equals("end")) {
			String[] input = line.trim().split(" ");
			String ip = input[0];
			String user = input[2];

			if (map.containsKey(user)) {
				map.get(user).computeIfPresent(ip, (k, v) -> v + 1);
				map.get(user).computeIfAbsent(ip, v -> 1);
			} else {
				Map<String, Integer> tmp = new LinkedHashMap<>();
				tmp.put(ip, 1);
				map.put(user, tmp);
			}

			line = sc.nextLine();
		}
		
		formatOutput(map);
		sc.close();

	}

	private static void formatOutput(Map<String, Map<String, Integer>> map) {
		map.entrySet().forEach(es -> {
			System.out.println(extract(es.getKey(), "=") + ":");
			Map<String, Integer> addresses = es.getValue();
			int count = 0;
			for (Map.Entry<String, Integer> ip : addresses.entrySet()) {
				System.out.print(extract(ip.getKey(), "=") + " => " + ip.getValue());
//				addresses.remove(ip.getKey());
				count ++;
				if(count < addresses.size()){
					System.out.print(", ");
				}else {
					System.out.println(".");
				}
			}
			
		});
	} 
	
	public static String extract(String str, String ch){
		return str.substring(str.indexOf(ch) + 1);
	} 

}
