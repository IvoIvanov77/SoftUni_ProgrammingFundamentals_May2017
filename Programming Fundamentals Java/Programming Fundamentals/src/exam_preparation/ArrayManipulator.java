package exam_preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		
		String line = sc.nextLine();
		
		while(!line.equals("end")){
			String[] input = line.split(" ");
			if(input[0].equals("exchange")){
				int index = Integer.parseInt(input[1]);
				if(index >= array.length || index < 0){
					System.out.println("Invalid index");
				}else{
					array = exchange(array, index);
				}
				
			}else if(input[0].equals("max") || input[0].equals("min")){
				switch (line) {
				case "max even": {
					int index = maxEven(array);
					if(index != -1){
						System.out.println(index);
					}else{
						System.out.println("No matches");
					}
				}					
					break;
					
				case "max odd": {
					int index = maxOdd(array);
					if(index != -1){
						System.out.println(index);
					}else{
						System.out.println("No matches");
					}
				}					
					break;
					
				case "min even": {
					int index = minEven(array);
					if(index != -1){
						System.out.println(index);
					}else{
						System.out.println("No matches");
					}
				}					
					break;
					
				case "min odd": {
					int index = minOdd(array);
					if(index != -1){
						System.out.println(index);
					}else{
						System.out.println("No matches");
					}
				}				
					break;				
				}
			}else if(input[0].equals("first")){
				int index = Integer.parseInt(input[1]);
				if(index > array.length){
					System.out.println("Invalid count");					
				}else{					
					switch (input[2]) {
					case "even":
						System.out.println(Arrays.toString(firstCountEven(array, index)));
						break;
					case "odd":
						System.out.println(Arrays.toString(firstCountOdd(array, index)));
						break;				
					}
				}
			}else if(input[0].equals("last")){
				int index = Integer.parseInt(input[1]);
				if(index > array.length){
					System.out.println("Invalid count");					
				}else{					
					switch (input[2]) {
					case "even":
						System.out.println(Arrays.toString(lastCountEven(array, index)));
						break;
					case "odd":
						System.out.println(Arrays.toString(lastCountOdd(array, index)));
						break;				
					}
				}
			}
			line = sc.nextLine();
		}
		System.out.println(Arrays.toString(array));
		sc.close();

	}

	static int[] exchange(int[]array, int index){
		List<Integer> list = new ArrayList<>();
		for (int i = index + 1; i < array.length; i++) {
			list.add(array[i]);
		}
		for (int i = 0; i <= index; i++) {
			list.add(array[i]);
		}
		return list.stream().mapToInt(i->i).toArray();
	}
	
	static int maxEven(int[]arr){
		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0){
				if(arr[i] >= max){
					max = arr[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	static int maxOdd(int[]arr){
		int index = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0){
				if(arr[i] >= max){
					max = arr[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	static int minEven(int[]arr){
		int index = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0){
				if(arr[i] <= min){
					min = arr[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	static int minOdd(int[]arr){
		int index = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0){
				if(arr[i] <= min){
					min = arr[i];
					index = i;
				}
			}
		}
		return index;
	}
	
	static int[] firstCountEven(int[]array, int count){
		return Arrays.stream(array).filter(n -> n % 2 == 0).limit(count).toArray();
	}
	
	static int[] firstCountOdd(int[]array, int count){
		return Arrays.stream(array).filter(n -> n % 2 != 0).limit(count).toArray();
	}
	
	static int[] lastCountEven(int[]array, int count){
		int[] even =  Arrays.stream(array).filter(n -> n % 2 == 0).toArray();
		long len = even.length - count;
		return len <= 0 ? even : Arrays.stream(even).skip(len).toArray();
	}
	
	static int[] lastCountOdd(int[]array, int count){
		int[] even =  Arrays.stream(array).filter(n -> n % 2 != 0).toArray();
		long len = even.length - count;
		return len <= 0 ? even : Arrays.stream(even).skip(len).toArray();
	}
}
