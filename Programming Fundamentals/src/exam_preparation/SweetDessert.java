package exam_preparation;

import java.util.Scanner;

public class SweetDessert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		double cash = Double.parseDouble(sc.nextLine());
		long guest = Integer.parseInt(sc.nextLine());
		float bananaPrice = Float.parseFloat(sc.nextLine());
		float eggsPrice = Float.parseFloat(sc.nextLine());
		float berriesPrice = Float.parseFloat(sc.nextLine());
		
		long portions = guest % 6 == 0 ? guest / 6 : (guest / 6) + 1;
		
		double neededBananas = portions * 2;
		double neededEggs = portions * 4;
		double neededBerries = portions * 0.2f;
		
		double totoalPrice = neededBananas * bananaPrice + neededEggs * eggsPrice + neededBerries * berriesPrice;
		
		if(totoalPrice <= cash){
			System.out.printf("Ivancho has enough money - it would cost %.2flv.%n", totoalPrice);
		}else{
			System.out.printf("Ivancho will have to withdraw money - he will need %.2flv more.%n",
					totoalPrice - cash);
		}
		sc.close();

	}

}
