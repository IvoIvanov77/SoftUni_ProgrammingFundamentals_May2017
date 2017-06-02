package methods;

import java.util.Scanner;

public class CubeProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double side = Double.parseDouble(sc.nextLine());
		String prop = sc.nextLine();
		
		if(prop.equals("face")){
			System.out.printf("%.2f", getFaceDiagonals(side));
		}else if(prop.equals("space")){
			System.out.printf("%.2f", getSpaceDiagonals(side));
		}else if(prop.equals("volume")){
			System.out.printf("%.2f", getVolume(side));
		}else {
			System.out.printf("%.2f", getSurfaceArea(side));
		}
		sc.close();

	}
	
//	length of the face diagonals, space diagonals, volume and surface area (face, space, volume or area).
	
	
	
	public static double getFaceDiagonals(double side){
		return Math.sqrt(2 * Math.pow(side, 2));
	}
	
	public static double getSpaceDiagonals(double side){
		return Math.sqrt(3 * Math.pow(side, 2));
	}
	
	public static double getVolume(double side){
		return Math.pow(side, 3);
	}
	
	public static double getSurfaceArea(double side){
		return 6 * Math.pow(side, 2);
	}

}
