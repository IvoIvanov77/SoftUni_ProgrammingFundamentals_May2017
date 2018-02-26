package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().trim().split(" ");
		List<BigDecimal> numbers = new ArrayList<>();
		for (String string : array) {
			if(!string.isEmpty()){				
				numbers.add(new BigDecimal(string));
			}
		}
		Collections.sort(numbers);
		printList(numbers);
		sc.close();
	}
	
	public static void printList(List<?> list){
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i < list.size() -1){
				System.out.print(" <= ");
			}
		}
	}
}
