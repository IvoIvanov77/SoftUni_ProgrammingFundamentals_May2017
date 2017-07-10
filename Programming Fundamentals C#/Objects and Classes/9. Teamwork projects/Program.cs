using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _9.Teamwork_projects
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            SortedDictionary<string, Team> teams = new SortedDictionary<string, Team>();
            

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split('-');
                var teamName = input[1];
                var creatorName = input[0];
                if (teams.ContainsKey(teamName))
                {
                    Console.WriteLine($"Team {teamName} was already created!");
                }
                else if(teams.Values.Select(t => t.Creator).Contains(creatorName))
                {
                    Console.WriteLine($"{creatorName} cannot create another team!");
                }
                else
                {
                    Team team = new Team(teamName, creatorName);
                    teams[teamName] = team;
                    Console.WriteLine($"Team {teamName} has been created by {creatorName}!");
                }
            }

            PopulateTeams(teams);

            teams.Values.Where(team => team.HasMembers())
                .OrderByDescending(team => team.Users.Count)
                .ToList().ForEach(team => team.PrintTeam());

            Console.WriteLine("Teams to disband:");
            teams.Values.Where(team => !team.HasMembers())
                .ToList().ForEach(team => Console.WriteLine(team.Name));

        }

        static void PopulateTeams(SortedDictionary<string, Team> teams)
        {
            string line = Console.ReadLine();
            while (line != "end of assignment")
            {
                var input = Regex.Split(line, "->");
                var teamName = input[1];
                var user = input[0];
                if (!teams.ContainsKey(input[1]))
                {
                    Console.WriteLine($"Team {teamName} does not exist!");
                }
                else if (HasTeam(teams.Values.ToList(), user))
                {
                    Console.WriteLine($"Member {user} cannot join team {teamName}!");
                }
                else
                {
                    teams[teamName].AddUser(user);
                }
                line = Console.ReadLine();
            }
        }

        static bool HasTeam(List<Team> list, string user)
        {
            foreach(var team in list)
            {
                if (team.HasUser(user))
                {
                    return true;
                }
            }
            return false;
        }

    }

    class Team
    {
        
        public string Name { get; set; }
        public string Creator { get; set; }
        public List<String> Users { get; }

        public Team(string name, string creator)
        {
            Name = name;
            Creator = creator;
            Users = new List<string>();
        }

        public void AddUser(string user)
        {
            this.Users.Add(user);
        }

        public void PrintTeam()
        {
            Console.WriteLine($"{this.Name}");
            Console.WriteLine($"- {this.Creator}");
            this.Users.OrderBy(s => s).ToList().ForEach(s => Console.WriteLine($"-- {s}"));
        }

        public bool HasMembers()
        {
            return this.Users.Count > 0;
        }

        public bool HasUser(string user)
        {
            return this.Creator == user || this.Users.Contains(user);
        }


    }
}
