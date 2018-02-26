package exam_preparation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HornetAssault {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		List<Long> beehives = inputToList(sc.nextLine());
		List<Long> hornets = inputToList(sc.nextLine());		
		long power = getSum(hornets);		
		int index = 0;
		sc.close();
		while(index < beehives.size()){
			if(hornets.isEmpty()){
				break;
			}
			long beesCount = beehives.get(index);
			if(beesCount < power){
				beehives.remove(index);
			}else if(beesCount > power){
				beehives.set(index, beesCount - power);					
				power -= hornets.remove(0);
				index ++;
			}else {
				beehives.remove(index);
				power -= hornets.remove(0);
			}			
		}
		
		if(beehives.isEmpty()){
			System.out.println(hornets.toString().replaceAll("[\\[\\],]", ""));
		}else{
			System.out.println(beehives.toString().replaceAll("[\\[\\],]", ""));
		}
		
		
	}
	
	private static List<Long> inputToList(String input){
		List<Long> result = new LinkedList<>();
		String[] arr = input.split(" ");
		for (int i = 0; i < arr.length; i++) {
			result.add(Long.parseLong(arr[i]));
		}
		return result;
	}
	
	private static long getSum(List<Long> list){
		long sum = 0L;
		for (Long integer : list) {
			sum += integer;
		}
		return sum;
	}
	
	
	

}
