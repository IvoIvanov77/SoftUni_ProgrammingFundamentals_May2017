package methods;

import java.util.Scanner;

public class GeometryCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		String type = sc.nextLine();
		
		if(type.equals("triangle")){
			getTriangleArea(sc);
		}else if(type.equals("square")){
			getSquareArea(sc);
		}else if(type.equals("rectangle")){
			getRectanlegeArea(sc);
		}else {
			getCircleArea(sc);
		}
		sc.close();

	}

	private static void getCircleArea(Scanner sc) {
		// TODO Auto-generated method stub
		double r = Double.parseDouble(sc.nextLine());
		System.out.printf("%.2f %n", Math.PI*r*r);
	}

	private static void getRectanlegeArea(Scanner sc) {
		// TODO Auto-generated method stub
		double w = Double.parseDouble(sc.nextLine());
		double h = Double.parseDouble(sc.nextLine());
		System.out.printf("%.2f %n", w * h);
		
	}

	private static void getSquareArea(Scanner sc) {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(sc.nextLine());
		System.out.printf("%.2f %n", a * a);
		
	}

	private static void getTriangleArea(Scanner sc) {
		double s = Double.parseDouble(sc.nextLine());
		double h = Double.parseDouble(sc.nextLine());
		System.out.printf("%.2f %n",  s * h / 2);		
	}	

}
