package exam_preparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandInterpreter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		String[] arr = sc.nextLine().split("\\s+");
		


		String line = sc.nextLine();

		while (!line.equals("end")) {
//			System.out.println(line);
			String command = line.split("\\s+")[0];
			System.out.println(command);
			if(command.equals("reverse") || command.equals("sort")){
				Pattern p = Pattern.compile("[-]*\\d+");
				Matcher m = p.matcher(line);
				m.find();
				int start = Integer.parseInt(m.group());
				m.find();
				int end = Integer.parseInt(m.group());
				if(!isValid(arr, start, end)){
					System.out.println("Invalid input parameters.");
					line = sc.nextLine();
					continue;
				}
				switch (command) {
				case "reverse": reverse(arr, start, end); break;
				case "sort": sort(arr, start, end); break;					
				}
			}else{
				Pattern p = Pattern.compile("[-]*\\d+");
				Matcher m = p.matcher(line);
				m.find();
				int count = Integer.parseInt(m.group());
				if(command.equals("rollRight")){
					rollRight(arr, count);
				}else{
					rollRight(arr, arr.length - count % arr.length);
				}
				
			}
			
			line = sc.nextLine();
		}
		System.out.println(Arrays.toString(arr) + "hi");

	}
	
	public static void reverse(String[]arr, int from, int count){
		int index = from + count - 1;
		for (int i = from; i <= from + count/2 - 1; i++) {
			String tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
			index --;
		}
	}
	
	public static void sort(String[]arr, int from, int count){
		
		for (int i = from; i < from + count - 1; i++) {
			for (int j = i + 1; j < from + count; j++) {
				if(arr[i].compareTo(arr[j]) > 0){
					String tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}	
	
	public static void rollRight(String[]arr,int count){
		List<String> list = Arrays.asList(arr);
		Collections.rotate(list, count);
		
	}
	
	public static boolean isValid(String[]arr, int from, int count){
		return from >= 0 && from < arr.length 
				&& count >= from && from + count < arr.length;
	}

}
