package dictionariesAndLambda;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HandsOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Map<String, Set<String>> map = new LinkedHashMap<>();
		while (!line.equals("JOKER")) {
			String[] input = line.trim().split("[:, ]+ ");
			String name = input[0];
			List<String> cards = extractCards(input, 1);
			
			if (map.containsKey(name)) {
				map.get(name).addAll(cards);
			} else {
				Set<String> set = new HashSet<>(cards);
				map.put(name, set);
			}

			line = sc.nextLine();
		}
//		System.out.println(map);
		map.entrySet().forEach(es -> System.out.println(es.getKey() + ": " + getSum(es.getValue())));
		sc.close();

	}

	// J, Q, K, A
	// S -> 4, H-> 3, D -> 2, C -> 1
	public static int calculateValue(String combination) {
		int power = 0;
		int type = 0;
		
		

		switch (combination.charAt(0)) {
		case 'J':
			power = 11;
			break;
		case 'Q':
			power = 12;
			break;
		case 'K':
			power = 13;
			break;
		case 'A':
			power = 14;
			break;
		default:
			power = combination.charAt(0) - '0';
			break;

		}
		
		if(combination.length() > 2){
			power = 10;
		}

		switch (combination.charAt(combination.length() -1)) {
		case 'S':
			type = 4;
			break;
		case 'H':
			type = 3;
			break;
		case 'D':
			type = 2;
			break;
		case 'C':
			type = 1;
			break;

		}
		return power * type;
	}

	public static int getSum(Set<String> set) {
		int sum = 0;
		for (String string : set) {
			sum += calculateValue(string);
		}
		return sum;
	}

	public static List<String> extractCards(String[] arr, int startIndex) {
		return IntStream.range(startIndex, arr.length).boxed().map(index -> arr[index]).collect(Collectors.toList());
	}

}
