package exam_preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HornetComm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		List<PrivateMessage> messages= new ArrayList<>();		
		List<Broadcast> broadcasts= new ArrayList<>();
		
		while (!line.equals("Hornet is Green")) {
			String[] input = line.split(" <-> ");
//			System.out.println(Arrays.toString(input));
			if(isPrivateMessage(input)){
				PrivateMessage message = new PrivateMessage(reverse(input[0]), input[1]);
				messages.add(message);
			}else if(isBroadcast(input)){
				Broadcast broadcast = new Broadcast(input[0], changeCase(input[1]));
				broadcasts.add(broadcast);
			}
			line = sc.nextLine();
		}
		System.out.println("Broadcasts:");
		printList(broadcasts);
		System.out.println("Messages:");
		printList(messages);
		
		sc.close();

	}
	
	public static void printList(List<?> list){
		
		if(list.isEmpty()){
			System.out.println("None");
			return;
		}
		
		for (Object object : list) {
			System.out.println(object);
		}
		
	}
	
	public static boolean isPrivateMessage(String[] arr){		
		return arr.length == 2 
				&& arr[0].matches("\\d+") 
				&& arr[1].matches("[a-zA-Z0-9]+");
	}
	
	public static boolean isBroadcast(String[] arr){
		return arr.length == 2 
				&& arr[0].matches("\\D+") 
				&& arr[1].matches("[a-zA-Z0-9]+");
	}
	
	public static String changeCase(String str){
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!Character.isLetter(ch)){
				b.append(ch);
			}else{
				b.append(Character.isUpperCase(ch) ? Character.toLowerCase(ch) :  Character.toUpperCase(ch));
			}			
		}		
		return b.toString();
	}
	
	public static String reverse(String str){
		StringBuilder b = new StringBuilder(str);		
		return b.reverse().toString();
	}
	
	
	static class PrivateMessage{
		String recipientCode;
		String mesage;
		
		public PrivateMessage(String recipientCode, String mesage) {			
			this.recipientCode = recipientCode;
			this.mesage = mesage;
		}

		@Override
		public String toString() {
			return String.format("%s -> %s", this.recipientCode, this.mesage);
		}	
		
	}
	
	static class Broadcast{		
		String mesage;
		String frequency;		

		public Broadcast(String mesage, String frequency) {
			super();
			this.mesage = mesage;
			this.frequency = frequency;
		}

		@Override
		public String toString() {
			return String.format("%s -> %s", this.frequency, this.mesage);
		}	
		
	}

}
