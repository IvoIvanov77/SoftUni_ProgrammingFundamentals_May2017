using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Roli___The_Coder
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine().Trim();

            Regex r = new Regex(@"(\d+)\s+#(.+?\b)(\s+@.+)*");
            Dictionary<long, Event> events = new Dictionary<long, Event>();

            while (line != "Time for Code")
            {
                Match m = r.Match(line);
                if (m.Success)
                {
                    long id = long.Parse(m.Groups[1].Value);
                    string name = m.Groups[2].Value;
                    string participants = m.Groups[3].Value;

                    if (!events.ContainsKey(id))
                    {
                        Event e = new Event(id, name);
                        e.AddParticipants(participants);
                        events[id] = e;
                    }
                    else
                    {
                        if(events[id].Name == name)
                        {
                            events[id].AddParticipants(participants);
                        }
                    }
                }
                line = Console.ReadLine();
            }

            events.Values.OrderByDescending(e => e.GetParticipantsCount())
                .ThenBy(e => e.Name).ToList()
                .ForEach(e => {
                    Console.WriteLine($"{e.Name} - {e.GetParticipantsCount()}");
                    e.PrintParticipants();
                });
        }
    }

    class Event
    {
        private long id;
        private string name;
        private SortedSet<String> participants;
        

        public long Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }

        public Event(long id, string name)
        {
            this.Id = id;
            this.Name = name;
            this.participants = new SortedSet<string>();
        }

        public void AddParticipants(string line)
        {
            var input = Regex.Split(line.Trim(), @"\s+").ToArray();
            foreach(var s in input)
            {
               if(s != string.Empty)
                this.participants.Add(s); 
            }
        }
        public void PrintParticipants()
        {
            foreach(var p in this.participants)
            {
                Console.WriteLine(p);
            }
        }

        public int GetParticipantsCount()
        {
            return this.participants.Count;
        }
    }
}
