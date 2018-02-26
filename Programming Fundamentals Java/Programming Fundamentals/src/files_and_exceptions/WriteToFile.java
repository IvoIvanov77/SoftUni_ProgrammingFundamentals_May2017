package files_and_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteToFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line = new String(Files.readAllBytes(Paths.get("sample_text.txt")));
		String result = line.replaceAll("[\\.,!?:]", "");
		
		System.out.println(result);
		Files.write(Paths.get("result.txt"), result.getBytes(), StandardOpenOption.CREATE);

	}

}
