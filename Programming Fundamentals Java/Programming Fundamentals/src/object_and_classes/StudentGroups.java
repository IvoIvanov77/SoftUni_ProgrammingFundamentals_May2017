package object_and_classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudentGroups {
	
	static DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		StudentGroupsController contr = new StudentGroupsController();
		while(!line.equals("End")){
			if(line.contains("=>")){
				Town town = contr.readTown(line);
				line = sc.nextLine();
				while(!line.contains("=>") && !line.equals("End")){
					Student student = contr.readStudent(line, df);
					town.students.add(student);
					line = sc.nextLine();
				}
				if(town.seatsCount > 0 && town.students.size() > 0){					
					contr.towns.add(town);
				}
			}
		}
		contr.populateGroups();
		contr.formatOutput();
		sc.close();
	}	

}

class StudentGroupsController {
	
	List<Town> towns;
	List<Group> groups;
	
	
	public StudentGroupsController() {
		this.towns = new ArrayList<>();
		this.groups = new ArrayList<>();
	}

	public Town readTown(String line) {
		String[] input = line.split(" => ");
		String name = input[0];
		int seatsCount = Integer.parseInt(input[1].split(" ")[0]);
		
		return new Town(name, seatsCount);
	}
	
	public Student readStudent(String line, DateFormat df) {
		String[] input = line.split("\\s*\\|\\s*");
//		System.out.println(Arrays.toString(input));
		String studentName = input[0];		
		String email = input[1];
		Date date = null;
		
		try {
			date = df.parse(input[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Student(studentName, email, date);
	}	
	
	
	public void populateGroups(){
		
		this.towns.stream().sorted()
		.forEach(town -> {	
			Collections.sort(town.students);			
			for (int i = 0; i < town.students.size(); i += town.seatsCount) {
				Group group = new Group(town);
				for (int j = i; j < town.seatsCount + i && j < town.students.size(); j++) {
					group.students.add(town.students.get(j));
				}
				this.groups.add(group);
			}
		});
	}
	
	public void formatOutput(){
		
		System.out.printf("Created %d groups in %d towns:%n", this.groups.size(), this.towns.size());
		
		this.groups.forEach(group ->{
			System.out.printf("%s => %s%n", group.town.name, group.students.toString().replaceAll("[\\[\\]]", ""));
		});
	}
}

class Student implements Comparable<Student> {	
	String name;
	String email;
	Date registrationDate;
	Comparator<String> comp;
	
	public Student(String name, String email, Date registrationDate) {		
		this.name = name;
		this.email = email;
		this.registrationDate = registrationDate;
		this.comp = new LikeCShaprStringComparatorLocal();
	}
	
	private Comparator<Student> customComparator(){
		
		Comparator<Student> comp = (s1, s2) -> s1.registrationDate.compareTo(s2.registrationDate);
		return  comp.thenComparing((s1, s2) -> this.comp.compare(s1.name, s2.name))
				.thenComparing((s1, s2) -> this.comp.compare(s1.email, s2.email));
	}	

	@Override
	public String toString() {
		return this.email;
	}

	@Override
	public int compareTo(Student other) {
		Comparator<Student> studentComp = customComparator();		
		return studentComp.compare(this, other);
	}		
}

class Town implements Comparable<Town>{
	String name;
	int seatsCount;
	List<Student> students;
	Comparator<String> comp;
	
	public Town(String name, int seatsCount) {		
		this.name = name;
		this.seatsCount = seatsCount;
		this.students = new ArrayList<>();
		this.comp = new LikeCShaprStringComparatorLocal();
	}	

	@Override
	public String toString() {
		return "Town [name=" + name + ", seatsCount=" + seatsCount + ", students=" + students + "]";
	}

	@Override
	public int compareTo(Town other) {
		// TODO Auto-generated method stub
		return this.comp.compare(this.name, other.name);   
	}	
	
	
}

class Group{
	Town town;
	List<Student> students;
	
	public Group(Town town) {		
		this.town = town;
		this.students = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Group [town=" + town + ", students=" + students + "]";
	}	
	
}

class LikeCShaprStringComparatorLocal implements Comparator<String> {

	@Override
	public int compare(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareToIgnoreCase(y) == 0 ? -x.compareTo(y) : x.compareToIgnoreCase(y);
		
	}

}
