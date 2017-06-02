package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] nums = readArray(sc.nextLine());
		sc.close();
		int[] len = new int[nums.length];
		for (int i = 0; i < len.length; i++) {
			len[i] = 1;
		}		
		
		int[] prev = new int[nums.length];		
		
		for (int i = 0; i < nums.length; i++) {
			int max = 0;
			int prevIndex = - 1;
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && len[j] > max){
					max = len[j];
					prevIndex = j;
				}				
			}
			len[i] += max;
			prev[i] = prevIndex;
		}
//		System.out.println(Arrays.toString(len));
//		System.out.println(Arrays.toString(prev));
		restoreLis(nums, len, prev);
	
	}
	
	private static void restoreLis(int[]nums, int[] len, int[] prev){
		int maxLenIndex = 0;
		int maxLenValue = 0;
		for (int i = 0; i < len.length; i++) {
			if(len[i] > maxLenValue){
				maxLenValue = len[i];
				maxLenIndex = i;
			}
		}
		List<Integer> maxSeq = new ArrayList<>();
		maxSeq.add(nums[maxLenIndex]);
		int prevIndex = prev[maxLenIndex];
		while(prevIndex != -1){
			maxSeq.add(nums[prevIndex]);
			prevIndex = prev[prevIndex];
		}
		Collections.reverse(maxSeq);
		System.out.println(maxSeq.toString().replaceAll("[\\[\\],]", ""));
		
	}
	
	private static int[] readArray(String numbers){
		String[] strArray = numbers.trim().split(" ");
		int[] intArray = new int[strArray.length];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;			
	}

}
