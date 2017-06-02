package files_and_exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Lab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		oddLines("input.txt", "output.txt");
//		lineNumbers("input.txt", "output1.txt");
//		wordCount("input.txt", "output1.txt", "words.txt");
//		mergeFiles("input1.txt", "input2.txt", "output.txt");
		try {
			folderSize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void oddLines(String input, String output) {

		List<String> lines = null;

		try {
			lines = Files.readAllLines(Paths.get(input));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
			for (int i = 0; i < lines.size(); i++) {
				if (i % 2 != 0) {
					writer.write(lines.get(i));
					writer.newLine();
				}
			}
		} catch (IOException ex) {
			// Handle me
		}
	}

	public static void lineNumbers(String input, String output) {

		List<String> lines = null;

		try {
			lines = Files.readAllLines(Paths.get(input));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
			for (int i = 0; i < lines.size(); i++) {
				writer.write(String.format("%d. %s%n", i + 1, lines.get(i)));				

			}
		} catch (IOException ex) {
			// Handle me
		}
	}
	
	public static void wordCount(String input, String output, String words){
		String regex = "\\W+";
		String[] line = null;
		String[] content = null;		
		
		try {
			line = new String(Files.readAllBytes(Paths.get(words))).split(regex);
			content =  new String(Files.readAllBytes(Paths.get(input))).split(regex);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < line.length; i++) {
			map.put(line[i], 0);
		}
		
		for (int i = 0; i < content.length; i++) {			
			map.computeIfPresent(content[i].toLowerCase(), (k, v) -> v + 1);
		}
		
		System.out.println(map);
		
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
			map.entrySet().stream()
			.sorted((me1, me2) -> me2.getValue() - me1.getValue())
			.forEach(me ->{
				try {
					writer.write(String.format("%s - %d%n", me.getKey(), me.getValue()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException ex) {
			// Handle me
		}
	}
	
	public static void mergeFiles(String input1, String input2, String output){
		
		
		try(BufferedReader in1  = new BufferedReader(new FileReader(input1));
				BufferedReader in2  = new BufferedReader(new FileReader(input2));) {
			try (BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
				String line = in1.readLine();
				while(line != null){
					writer.write(line);
					writer.newLine();
					line = in2.readLine();
					writer.write(line);
					writer.newLine();
					line = in1.readLine();
				}
			} catch (IOException ex) {
				// Handle me
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void folderSize() throws IOException{
		List<File> filesInFolder = Files.walk(Paths.get("C:\\Users\\Ivaylo\\Downloads"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
		long size = 0;
		for (File file : filesInFolder) {
			size += file.length();
		}
		
		System.out.println(size / 1000000);
	}

}
