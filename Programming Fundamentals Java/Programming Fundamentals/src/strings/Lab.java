package strings;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		System.out.println(reverseString(sc.nextLine()));
		System.out.println(countSubstringOccurrences(sc.nextLine(), sc.nextLine()));
//		System.out.println(textFilter(sc.nextLine(), sc.nextLine(), '*'));
//		System.out.println(palindromes(sc.nextLine()));
		
		sc.close();

	}
	
	public static String reverseString(String string){
		StringBuilder b = new StringBuilder(string.length());
		
		for (int i = string.length() -1; i >= 0; i--) {
			b.append(string.charAt(i));
		}
		
		return b.toString();
	}
	
	public static int countSubstringOccurrences(String line, String substr){
		int count = 0;
		for (int i = 0; i <= line.length() - substr.length(); i++) {			
			String subString = line.substring(i, i + substr.length());
			if(substr.toLowerCase().equals(subString.toLowerCase())){
				count ++;
			}
		}
		return count;
	}
	
	public static String textFilter(String bannedWords, String text, char ch){
		String[] bannedWordsArray = bannedWords.split(", ");
		String result = text;
		for (String string : bannedWordsArray) {
			result = result.replaceAll(string, createString(string.length(), ch));
		}
		
		return result;
	}
	
	private static String createString(int len, char ch){
		char[] arr = new char[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ch;
		}
		return new String(arr);
	}
	
	public static String palindromes(String line){
		String[] words = line.trim().split("[\\s,.!?]");
		Set<String> palindromes = new TreeSet<>(new LikeCShaprStringComparator());
		for (String string : words) {
			if(string.equals(reverseString(string)) && !string.isEmpty()){
				palindromes.add(string);
			}
		}
		
		return palindromes.toString().replaceAll("[\\[\\]]", "");
		
	}
}
class LikeCShaprStringComparator implements Comparator<String> {

	@Override
	public int compare(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareToIgnoreCase(y) == 0 ? -x.compareTo(y) : x.compareToIgnoreCase(y);
		
	}

}