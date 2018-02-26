package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().trim().split("\\|");
		List<String> result = new ArrayList<>();
		
		for (int i = array.length - 1; i >= 0; i--) {
			String[] tmp = array[i].trim().split(" ");
			for (String string : tmp) {
				if(!string.isEmpty()){
					result.add(string);
				}
			}
		}
		printList(result, 0, result.size());
		sc.close();
	}
	
	
	
	private static void printList(List<?> list, int start, int end){
		for (int i = start; i < end; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();		
	}

}
