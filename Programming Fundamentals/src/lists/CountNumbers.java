package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountNumbers {

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
		int index = 0;
		while(index < numbers.size()){			
			int count = 1;
			while(index < numbers.size() - 1 && 
					numbers.get(index).equals(numbers.get(index + 1))){
				count ++;
				index ++;
			}
			System.out.println(numbers.get(index) + " -> " + count);
			index ++;
		}
		
		sc.close();

	}

}
