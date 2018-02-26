package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListManipulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = readList(sc.nextLine());
		String commandLine = sc.nextLine();
		while (!commandLine.equals("print")) {
			executeCommand(nums, commandLine);
			commandLine = sc.nextLine();
		}
		System.out.println(nums);
		sc.close();
	}

	private static void executeCommand(List<Integer> nums, String commandLine) {
		// TODO Auto-generated method stub
		String[] line = commandLine.trim().split(" ");
		String command = line[0];
		int index = 0;
		if(line.length > 1){
			index = Integer.parseInt(line[1]);
		}		
		List<Integer> items = new ArrayList<>();
		if(line.length > 2){			
			for(int i = 2; i < line.length; i ++){
				items.add(Integer.parseInt(line[i]));
			}
		}

		switch (command) {
			case "add": add(nums, index, items);				
				break;
				
			case "addMany": add(nums, index, items);				
				break;
			case "contains": System.out.println(nums.indexOf(index));
				break;
				
			case "remove": nums.remove(index);
				break;
				
			case "shift": {
				int shiftFactor = index % nums.size();
				for (int i = 0; i < shiftFactor; i++) {
					nums.add(nums.remove(0));				
				}
			}
				break;
				
			case "sumPairs": {
				for (int i = 0; i < nums.size() - 1; i++) {
					nums.set(i, (nums.get(i) + nums.remove(i + 1)));
				}
			}
				break;
				
			default:
				break;
		}
		

	}

	private static void add(List<Integer> list1, int index, List<Integer>list2){
		list1.addAll(index, list2);
	}
	
	private static List<Integer> readList(String sc){
		return new LinkedList<>(Arrays.asList(readArray(sc)));
	}
	
	private static Integer[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		Integer[] intArray = new Integer[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}

}
