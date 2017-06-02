package files_and_exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class IndexOfLetters {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader reader  = new BufferedReader(new FileReader("input.txt"));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8));
		
		int r; 		
		while ((r = reader.read()) != -1) {
			
            char ch = (char)r;
            int index = r - 'a';
            writer.write(String.format("%c -> %d%n", ch, index));
        }
		
		reader.close();
		writer.close();

	}

}
