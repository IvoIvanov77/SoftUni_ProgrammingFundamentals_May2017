package files_and_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class MaxSequenceOfEqualElements {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String line = new String(Files.readAllBytes(Paths.get("input.txt")));
		
		int[] array = readArray(line);
		
		System.out.println(maxSeq(array));
		
		Files.write(Paths.get("outputh.txt"), maxSeq(array).getBytes());
	}



	private static String maxSeq(int[] array) {
		int bestStart = 0;
		int bestEnd = 0;
		int bestCount = 0;
		
		for (int i = 1; i < array.length; i++) {
			int startIndex = i - 1;
			int curentIndex = i - 1;
			int count = 0;
			while(curentIndex < array.length && array[curentIndex] == array[startIndex] ){
				count ++;				
				curentIndex ++;
			}
//			System.out.println(count);
			if(count > bestCount){
				bestCount = count;
				bestStart = startIndex;
				bestEnd = curentIndex;
			}
			i = curentIndex;
		}
		return getArray(array, bestStart , bestEnd);
	}
	
	
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}
	
	private static String getArray(int[] array, int start, int end){
		int[] result = new int[end - start];
		int index = 0;
		for (int i = start; i < end; i++) {
			result[index ++] = array[i];
		}
		return Arrays.toString(result).replaceAll("[\\[\\],]", "");	
	}


}


