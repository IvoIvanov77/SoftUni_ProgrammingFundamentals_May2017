package object_and_classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CountWorkingDays {
	
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
			if (day != 1 && day != 7 && !isHolliday(cal)) {
				count++;
			}

			cal.add(Calendar.DATE, 1);

		}
		System.out.println(count);

	}

	private static boolean isHolliday(Calendar cal) throws ParseException {
		List<Date> list = new ArrayList<>();
		DateFormat df = new SimpleDateFormat("dd-MM");
		list.add(df.parse("01-01"));
		list.add(df.parse("03-03"));
		list.add(df.parse("01-05"));
		list.add(df.parse("06-05"));
		list.add(df.parse("24-05"));
		list.add(df.parse("06-09"));
		list.add(df.parse("22-09"));
		list.add(df.parse("01-11"));
		list.add(df.parse("24-12"));
		list.add(df.parse("25-12"));
		list.add(df.parse("26-12"));
		for (Date date : list) {
			if(df.format(date).equals(df.format(cal.getTime()))){
				return true;
			}
		}		

		return false;
	}

}
