package object_and_classes;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
//		dayOfWeek(sc);
//		randomizeWords(sc);
//		bigFactorial(sc);
//		distanceBetweenPoints(sc);
//		closestTwoPoints(sc);
//		rectanglePosition(sc);
		salesReport(sc);
	}
	
	public static void dayOfWeek(Scanner sc) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = df.parse(sc.nextLine());
		String weekday  = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
		System.out.println(weekday);
	}
	
	public static void randomizeWords(Scanner sc) {
		
		String[] words = sc.nextLine().split(" ");
		Random r = new Random();
		for (int i = 0; i < words.length; i++) {
			String tmp = words[i];
			int j = r.nextInt(words.length);
			words[i] = words[j];
			words[j] = tmp;
		}
		for (String string : words) {
			System.out.println(string);
		}
	}
	
	public static void bigFactorial(Scanner sc){
		BigDecimal result = new BigDecimal(1);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigDecimal.valueOf(i));
		}
		System.out.println(result);
	}
	
	public static void distanceBetweenPoints(Scanner sc){
		String[] line1 = sc.nextLine().split(" ");
		String[] line2 = sc.nextLine().split(" ");
		
		Point p1 = new Point(Integer.parseInt(line1[0]), Integer.parseInt(line1[1]));
		Point p2 = new Point(Integer.parseInt(line2[0]), Integer.parseInt(line2[1]));
		System.out.printf("%.3f", p1.distanceTo(p2));
	}
	
	public static void closestTwoPoints(Scanner sc){
		int n = Integer.parseInt(sc.nextLine());
		List<Point> points = new ArrayList<>();		
		double minDistance = Double.MAX_VALUE;
		Point firstP = null;
		Point secondP = null;
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			Point p = new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			if(!points.isEmpty()){
				Point closestPoint = p.closestPoint(points);
				if(p.distanceTo(closestPoint) < minDistance){
					minDistance = p.distanceTo(closestPoint);
					firstP = p;
					secondP = closestPoint;
				}				
			}
			points.add(p);			
		}
		System.out.printf("%.3f%n", minDistance);
		System.out.println(secondP);
		System.out.println(firstP);
		
	}
	
	public static void rectanglePosition(Scanner sc){
		Rectangle r1 = Rectangle.readRectangle(sc.nextLine());
		Rectangle r2 = Rectangle.readRectangle(sc.nextLine());
//		System.out.println(r1);
//		System.out.println(r2);
		if(r1.isInside(r2)){
			System.out.println("Inside");
		}else{
			System.out.println("Not inside");
		}
	}
	
	public static void salesReport(Scanner sc){
		
		int n = Integer.parseInt(sc.nextLine());		
		Map<String, Double> map = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			Sale sale = new Sale(sc.nextLine().split(" "));
			map.computeIfPresent(sale.town, (k, v) -> v + (sale.price * sale.quantity));
			map.computeIfAbsent(sale.town, v -> sale.price * sale.quantity);
		}
		map.entrySet().forEach(town -> {
				System.out.printf("%s -> %.2f%n", town.getKey(), town.getValue());
			});
		
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
		
		public Point closestPoint(List<Point> points){
			double minDistance = Double.MAX_VALUE;
			Point result = null;
			for (int i = 0; i < points.size(); i++) {
				if(this.distanceTo(points.get(i)) < minDistance){
					result = points.get(i);
					minDistance = this.distanceTo(points.get(i));
				}
			}
			return result;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}	
		
	}
	
	private static class Rectangle{
		private int top;
		private int left;
		private int right;
		private int bottom;
		
		public Rectangle(int top, int left, int width, int height) {				
			this.top = top;
			this.left = left;
			this.right = this.top + width;
			this.bottom = this.left + height;
		}

		public static Rectangle readRectangle(String line) {
			String[] input = line.split(" ");
			return new Rectangle(Integer.parseInt(input[0]), 
					Integer.parseInt(input[1]), 
					Integer.parseInt(input[2]), 
					Integer.parseInt(input[3]));
		}
		
		public boolean isInside(Rectangle r){			
			return this.bottom <= r.bottom &&
					this.left >= r.left &&
					this.right <= r.right &&
					this.top >= r.top;
			
		}

		@Override
		public String toString() {
			return "Rectangle [top=" + top + ", left=" + left + ", right=" + right + ", bottom=" + bottom + "]";
		}	
		
	}
	
	private static class Sale {
		
//		town, product, price, quantity
		private String town;
		private double price;
		private double quantity;
		
		public Sale(String town, String product, double price, double quantity) {			
			this.town = town;
			this.price = price;
			this.quantity = quantity;
		}

		public Sale(String[] input) {
			this(input[0],
					input[1], 
					Double.parseDouble(input[2]), 
					Double.parseDouble(input[3]));
		}		
		
	}

}
