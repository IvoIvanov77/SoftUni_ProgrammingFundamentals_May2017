package object_and_classes;

import java.util.Scanner;

public class IntersectionOfCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Circle c1 = Circle.readCircle(sc.nextLine());
		Circle c2 = Circle.readCircle(sc.nextLine());
		if(c1.hasIntersection(c2)){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		sc.close();
	}
	
	private static class Circle {
		Point center;
		int radius;
		
		public Circle(Point center, int radius) {
			
			this.center = center;
			this.radius = radius;
		}
		
		public static Circle readCircle(String line) {
			String[] input = line.split(" ");
			Point center = new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			return new Circle(center, Integer.parseInt(input[2]));
		}
		
		public boolean hasIntersection(Circle other){
			return this.center.distanceTo(other.center) <= this.radius + other.radius;
		}
		
		
		
	}
	
	private static class Point {
		int x;
		int y;		
		
		public Point(int x, int y) {
			
			this.x = x;
			this.y = y;
		}



		public double distanceTo(Point p){
			return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
		}
	}

}
