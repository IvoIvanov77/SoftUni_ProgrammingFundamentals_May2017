using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Hornet_Armada
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Dictionary<string, Legion> legions = new Dictionary<string, Legion>();

            for (int i = 0; i < n; i++)
            {
                var line = Console.ReadLine();
                var input = Regex.Split(line, @"\s*[=\->:\s]+\s*");
                var lastActivity = long.Parse(input[0]);
                var legionName = input[1];
                var soldierType = input[2];
                var count = long.Parse(input[3]);
                SoldierType type = new SoldierType(soldierType, count);
                Legion l = new Legion(legionName, lastActivity);
                if (!legions.ContainsKey(legionName))
                {              
                    
                    l.AddType(type);
                    legions[legionName] = l;
                }
                else
                {
                    legions[legionName].AddType(type);
                    if(l.LastActivity > legions[legionName].LastActivity)
                    {
                        legions[legionName].LastActivity = l.LastActivity;
                    }
                }
            }

            var command = Console.ReadLine().Split('\\');
            if(command.Length == 2)
            {
                PrintLegions(legions, long.Parse(command[0]), command[1]);
            }
            else
            {
                PrintLegions(legions, command[0]);
            }
        }

        static void PrintLegions(Dictionary<string, Legion> legions,long activity, string type)
        {
            legions.Values.Where(l => l.Types.ContainsKey(type) && l.LastActivity < activity)
                .OrderByDescending(l => l.Types[type].Count).ToList()
                .ForEach(l => Console.WriteLine($"{l.Name} -> {l.Types[type].Count}"));
        }

        static void PrintLegions(Dictionary<string, Legion> legions, string type)
        {
            legions.Values.Where(l => l.Types.ContainsKey(type) )
                .OrderByDescending(l => l.LastActivity).ToList()
                .ForEach(l => Console.WriteLine($"{l.LastActivity} : {l.Name}"));
        }
    }

    class Legion
    {
        string name;
        long lastActivity;
        Dictionary<String, SoldierType> types;

        public Legion(string name, long lastActivity)
        {
            this.name = name;
            this.lastActivity = lastActivity;
            this.Types = new Dictionary<String, SoldierType>();
        }

        public string Name { get => name; set => name = value; }
        public long LastActivity { get => lastActivity; set => lastActivity = value; }
        internal Dictionary<string, SoldierType> Types { get => types; set => types = value; }

        public void AddType(SoldierType type)
        {
            if (this.Types.ContainsKey(type.Name))
            {
                this.Types[type.Name].Count += type.Count;
            }
            else
            {
                this.Types[type.Name] = type;
            }
        }
    }

    internal class SoldierType
    {
        string name;
        long count;

        public SoldierType(string name, long count)
        {
            this.name = name;
            this.count = count;
        }

        public string Name { get => name; set => name = value; }
        public long Count { get => count; set => count = value; }
    }
}
