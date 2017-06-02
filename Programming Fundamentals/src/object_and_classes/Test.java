package object_and_classes;

import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LikeCShaprStringComparator comp = new LikeCShaprStringComparator();
		Set<String> set = new TreeSet<>(comp);
		
		set.add("C");
		set.add("A");
		set.add("B");
		set.add("c");
		set.add("a");
		set.add("b");
		System.out.println(set);
		
		set.forEach(a -> {
			System.out.println(a);
		});

	}

}
