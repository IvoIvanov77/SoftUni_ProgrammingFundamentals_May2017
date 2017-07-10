using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace FootballStandings
{
    class Program
    {
        static void Main(string[] args)
        {
            var key = Console.ReadLine();
            SortedDictionary<String, Team> teams = new SortedDictionary<string, Team>();
            var line = Console.ReadLine();
            while (line != "final")            {
                List<string> input = ExtractScore(line, key);                
               // Console.WriteLine(string.Join(" ", input));
                string homeTeam = input[0];
                string awayTeam = input[1];
                int homeTeamPoints = GetPoints(homeTeam, input);
                int homeTeamGoals = GetGoals(homeTeam, input);
                int awayTeamPoints = GetPoints(awayTeam, input);
                int awayTeamGoals = GetGoals(awayTeam, input);

                if (!teams.ContainsKey(homeTeam))
                {
                    Team team = new Team(homeTeam, homeTeamPoints, homeTeamGoals);
                    teams[homeTeam] = team;
                }
                else
                {
                    teams[homeTeam].Goals += homeTeamGoals;
                    teams[homeTeam].Points += homeTeamPoints;
                }

                if (!teams.ContainsKey(awayTeam))
                {
                    Team team = new Team(awayTeam, awayTeamPoints, awayTeamGoals);
                    teams[awayTeam] = team;
                }
                else
                {
                    teams[awayTeam].Goals += awayTeamGoals;
                    teams[awayTeam].Points += awayTeamPoints;
                }
                line = Console.ReadLine();
            }
            int pointsRank = 1;
            Console.WriteLine("League standings:");
            teams.Values.OrderByDescending(t => t.Points).ToList().ForEach(team =>
            {
                Console.WriteLine($"{pointsRank ++}. {team.Name} {team.Points}");
            });

            
            Console.WriteLine("Top 3 scored goals:");
            teams.Values.OrderByDescending(t => t.Goals).Take(3).ToList().ForEach(team =>
            {
                Console.WriteLine($"- {team.Name} -> {team.Goals}");
            });
        }

        static List<string> ExtractScore(string input, string key)
        {
            List<string> list = new List<string>();
            var matchScore = Regex.Match(input, @"\d+:\d+");
            Regex r = new Regex("(?<=" + Regex.Escape(key) + ")[a-zA-Z]*(?=" + Regex.Escape(key) + ")");
            var matchTeam = r.Match(input);
            string homeTeam = new string(matchTeam.Value.ToCharArray().Reverse().ToArray());
            string awayTeam = new string(matchTeam.NextMatch().Value.ToCharArray().Reverse().ToArray());
            string score = matchScore.Value;
            list.Add(homeTeam.ToUpper());
            list.Add(awayTeam.ToUpper());
            list.Add(score);
            return list;

        }

        static bool isHomeTeam(string team, List<string> list){
            return list[0] == team;
        }

        static int GetPoints(string team, List<string> list)
        {            
            var goals = list[2].Split(':').Select(int.Parse).ToArray();
            if(goals[0] > goals[1])
            {
                return isHomeTeam(team, list) ? 3 : 0;
            }
            else if(goals[0] < goals[1])
            {
                return isHomeTeam(team, list) ? 0 : 3;
            }
            else
            {
                return 1;
            }
        }

        static int GetGoals(string team, List<string> list)
        {
            var goals = list[2].Split(':').Select(int.Parse).ToArray();
            return isHomeTeam(team, list) ? goals[0] : goals[1];
        }
    }

    class Team {
        
        public string Name { get; set; }
        public int Points { get; set; }
        public int Goals { get; set; }

        public Team(string name, int points, int goals)
        {
            Name = name;
            Points = points;
            Goals = goals;
        }

    }

}
