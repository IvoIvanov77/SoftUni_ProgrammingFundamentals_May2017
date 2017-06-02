package data_types_and_variables;

import java.math.BigDecimal;
import java.util.Scanner;

public class Lab {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// centuriesToMinutes(sc);
		// circleArea(sc);
		// exactSumofRealNumbers(sc);
		// elevator(sc);
		 speciacNumbers(sc);
		// triplesOfLatinLetters(sc);
//		greeting(sc);
//		RefactorVolumeOfPyramid(sc);
	}

	public static void centuriesToMinutes(Scanner sc) {
		System.out.println("Centuries = ");
		int centuries = Integer.parseInt(sc.nextLine());
		int years = centuries * 100;
		int days = (int) (years * 365.2422);
		int hours = days * 24;
		int minute = hours * 60;
		System.out.printf("%d centuries = %d years = %d days = %d hours = %d minute", centuries, years, days, hours,
				minute);
	}

	public static void circleArea(Scanner sc) {

		double r = Double.parseDouble(sc.nextLine());

		System.out.printf("%.12f", Math.PI * r * r);
	}

	public static void exactSumofRealNumbers(Scanner sc) {
		BigDecimal result = new BigDecimal("0");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			result = result.add(new BigDecimal(sc.nextLine()));
		}
		System.out.println(result);
	}

	public static void elevator(Scanner sc) {
		double people = Integer.parseInt(sc.nextLine());
		int capacity = Integer.parseInt(sc.nextLine());

		System.out.println((int) Math.ceil(people / capacity));
	}

	public static void speciacNumbers(Scanner sc) {
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= n; i++) {
			int number = i;
			System.out.printf("%d -> ", number);
			int sum = 0;
			while (number != 0) {
				int digit = number % 10;
				sum += digit;
				number /= 10;
			}

			if (sum == 5 || sum == 7 || sum == 11) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}

	public static void triplesOfLatinLetters(Scanner sc) {
		int n = Integer.parseInt(sc.nextLine());

		for (char ch = 'a'; ch < 'a' + n; ch++) {
			for (char ch1 = 'a'; ch1 < 'a' + n; ch1++) {
				for (char ch2 = 'a'; ch2 < 'a' + n; ch2++) {
					System.out.println(ch + "" + ch1 + "" + ch2);
				}
			}
		}
	}

	public static void greeting(Scanner sc) {
		String firstName = sc.nextLine();
		String secondName = sc.nextLine();
		int age = Integer.parseInt(sc.nextLine());
		System.out.printf("Hello, %s %s. You are %d years old.", firstName, secondName, age);
	}

	public static void RefactorVolumeOfPyramid(Scanner sc){		
		System.out.print("Length: ");
		double lenght = Double.parseDouble(sc.nextLine());
		System.out.print("Width: ");
		double width = Double.parseDouble(sc.nextLine());
		System.out.print("Height: ");
		double height = Double.parseDouble(sc.nextLine());
		double volume = (lenght * width * height) / 3;
		System.out.printf("Pyramid Volume: %.2f", volume);
	}

}
