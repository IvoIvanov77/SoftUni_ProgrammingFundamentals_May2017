package exam_preparation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HornetArmada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<String, Legion> legions = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(" -> ");
			Legion legion = new Legion(input[0]);
			Soldier soldier = new Soldier(input[1]);
			String name = legion.name;
			if(legions.containsKey(name)){
				legions.get(name).addSoldier(soldier);
				if(legion.lastActivity > legions.get(name).lastActivity ){
					legions.get(name).lastActivity = legion.lastActivity ;
				}
			}else{
				legion.addSoldier(soldier);
				legions.put(name, legion);
			}			
		}
		sc.close();
//		System.out.println(legions);
		String[] commands = sc.nextLine().split("\\\\");		
		if(commands.length == 2){
			int activity = Integer.parseInt(commands[0]);
			String type = commands[1];
			List<Soldier> outputList = new ArrayList<>();
			
			legions.entrySet().stream().filter(me -> me.getValue().lastActivity < activity)					
			.forEach(me ->{
				outputList.add(me.getValue().soldiers.get(type));
			});
			
			outputList.stream().sorted((s1, s2) -> Long.compare(s2.count, s1.count))
			.forEach(s -> {
				System.out.printf("%s -> %d%n", s.legion.name, s.count);
				});			
		}else {			
			String type = commands[0];
			legions.entrySet().stream().filter(me -> me.getValue().soldiers.containsKey(type))
			.sorted((me1, me2) -> Long.compare(me2.getValue().lastActivity, me1.getValue().lastActivity))
			.forEach(me -> {
				System.out.printf("%d : %s%n", me.getValue().lastActivity, me.getKey());
				});
		}
	}

}

class Legion{
	
	String name;	
	long lastActivity;
	Map<String, Soldier> soldiers;
	
	public Legion(String line) {
		String[] input = line.split(" = ");		
		this.name = input[1];		
		this.lastActivity = Long.parseLong(input[0]);
		this.soldiers = new LinkedHashMap<>();
	}
	
	public void addSoldier(Soldier soldier){
		if(this.soldiers.containsKey(soldier.type)){
			this.soldiers.get(soldier.type).count += soldier.count;
		}else {
			this.soldiers.put(soldier.type, soldier);
			soldier.legion = this;
		}
	}
	
	

	@Override
	public String toString() {
		return "Legion [name=" + name + ", lastActivity=" + lastActivity + ", soldiers=" + soldiers + "]";
	}	
}

class Soldier{
	String type;
	Legion legion;
	long count;
	
	
	public Soldier(String line) {	
		String[] input = line.split(":");
		this.type = input[0];
		this.count = Integer.parseInt(input[1]);
	}


	@Override
	public String toString() {
		return "Soldier [type=" + type + ", count=" + count + "]";
	}
	
	
	
	
}

