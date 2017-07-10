using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace FootbalLegae
{
    class Program
    {
        static void Main(string[] args)
        {
            var key = Console.ReadLine();
            string line = Console.ReadLine();
            Regex teamsReg = new Regex("(?<=" + Regex.Escape(key) + ")[A-Za-z]*(?=" + Regex.Escape(key) + ")");
            Regex resultReg = new Regex(@"\d+:\d+");
            Dictionary<string, Team> league = new Dictionary<string, Team>();
            while (line != "final")
            {
                MatchCollection teams = teamsReg.Matches(line);
                Match result = resultReg.Match(line);
                var homeTeamName = new string(teams[0].Value.Reverse().ToArray()).ToUpper();
                var awayTeamName = new string(teams[1].Value.Reverse().ToArray()).ToUpper();
               // Console.WriteLine(homeTeamName + " " + awayTeamName);
                var goals = result.Value.Split(':');
                int homeTeamGoals = int.Parse(goals[0]);
                int awayTeamGoals = int.Parse(goals[1]);

                if (!league.ContainsKey(homeTeamName)) league[homeTeamName] = new Team(homeTeamName);
                if (!league.ContainsKey(awayTeamName)) league[awayTeamName] = new Team(awayTeamName);
                PlayGame(league[homeTeamName], league[awayTeamName], homeTeamGoals, awayTeamGoals);
                line = Console.ReadLine();
            }
            PrintRankByPoints(league);
            PrintRankByGoals(league);

        }

        static void PrintRankByPoints(Dictionary<string, Team> league)
        {
            int rank = 1;
            Console.WriteLine("League standings:");
            league.Values.OrderByDescending(t => t.Points).ThenBy(t => t.Name)
                .ToList().ForEach(t => Console.WriteLine($"{rank++}. {t.Name} {t.Points}"));
        }

        static void PrintRankByGoals(Dictionary<string, Team> league)
        {            
            Console.WriteLine("Top 3 scored goals:");
            league.Values.OrderByDescending(t => t.Goals).ThenBy(t => t.Name).Take(3)
                .ToList().ForEach(t => Console.WriteLine($"- {t.Name} -> {t.Goals}"));
        }



        static void PlayGame(Team home, Team away, int homeGoals, int awayGoals)
        {
            home.Goals += homeGoals;
            away.Goals += awayGoals;
            if (homeGoals > awayGoals) home.Points += 3;
            else if (homeGoals < awayGoals) away.Points += 3;
            else
            {
                home.Points++;
                away.Points++;
            }
        }
    }

    class Team
    {
        string name;
        int points;
        int goals;

        public Team(string name)
        {
            this.name = name;
            this.points = 0;
            this.goals = 0;
        }

        public string Name { get => name; set => name = value; }
        public int Points { get => points; set => points = value; }
        public int Goals { get => goals; set => goals = value; }
    }
}
