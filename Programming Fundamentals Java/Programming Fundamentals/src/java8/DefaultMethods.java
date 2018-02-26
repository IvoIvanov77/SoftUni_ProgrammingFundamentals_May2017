package java8;

public class DefaultMethods {

	public static void main(String[] args) {

	}

	public interface vehicle {
		default void print() {
			System.out.println("I am a vehicle!");
		}
	}

	public interface fourWheeler {
		default void print() {
			System.out.println("I am a four wheeler!");
		}
	}
	
	public class car implements vehicle, fourWheeler {

		@Override
		public void print() {
			// TODO Auto-generated method stub
			vehicle.super.print();
		}
		
	}

}
