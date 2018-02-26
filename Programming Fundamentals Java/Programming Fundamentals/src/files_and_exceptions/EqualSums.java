package files_and_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EqualSums {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line = new String(Files.readAllBytes(Paths.get("input.txt")));
		
		Files.write(Paths.get("outputh.txt"), getOutput(line).getBytes(), StandardOpenOption.CREATE);
		
	}
	
	private static String getOutput(String numbers){
		int[] array = readArray(numbers);
		for (int i = 0; i < array.length; i++) {			
			if(leftSum(array, i) == rightSum(array, i)){				
				return "" + i;
			}
		}
		return "no";
	}
	
	private static int leftSum(int[]array, int index){
		int sum = 0;
		for (int i = 0; i < index; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	private static int rightSum(int[]array, int index){
		int sum = 0;
		for (int i = array.length - 1; i > index; i--) {
			sum += array[i];
		}
		return sum;
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}


}
