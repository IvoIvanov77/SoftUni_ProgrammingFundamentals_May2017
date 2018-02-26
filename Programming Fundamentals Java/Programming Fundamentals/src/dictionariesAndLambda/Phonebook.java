package dictionariesAndLambda;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
	
	static Map<String, String> phonebook = new TreeMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String commandLine = sc.nextLine();
		while(!commandLine.equals("END")){
			executeCommand(commandLine);
			commandLine = sc.nextLine();
		}
		sc.close();
	}
	
	private static void executeCommand(String commandLine) {
		// TODO Auto-generated method stub
		String[] line = commandLine.trim().split(" ");
		
		String command = line[0];
		String name = "";
		String phone = "";
		if(line.length > 1){
			name = line[1];
		}
		if(line.length > 2){
			phone = line[2];
		}
		
		if(command.equals("A")){
			phonebook.put(name, phone);
		}else if(command.equals("S")){
			if(phonebook.containsKey(name)){
				printContact(name, phonebook.get(name));
			}else{
				System.out.printf("Contact %s does not exist.%n", name);
			}			
		}else if(command.equals("ListAll")){
			printAll(phonebook);
		}		
//		System.out.println(phonebook);
		
	}

	private static void printContact(String name, String phone) {
		
		System.out.printf("%s -> %s%n", name, phone);
		
		
	}

	private static void printAll(Map<String, String> phonebook) {
		phonebook.entrySet().stream().forEach(me -> {
			System.out.printf("%s -> %s%n", me.getKey(), me.getValue());
		});
		
	}

}
