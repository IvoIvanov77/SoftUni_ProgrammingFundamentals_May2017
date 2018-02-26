package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] nums = readArray(sc.nextLine());
		String commandLine = sc.nextLine();
		while (!commandLine.equals("print")) {
			nums = executeCommand(nums, commandLine);
			commandLine = sc.nextLine();
		}
		System.out.println(Arrays.toString(nums));
		sc.close();
	}

	private static int[] executeCommand(int[] nums, String commandLine) {
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
			case "add": return add(nums, index, items);				
				
			case "addMany": return add(nums, index, items);				
				
			case "contains": System.out.println(get(nums, index));;
				return nums;
				
			case "remove": return remove(nums, index);				
				
			case "shift": return shift(nums, index);				
				
			case "sumPairs": return sumPairs(nums);
				
			default:
				return nums;
		}
		

	}

	private static int[] sumPairs(int[] nums) {
		int[] tmp = new int[nums.length / 2 + nums.length % 2];
		int numsIndex = 0;
		for (int i = 0; i < tmp.length; i++) {
			if(numsIndex < nums.length - 1){				
				tmp[i] = nums[numsIndex] + nums[++ numsIndex];
			}else {
				tmp[i] = nums[numsIndex];
			}
		}
		
		return tmp;
	}

	private static int[] shift(int[] nums, int index) {
		for (int i = 0; i < index; i++) {
			shift(nums);
		}
		return nums;
	}
	
	//helper
	private static int[] shift(int[] nums) {
		// TODO Auto-generated method stub
		int lastIndex = nums.length - 1;
		int tmp = nums[0];
		for (int i = 0; i < lastIndex; i++) {			
			nums[i] = nums[i + 1];
		}
		nums[lastIndex] = tmp;
		return nums;
	}

	private static int[] remove(int[] nums, int index) {
		// TODO Auto-generated method stub
		int[] tmpArr = new int[nums.length - 1];
		int tmpIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i != index){
				tmpArr[tmpIndex] = nums[i];
				tmpIndex ++;
			}
		}
		return tmpArr;
	}

	private static int get(int[] nums, int index) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == index){
				return i;
			}
		}
		return -1;
	}

	private static int[] add(int[] nums, int index, List<Integer> items) {
		// TODO Auto-generated method stub
		int[] tmpArr = new int[nums.length + items.size()];
		int tmpIndex = 0;
		int numsIndex = 0;		
		while(tmpIndex < index){
			tmpArr[tmpIndex] = nums[numsIndex];
			tmpIndex ++;
			numsIndex ++;
		}
		for (int item : items) {
			tmpArr[tmpIndex] = item;
			tmpIndex ++;
		}
		
		while(tmpIndex < tmpArr.length){
			tmpArr[tmpIndex] = nums[numsIndex];
			tmpIndex ++;
			numsIndex ++;
		}
		return tmpArr;
	}
	
	

	private static int[] readArray(String numbers) {
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}

}
