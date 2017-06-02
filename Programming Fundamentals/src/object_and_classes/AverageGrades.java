package object_and_classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AverageGrades {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			students.add(Student.readStudent(sc.nextLine()));
		}
		
	    Comparator<Student> comparator = (s1, s2) -> s1.name.compareTo(s2.name);

		students.stream().filter(s -> s.averageGrade >= 5)
		.sorted(comparator.thenComparing((s1, s2) ->
		Double.compare(s2.averageGrade, s1.averageGrade)))
		.forEach(s -> {
			System.out.println(s);
		});
		sc.close();
	}
	
	private static class Student{
		private String name;
		private double averageGrade;
		
		private Student(String name, List<Double> grades, double averageGrade) {
			super();
			this.name = name;
			this.averageGrade = averageGrade;
		}
		
		private static Student readStudent(String line){
			String[] input = line.split(" ");
			String name = input[0];
			List<Double> grades = new ArrayList<>();
			for (int i = 1; i < input.length; i++) {
				grades.add(Double.parseDouble(input[i]));
			}
			double averageGrade = getAverage(grades);
			return new Student(name, grades, averageGrade);
		}

		private static double getAverage(List<Double> list) {
			// TODO Auto-generated method stub					
			return list.stream()
		            .mapToDouble(Double::doubleValue)
		            .average().getAsDouble();
		}

		@Override
		public String toString() {
			return String.format("%s -> %.2f", name, averageGrade);
		}
		
		
		
		
	}

}
