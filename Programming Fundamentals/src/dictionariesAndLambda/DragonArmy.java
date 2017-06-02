package dictionariesAndLambda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DragonArmy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		int count = 0;
		Map<String, Set<Dragon>> map = new LinkedHashMap<>();

		while (count < n) {
			String line = sc.nextLine();
			String[] input = line.split(" ");
			Dragon dragon = new Dragon(input);			
			String type = dragon.getType();
			if (map.containsKey(type)) {
				map.get(type).remove(dragon);
				map.get(type).add(dragon);
			} else {
				Set<Dragon> dragons = new TreeSet<>();
				dragons.add(dragon);
				map.put(type, dragons);
			}

			count ++;
		}

		formatOutput(map);
		sc.close();

	}
	
	private static void formatOutput(Map<String, Set<Dragon>> map) {

		map.entrySet().forEach(type -> {
			Stats stats = new Stats(type.getValue());
			System.out.printf("%s::(%.2f/%.2f/%.2f)%n",
					type.getKey(), stats.getAverageDamage(), stats.getAverageHealt(), stats.getAverageArmor());
			
			type.getValue().forEach(dragon -> {
				System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", 
						dragon.getName(), dragon.getDamage(), dragon.getHealt(), dragon.getArmor());
			});
		});

	}
	
	private static class Stats{
//		private Set<Dragon> dragons;
		int count = 0;
		private double totalDamage = 0;
		private double totalHealt = 0;
		private double totalArmor = 0;
		
		public Stats(Set<Dragon> dragons) {			
			dragons.forEach(dragon ->{
				this.totalDamage += dragon.getDamage();
				this.totalHealt += dragon.getHealt();
				this.totalArmor += dragon.getArmor();
				count ++;
			});
		}		

		public double getAverageDamage() {			
			return this.totalDamage / this.count;
		}

		public double getAverageHealt() {			
			return this.totalHealt / this.count;
		}

		public double getAverageArmor() {			
			return this.totalArmor / this.count;
		}
		
		
				
		
	}
	
	
	static class Dragon implements Comparable<Dragon>{

		String type;
		String name;
		int damage;
		int healt;
		int armor;		
		
		public Dragon(String[] input) {			
			this.type = input[0];
			this.name = input[1];
			this.damage = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
			this.healt = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
			this.armor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);
		}
		public String getType() {
			return type;
		}
		
		public String getName() {
			return name;
		}
		
		public int getDamage() {
			return damage;
		}
		
		public int getHealt() {
			return healt;
		}
		
		public int getArmor() {
			return armor;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;			
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dragon other = (Dragon) obj;
			
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		
		@Override
		public int compareTo(Dragon o) {
			// TODO Auto-generated method stub
			return this.name.compareTo(o.name);
		}
		@Override
		public String toString() {
			return "Dragon [type=" + type + ", name=" + name + ", damage=" + damage + ", healt=" + healt + ", armor="
					+ armor + "]";
		}		
		 
		
	}

}
