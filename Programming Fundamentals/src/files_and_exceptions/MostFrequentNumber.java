package files_and_exceptions;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MostFrequentNumber {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String[] content = new String(Files.readAllBytes(Paths.get("input.txt"))).split(" ");
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));
		writer.write(mostFrequent(content));
		writer.close();
	}
	
	public static String mostFrequent(String[] arr){
		String result = "";
		int occurance = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i].equals(arr[j])){
					count ++;
				}
				if(count > occurance){
					occurance = count;
					result = arr[i];
				}
			}
		}
		return result;
	}

}
