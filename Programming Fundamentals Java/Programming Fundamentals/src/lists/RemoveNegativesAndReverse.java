package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> list = readList(sc.nextLine());
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) >= 0){
				result.add(list.get(i));
			}
		}
		if(result.isEmpty()){
			System.out.println("empty");
		}else{
			Collections.reverse(result);
			printList(result, 0, result.size());
		}
		sc.close();
	}
	
	private static List<Integer> readList(String sc){
		return new ArrayList<>(Arrays.asList(readArray(sc)));
	}
	
	private static Integer[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		Integer[] intArray = new Integer[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}
	
	private static void printList(List<Integer> list, int start, int end){
		for (int i = start; i < end; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();		
	}

}
