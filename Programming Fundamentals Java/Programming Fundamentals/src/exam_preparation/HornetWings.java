package exam_preparation;

import java.util.Scanner;

public class HornetWings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int wingFlaps = Integer.parseInt(sc.nextLine());
		double distance = Double.parseDouble(sc.nextLine());
		long endurance = Long.parseLong(sc.nextLine());
		
		double totalDistance = wingFlaps * distance / 1000;
		long rest = wingFlaps / endurance * 5;
		long secondsPassed = wingFlaps / 100 + rest;
		
		System.out.printf("%.2f m.%n", totalDistance);
		System.out.printf("%d s.%n", secondsPassed);
		sc.close();
	}

}
