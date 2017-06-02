package lists;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListManipulatorOptimizacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<String> nums = readArray(sc.nextLine());
		String commandLine = sc.nextLine();
		while (!commandLine.equals("print")) {
			executeCommand(nums, commandLine);
			commandLine = sc.nextLine();
		}
		System.out.println(nums);
		sc.close();
	}

	private static void executeCommand(List<String> nums, String commandLine) {
		// TODO Auto-generated method stub
		String[] line = commandLine.trim().split(" ");
		String command = line[0];
		int index = 0;
		if(line.length > 1){
			index = Integer.parseInt(line[1]);
		}		
		

		switch (command) {
			case "add": nums.add(index, line[2]);;				
				break;
				
			case "addMany": {
				int tmp = index;
				for (int i = 2; i < line.length; i++) {
					nums.add(tmp, line[i]);
					tmp ++;
				}
								
			}
				break;
			case "contains": System.out.println(nums.indexOf(line[1]));;
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
					BigDecimal num = new BigDecimal(nums.get(i));
					nums.set(i, num.add(new BigDecimal(nums.remove(i + 1))).toString());
				}
			}
				break;
				
			default:
				break;
		}
		
	}	
	
	
	private static List<String> readArray(String line){
		String[] strArray = line.trim().split(" ");
		return new LinkedList<>(Arrays.asList(strArray));
					
	}

}
