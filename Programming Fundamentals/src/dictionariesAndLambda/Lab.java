package dictionariesAndLambda;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * Lab: Dictionaries, Lambda and LINQ.
 */
public class Lab {

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		countRealNumbers(sc);
//		oddOccurrences(sc);
//		sumMinMaxAverage(sc);
//		largest3Numbers(sc);
//		shortWordsSorted(sc);
		foldAndSum(sc);

	}
	
	
	/**
	 * Count real numbers.
	 * Read a list of real numbers and print them in ascending order along with their number of occurrences
	 * @param sc the sc
	 */
	public static void countRealNumbers(Scanner sc){
		String[] input = sc.nextLine().trim().split(" ");
//		System.out.println(Arrays.toString(input));
		List<String> numbers = Arrays.asList(input).stream().filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
//		System.out.println(numbers);
		SortedMap<BigDecimal, Integer> map = new TreeMap<>();
		for (String string : numbers) {
			BigDecimal num = new BigDecimal(string);
			map.computeIfPresent(num, (k, v) -> v + 1);
			map.computeIfAbsent(num, v -> new Integer(1));
			
		}
		map.forEach((k, v) -> System.out.printf("%s -> %d %n", k, v));		
				
	}
	
	
	
	/**
	 * Odd occurrences.
	 * 
	 * extracts from a given sequence of words all elements that present in it odd number of times (case-insensitive).
	 * 		•	Words are given in a single line, space separated.
	 * 		•	Print the result elements in lowercase, in their order of appearance.
	 *
	 * @param sc the sc
	 */
	public static void oddOccurrences(Scanner sc){
		List<String> words = Arrays.asList(sc.nextLine().toLowerCase().split(" ")).stream().filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
		Map<String, Integer> map = new LinkedHashMap<>();
		for (String string : words) {
			map.computeIfPresent(string, (k , v) -> v + 1);
			map.computeIfAbsent(string, v -> new Integer(1));
		}
//		System.out.println(map);
		List<String> strings = map.entrySet().stream().filter(set -> set.getValue() % 2 != 0)
				.map(set -> new String(set.getKey())).collect(Collectors.toList());
		System.out.println(strings.toString().replaceAll("[\\[\\]]", ""));	
				
	}
	
	
	
	/**
	 * Sum min max average.
	 *
	 * @param sc the sc
	 */
	public static void sumMinMaxAverage(Scanner sc){
		List<Integer> nums = new ArrayList<>();
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			nums.add(sc.nextInt());
		}
		
		IntSummaryStatistics stats = nums.stream().mapToInt(x -> x).summaryStatistics();
		System.out.printf("Sum = %d%n"
				+ "Min = %d%n"
				+ "Max = %d%n"
				+ "Average = %s", stats.getSum(), stats.getMin(), stats.getMax(),
				new DecimalFormat("#0.##").format(stats.getAverage()));
	}
	
	/**
	 * Largest 3 numbers.
	 *
	 * @param sc the sc
	 */
	public static void largest3Numbers(Scanner sc){
		List<BigDecimal> nums = Arrays.asList(sc.nextLine().toLowerCase().split(" "))
				.stream().filter(s -> !s.isEmpty())
				.map(s -> new BigDecimal(s))
				.sorted((bd1, bd2) -> bd2.compareTo(bd1))
				.limit(3)
				.collect(Collectors.toList());
				
//		System.out.println(nums);
		System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));		
		
	}
	public static void shortWordsSorted(Scanner sc){
		String regex = "[,;:.!()\"\'\\\\/\\[\\] ]";
		List<String> words = Arrays.asList(sc.nextLine().toLowerCase().split(regex))
				.stream().filter(s -> !s.isEmpty() && s.length() < 5)
				.sorted().distinct()
				.collect(Collectors.toList());
//		System.out.println(words);
		System.out.println(words.toString().replaceAll("[\\[\\]]", ""));
	}
	
	public static void foldAndSum(Scanner sc){
		List<Integer> words =  Arrays.asList(sc.nextLine().split(" ")).stream()
				.filter(s -> !s.isEmpty())
				.map(Integer::new)
				.collect(Collectors.toList());
		
		Stream<Integer> stream1 = words.stream()				
				.limit(words.size()/4)
				.sorted((a,b) -> -1);
		
		Stream<Integer> stream2 = words.stream()	
				.sorted((a,b) -> -1)
				.limit(words.size()/4);	
		
		Stream<Integer> stream3 = words.stream()	
				.skip(words.size()/4)
				.limit(words.size()/2);	
				
		List<Integer> row1 = Stream.concat(stream1, stream2)
				.collect(Collectors.toList());
		
		List<Integer> row2 = stream3
				.collect(Collectors.toList());		
		
		List<Integer> result = IntStream.range(0, row1.size())
				.boxed()
				.map(index -> row1.get(index) + row2.get(index))
				.collect(Collectors.toList());              
                
		System.out.println(result.toString().replaceAll("[\\[\\],]", ""));      
		
	}

}
