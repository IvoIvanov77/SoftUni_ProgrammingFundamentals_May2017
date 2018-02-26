package methods;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		fibonacci(sc);
//		isPrime(sc);
//		primesInGivenRange(sc);
//		centerPoint(sc);
//		longerLine(sc);
		

	}
	
	public static void fibonacci(Scanner sc){
		System.out.println(fib(Integer.parseInt(sc.nextLine())));
	}
	
//	helper
	private static long fib(int n){	
		
		if(n == 0 || n == 1){
			return 1;
		}
		
		long a = 1;
		long b = 1;
		
		for(int i = 2; i <= n; i ++){
			long tmp = b;
			b += a;
			a = tmp;
		}
		
		return b;
	}
	
	public static void isPrime(Scanner sc){
		if(isPrime(Long.parseLong(sc.nextLine()))){
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
	}
//	helper
	private static boolean isPrime(long n){
		
		if(n == 2){
			return true;
		}
		
		if(n == 1 || n % 2 == 0){
			return false;
		}
		
		
		for (long i = 3; i * i <= n; i += 2) {
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void primesInGivenRange(Scanner sc){
		int start = Integer.parseInt(sc.nextLine());
		int end = Integer.parseInt(sc.nextLine());
		List<Integer> list = printPrimesInGivenRange(start, end);
		for (int i = 0; i < list.size() - 1; i ++) {
			int integer = list.get(i);
			System.out.print(integer + ", ");
		}
		System.out.println(list.get(list.size() -1));
	}
	
	private static List<Integer> printPrimesInGivenRange(int start, int end){
		List<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if(isPrime(i)){
				list.add(i);
			}
		}
		return list;
	}
	
	public static void centerPoint(Scanner sc){
		double x1 = Double.parseDouble(sc.nextLine());
		double y1 = Double.parseDouble(sc.nextLine());		
		Point p1 = new Point(x1, y1);
		double x2 = Double.parseDouble(sc.nextLine());
		double y2 = Double.parseDouble(sc.nextLine());
		Point p2 = new Point(x2, y2);		
		if(p1.compareTo(p2) < 0){
			System.out.print(p1);
		}else{
			System.out.print(p2);
		}
	}
	
	public static void longerLine(Scanner sc){
		double x1 = Double.parseDouble(sc.nextLine());
		double y1 = Double.parseDouble(sc.nextLine());	
		Point p1 = new Point(x1, y1);
		double x2 = Double.parseDouble(sc.nextLine());
		double y2 = Double.parseDouble(sc.nextLine());	
		Point p2 = new Point(x2, y2);	
		double x3 = Double.parseDouble(sc.nextLine());
		double y3 = Double.parseDouble(sc.nextLine());	
		Point p3 = new Point(x3, y3);
		double x4 = Double.parseDouble(sc.nextLine());
		double y4 = Double.parseDouble(sc.nextLine());	
		Point p4 = new Point(x4, y4);	
		if(getLineLenght(p1, p2) >= getLineLenght(p3, p4)){
			printClosestPoint(p1, p2);
		}else{
			printClosestPoint(p3, p4);
		}
	}
	
	private static double getLineLenght(Point p1, Point p2){
		return p1.distance(p2);
	}
	
	private static void printClosestPoint(Point p1, Point p2){
		Point center = new Point(0, 0);
		if(p1.distance(center) <= p2.distance(center)){
			System.out.print(p1);
			System.out.print(p2);
		}else{
			System.out.print(p2);
			System.out.print(p1);
		}
	}
	
	private static class Point implements Comparable<Point> {
		double x;
		double y;
		
		
		
		public Point(double x, double y) {			
			this.x = x;
			this.y = y;
		}



		double distance(Point p){
			return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
		}



		@Override
		public int compareTo(Point p) {
			// TODO Auto-generated method stub
			Point center = new Point(0, 0);
			return (int)((this.distance(center) - p.distance(center))*100) ;
		}



		@Override
		public String toString() {
			return "(" + formatNumber(x, "#.########") + ", " + formatNumber(y, "#.########") + ")";
			
		}	
		
		public static String formatNumber(Number n, String s) {
			return new DecimalFormat(s).format(n);
		}
		
		
	}
	

}
