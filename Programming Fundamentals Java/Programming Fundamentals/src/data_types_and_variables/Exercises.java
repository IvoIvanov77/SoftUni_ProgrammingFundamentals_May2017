package data_types_and_variables;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		practiceIntegerNumbers();
//		convertHexaToDecimal(sc);
//		toBoolean(sc);
//		stringAndObject(sc);
//		centuriesToNanoseconds(sc);
//		convertSpeedUnits(sc);
//		printBoolean(comparingFloats(sc));
//		printChars(sc);
		theaPhotographer(sc);
		sc.close();
	}
	
	public static void practiceIntegerNumbers(){
		
		byte a = -100;
		short b = 128;
		int c = -3540;
		int d = 64876;
		long e = 2147483648L;
		int f = -1141583228;
		long h = -1223372036854775808L;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(h);
		
	}
	
	public static void convertHexaToDecimal(Scanner sc){
		  String st = sc.nextLine();
		  String hexa = st.substring(2);
		  int decimal = Integer.valueOf(hexa, 16);		  
		  System.out.println(decimal);
	}
	
	public static void toBoolean(Scanner sc){
		String bool = sc.nextLine();
		String result = Boolean.parseBoolean(bool) ? "Yes" : "No";
		System.out.println(result);
	}
	
	public static void stringAndObject(Scanner sc){
		String one = sc.nextLine();
		String two = sc.nextLine();
		Object obj = one + " " + two;
		String result = (String)obj;
		System.out.println(result);
	}
	
	public static void centuriesToNanoseconds(Scanner sc){		
		long centuries = Integer.parseInt(sc.nextLine());
		long years = centuries * 100;
		long days = (int) (years * 365.2422);
		long hours = days * 24;
		long minute = hours * 60;
		long seconds = minute * 60;
		long milliseconds = seconds * 1000;
		long microseconds = milliseconds * 1000;
		BigDecimal nanoseconds = new BigDecimal(new Long(microseconds));
		nanoseconds = nanoseconds.multiply(new BigDecimal(1000));
//		long nanoseconds = microseconds * 1000;
		System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes = %d seconds = %d milliseconds = "
				+ "%d microseconds = %s nanoseconds", 
				centuries, years, days, hours, minute, seconds, milliseconds, microseconds, nanoseconds.toString());
		
		
	}
	
	public static void convertSpeedUnits(Scanner sc){
		float distance = Float.parseFloat(sc.nextLine());
		float hours = Float.parseFloat(sc.nextLine());
		float minutes = Float.parseFloat(sc.nextLine());
		float seconds = Float.parseFloat(sc.nextLine());
		float miles = distance / 1609;
		
		float totalSeconds = hours * 3600 + minutes * 60 + seconds;
		
		float metersPerSeconds = distance / totalSeconds;
		
		float kilometerPerHour = distance / 1000 / totalSeconds * 3600;
		
		float milesPerHour = miles / totalSeconds * 3600;
		
		System.out.println(formatNumber(metersPerSeconds, "##.#####"));
		System.out.println(formatNumber(kilometerPerHour, "##.#####"));
		System.out.println(formatNumber(milesPerHour, "##.#####"));
		
	}
	
	public static boolean comparingFloats(Scanner sc){
		float a = Float.parseFloat(sc.nextLine());
		float b = Float.parseFloat(sc.nextLine());
//		float eps = 0.000001f;
//		System.out.println(Math.abs(a - b));
		return Math.abs(a - b) < 9.536743E-7;
	}
	
	public static void printChars(Scanner sc){
		int start = Integer.parseInt(sc.nextLine());
		int end = Integer.parseInt(sc.nextLine());
		for(char ch = (char) start; ch <= end; ch ++){
			System.out.print(ch);
			System.out.print(" ");
		}
	}
	
	public static String formatNumber(Number n, String s) {
		return new DecimalFormat(s).format(n);
	}
	
	public static void printBoolean(boolean bool){
		if(bool){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
	}
	
	public static void theaPhotographer(Scanner sc){
		
		long amountOfPicture = Long.parseLong(sc.nextLine());
		long filterTime = Long.parseLong(sc.nextLine());
		long percentage = Long.parseLong(sc.nextLine());
		long uploadTime = Long.parseLong(sc.nextLine());
		float filterFactor = (float)(percentage) / 100;
//		System.out.println(filterFactor);
		long filteredPicture = (long)Math.ceil(amountOfPicture * filterFactor);
//		System.out.println(filteredPicture);
		long totalTime = filterTime * amountOfPicture + uploadTime * filteredPicture;
		System.out.println(formatSeconds(totalTime));
		
	}
	
	public static String formatSeconds(long totalSeconds){
		long days = (totalSeconds /86400);
		long rest = (int) (totalSeconds % 86400);
		long hours = rest / 3600;
		rest = rest % 3600;
		long minits = rest / 60;
		long seconds = rest % 60;
		return String.format("%d:%02d:%02d:%02d", days, hours, minits, seconds);
	}

}
