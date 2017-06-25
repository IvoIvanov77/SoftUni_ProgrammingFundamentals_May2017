package files_and_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class PunctuationFinder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String line = new String(Files.readAllBytes(Paths.get("sample_text.txt")));
		String result = line.replaceAll("[^\\.,!?:]", "");
		System.out.println(Arrays.toString(result.toCharArray()).replaceAll("[\\[\\]]", ""));

	}

}
