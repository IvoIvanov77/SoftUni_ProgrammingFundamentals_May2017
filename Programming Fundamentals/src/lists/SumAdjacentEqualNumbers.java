package lists; 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] array = sc.nextLine().trim().split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(array));
		for (int i = 1; i < list.size(); i++) {
			if(i > 0){
				if(list.get(i).equals(list.get(i - 1))){
//					System.out.println(i);
					list.set(i, sumOfTwoElements(list, i, i -1));
					list.remove( --i);
					i --;
					
				}
			}
		}
		System.out.println(list);
		
		sc.close();
	}
	
	private static String sumOfTwoElements(List<String> list, int index1, int index2){
		BigDecimal number1 = new BigDecimal(list.get(index1));
		BigDecimal number2 = new BigDecimal(list.get(index2));
		return number1.add(number2).toString();
	}

}
