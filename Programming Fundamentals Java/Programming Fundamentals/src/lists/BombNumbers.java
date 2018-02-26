package lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] strArray = sc.nextLine().trim().split(" ");
		List<String> list = new ArrayList<>(Arrays.asList(strArray));
		String[] bomb = sc.nextLine().trim().split(" ");
		String bombNumber = bomb[0];
		int power = Integer.parseInt(bomb[1]);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(bombNumber)){
				bomb(list, i, power);
				i = 0;
			}
			
		}
		BigDecimal sum = new BigDecimal(0);
		for (String num : list) {
			sum = sum.add(new BigDecimal(num));
		}
		System.out.println(sum);
		sc.close();
	}	
	
	
	private static void bomb(List<?> list, int index, int power){
		
		int start = Math.max((index - power), 0);
		int end = Math.min((index + power), (list.size() - 1));
		for (int i = start; i <= end; i++) {
			list.remove(start);
		}
	}
	
	
	
	

}
