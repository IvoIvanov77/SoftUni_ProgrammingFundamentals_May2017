package object_and_classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MentorGroupOpt {
	
	private static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static Map<String, Student> students = new TreeMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		readStudents(sc);		
		formatInput();
	}
	
	public static void readStudents(Scanner sc){	
		String line = sc.nextLine();
		while(!line.equals("end of dates")){
			String[] input = line.split(" ");
			
			Student student = null;
			if(students.containsKey(input[0])){
				student = students.get(input[0]);
			}else {
				student = new Student(input[0]);
			}
			
			if(input.length > 1){
				readDate(input[1], student);
			}
			
			students.put(student.getName(), student);
			line = sc.nextLine();
		}
		
		line = sc.nextLine();
		
		while(!line.equals("end of comments")){
			String[] input = line.split("-");
			readComents(input[0], input[1]);
			line = sc.nextLine();
		}		
	}	
	

	private static void readComents(String name, String coment) {
		// TODO Auto-generated method stub
		if(students.containsKey(name)){
			students.get(name).addComent(coment);
		}
	}

	private static void readDate(String line, Student student){
		String[] input = line.split(",");			
		for (String string : input) {
			Date date = null;
			try {
				date = df.parse(string);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			student.addDate(date);
		}
	}
	
	
	private static void formatInput(){		
		students.entrySet().forEach(st -> {
			System.out.println(st.getKey());
			System.out.println("Comments:");
			st.getValue().getComents().forEach(c -> {
				System.out.printf("- %s%n", c);
			});
			System.out.println("Dates attended: ");
			st.getValue().getDates().forEach(d -> {
				System.out.printf("-- %s%n", df.format(d));
			});
		} );

	}
	
	
	static class Student{
		private String name;
		private List<Date> dates;
		private List<String> coments;
		
		public Student(String name) {		
			this.name = name;
			this.dates = new ArrayList<>();
			this.coments = new LinkedList<>();
		}
		
		public void addDate(Date date){
			this.dates.add(date);
		}
		
		public void addComent(String coment){
			this.coments.add(coment);
		}

		public String getName() {
			return name;
		}

		public List<Date> getDates() {
			Collections.sort(this.dates);
			return this.dates;
		}

		public List<String> getComents() {
			return coments;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", dates=" + dates + ", coments=" + coments + "]";
		}	
		
	}		

}



	
	
