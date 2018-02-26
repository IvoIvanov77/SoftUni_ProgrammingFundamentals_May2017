package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = new String[1000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = "100";
		}
		
		Integer[] intArr = new Integer[array.length];
		
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = Integer.parseInt(array[i]);
		}
		List<Integer> list = new ArrayList<>(Arrays.asList(intArr));
		
		for (int i = 0; i < list.size(); i++) {
			list.remove(0);
		}

	}

}
