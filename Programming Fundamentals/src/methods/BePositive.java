package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BePositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int countSequences = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < countSequences; i++) {
			String[] input = sc.nextLine().trim().split(" ");
			List<Integer> numbers = new ArrayList<>();

			for (int j = 0; j < input.length; j++) {
				if (!input[j].isEmpty()) {
					int num = Integer.parseInt(input[j]);
					numbers.add(num);
				}
			}

			boolean found = false;

			for (int j = 0; j < numbers.size(); j++) {
				int currentNum = numbers.get(j);

				if (currentNum >= 0) {
					if (found) {
						System.out.print(" ");
					}

					System.out.print(currentNum);

					found = true;
				} else {
					if(j < numbers.size() - 1){
						currentNum += numbers.get(++ j);
						
						if (currentNum >= 0) {
							if (found) {
								System.out.print(" ");
							}

							System.out.print(currentNum);

							found = true;
						}
					}					
				}
			} 

			if (!found) {
				System.out.println("(empty)");
			}
			System.out.println();
		}

		sc.close();

	}

}
