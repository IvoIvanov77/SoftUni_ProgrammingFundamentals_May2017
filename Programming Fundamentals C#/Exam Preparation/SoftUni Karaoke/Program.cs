using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace SoftUni_Karaoke
{
    class Program
    {
        static void Main(string[] args)
        {

            var singers = Regex.Split(Console.ReadLine(), @",\s+");
            var songs = Regex.Split(Console.ReadLine(), @",\s+");

            Dictionary<String, Singer> dict = new Dictionary<string, Singer>();

            var line = Console.ReadLine();

            while (line != "dawn")
            {
                var input = Regex.Split(line, @",\s+");
                var singerName = input[0];
                var song = input[1];
                var award = input[2];
                line = Console.ReadLine();
                if(!singers.Contains(singerName) || !songs.Contains(song))
                {
                    continue;
                }
                if (!dict.ContainsKey(singerName))
                {
                    Singer singer = new Singer(singerName);
                    singer.Awards.Add(award);
                    dict[singerName] = singer;
                }
                else
                {
                    dict[singerName].Awards.Add(award);
                }

            }

            if(dict.Count == 0)
            {
                Console.WriteLine("No awards");
            }
            else
            {
                dict.Values.OrderByDescending(singer => singer.Awards.Count)
                    .ThenBy(singer => singer.Name)
                    .ToList().ForEach(singer => singer.PrintSinger());
            }

        }
    }

    class Singer
    {
        string name;
        SortedSet<string> awards;

        public Singer(string name)
        {
            this.name = name;
            this.awards = new SortedSet<string>();
        }

        public string Name { get => name; set => name = value; }
        public SortedSet<string> Awards { get => awards; set => awards = value; }

        public void PrintSinger()
        {
            Console.WriteLine($"{this.Name}: {this.Awards.Count} awards");
            foreach (var award in this.Awards)
            {
                Console.WriteLine($"--{award}");
            }
        }
    }
}
