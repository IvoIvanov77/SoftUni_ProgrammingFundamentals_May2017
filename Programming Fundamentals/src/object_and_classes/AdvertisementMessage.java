package object_and_classes;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", 
				"Best product of its category.", "Exceptional product.", "I can’t live without this product."};
		
		String[] events = {"Now I feel good.", "I have succeeded with this product.", 
				"Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", 
				"Try it yourself, I am very satisfied.", "I feel great!"};
		
		String[] author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
		
		String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
		
		Random r = new Random();
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());		
		sc.close();
		
		for (int i = 0; i < n; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(phrases[r.nextInt(phrases.length)] + " ")
			.append(events[r.nextInt(events.length)] + " ")
			.append(author[r.nextInt(author.length)] + " - ")
			.append(cities[r.nextInt(cities.length)]);
			System.out.println(builder);
		}
	}

}
