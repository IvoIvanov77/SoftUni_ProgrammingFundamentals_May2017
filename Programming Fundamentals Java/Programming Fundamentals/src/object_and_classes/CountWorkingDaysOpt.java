package object_and_classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountWorkingDaysOpt {
	
	static DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		Date start = df.parse(sc.nextLine());
		Date end = df.parse(sc.nextLine());
		sc.close();
		
		Calendar cal = Calendar.getInstance();		
		cal.setTime(start);

		int count = 0;

		while (!cal.getTime().after(end)) {

			int day = cal.get(Calendar.DAY_OF_WEEK);
			if (day != 1 && day != 7 && !isHolliday(cal.getTime())) {
				count++;
			}

			cal.add(Calendar.DATE, 1);

		}
		System.out.println(count);

	}

	private static boolean isHolliday(Date date) throws ParseException {
		Set<String> list = new HashSet<>();
		DateFormat df = new SimpleDateFormat("dd-MM");
		list.add("01-01");
		list.add("03-03");
		list.add("01-05");
		list.add("06-05");
		list.add("24-05");
		list.add("06-09");
		list.add("22-09");
		list.add("01-11");
		list.add("24-12");
		list.add("25-12");
		list.add("26-12");			

		return list.contains(df.format(date));
	}

}
