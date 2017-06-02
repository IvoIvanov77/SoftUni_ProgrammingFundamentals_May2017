package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
	
	public static void main(String[] args) {
		
		// for each
		
		List<String> list = new ArrayList<>();
		list.forEach(p -> p.length());
		
		// stream
			//filter
		Stream<String> stream = list.stream().filter(p -> p.length() > 5);
		List<String> result = stream.collect(Collectors.toList());
		System.out.println(result);
		
		List<Long> sourceLongList = Arrays.asList(1L, 10L, 50L, 80L, 100L, 120L, 133L, 333L);
		List<Long> targetLongList = new ArrayList<>();
		sourceLongList.stream().filter(l -> l > 100).forEach(targetLongList::add);
		System.out.println(targetLongList);
		
		List<Long> anotherList = sourceLongList.stream().filter(p -> p < 100).collect(Collectors.toList());
		System.out.println(anotherList);
		
		//Map
//		Stream<Student> map = persons.stream()
//		        .filter(p -> p.getAge() > 18)
//		        .map(person -> new Student(person));
//		
//		List<Student> students = persons.stream()
//		        .filter(p -> p.getAge() > 18)
//		        .map(Student::new)
//		        .collect(Collectors.toList());
//		
////		Parallel and Sequential Streams
//		
//		List<Student> students = persons.stream()
//		        .parallel()
//		        .filter(p -> p.getAge() > 18)  // filtering will be performed concurrently
//		        .sequential()
//		        .map(Student::new)
//		        .collect(Collectors.toCollection(ArrayList::new));
	}

}
