package object_and_classes;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TeamworkProjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String line = sc.nextLine();
		TeamController controller = TeamController.getInstance();
		
		for (int i = 0; i < n; i++) {
			controller.readTeam(line);
			line = sc.nextLine();
		}
		
		while(!line.equals("end of assignment")){
			controller.readMember(line);
			line = sc.nextLine();
		}
		sc.close();
		controller.disband();
		formatOutput(controller.getTeams(), controller.getDisbandTeams());
	}
	
	private static void formatOutput(Map<String,Team> teams, Set<String> disbandTeams){
		
		teams.entrySet().stream()
		.sorted((me1, me2) -> me2.getValue().getMembersCount() - me1.getValue().getMembersCount())
		.forEach(me -> {
			System.out.println(me.getKey());
			System.out.println("- " + me.getValue().getCreator());
			me.getValue().getMembers().forEach(member -> {
				System.out.println("-- " + member);
			});
		});

		System.out.println("Teams to disband:"); 
		disbandTeams.forEach(teamName -> {
			System.out.println(teamName);
		});
	}

}

class TeamController {
	private Map<String,Team> teams;
	private Set<String> disbandTeams;
	

	private TeamController() {
		this.teams = new TreeMap<>();
		this.disbandTeams = new TreeSet<>
		((x, y) -> x.compareToIgnoreCase(y) == 0 ? -x.compareTo(y) : x.compareToIgnoreCase(y));
	}
	
	public static TeamController getInstance(){
		return new TeamController();
	}
	
	public void readTeam(String line){
		String[] input = line.split("-");
		Team team = new Team(input[1], input[0]);
		if(!teams.containsKey(team.getName())){
			teams.put(team.getName(), team);
			System.out.printf("Team %s has been created by %s!%n", team.getName(), team.getCreator());
		}else{
			System.out.printf("Team %s was already created!%n", team.getName());
		}
	}
	
	public void readMember(String line){		
		String[] input = line.split("->");
		String memberName = input[0];
		String teamName = input[1];
		if(!teams.containsKey(teamName)){
			System.out.printf("Team %s does not exist!%n", teamName);
		}else if(isMemmberOfTeam(memberName)) {
			System.out.printf("Member %s cannot join team %s!%n", memberName, teamName);
		}else {			
			this.teams.get(teamName).addMember(memberName);
		}
	}
	
	public void disband(){
		for (String teamName : this.teams.keySet()) {
			if(!this.teams.get(teamName).hasMembers()){
				this.disbandTeams.add(teamName);
			}
		}
		for (String team : disbandTeams) {
			teams.remove(team);
		}
	}

	private boolean isMemmberOfTeam(String memberName) {
		// TODO Auto-generated method stub		
		
		for (Team team: teams.values()) {
			if(team.getCreator().equals(memberName) || team.getMembers().contains(memberName)){
				return true;
			}
		}
		
		return false;
	}

	public Map<String, Team> getTeams() {
		return teams;
	}

	public Set<String> getDisbandTeams() {
		return disbandTeams;
	}
	
	
}


class Team {
	
	private String name;
	private String creator;
	private Set<String> members;
	
	public Team(String name, String creator) {		
		this.name = name;
		this.creator = creator;
		//sort strings like c#
		this.members = new TreeSet<>
		((x, y) -> x.compareToIgnoreCase(y) == 0 ? -x.compareTo(y) : x.compareToIgnoreCase(y));		
	}
	
	public boolean addMember(String name){
		return this.members.add(name);
	}
	
	public boolean hasMembers(){
		return getMembersCount() > 0;
	}

	public String getName() {
		return name;
	}

	public String getCreator() {
		return creator;
	}

	public Set<String> getMembers() {		
		return members;
	}
	
	public int getMembersCount(){	
		return this.members.size();
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", creator=" + creator + ", members=" + members + "]";
	}
	
	
	
	
}