using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Pokemon_Evolution
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            Dictionary<string, List<Evolution>> pokemons = new Dictionary<string, List<Evolution>>();
            while(line != "wubbalubbadubdub")
            {
                var input = Regex.Split(line, @"\s*\-\>\s*");
                var name = input[0];
                if(input.Length == 1)
                {
                    if (pokemons.ContainsKey(name))
                    {
                        Console.WriteLine($"# {name}");
                        foreach (var evol in pokemons[name])
                        {
                            Console.WriteLine($"{evol.Type} <-> {evol.Index}");
                        }
                    }
                }
                else
                {
                    var type = input[1];
                    var index = int.Parse(input[2]);
                    Evolution e = new Evolution(type, index);
                    if (!pokemons.ContainsKey(name))
                    {
                        List<Evolution> evolutions = new List<Evolution>();
                        evolutions.Add(e);
                        pokemons[name] = evolutions;
                    }
                    else
                    {
                        pokemons[name].Add(e);
                    }
                }

                line = Console.ReadLine();
            }

            pokemons.Keys.ToList().ForEach(p =>
            {
                Console.WriteLine($"# {p}");
                pokemons[p].OrderByDescending(e => e.Index).ToList()
                .ForEach(e => Console.WriteLine($"{e.Type} <-> {e.Index}"));
                
            });
            
        }
    }

    class Evolution
    {
        string type;
        int index;

        public Evolution(string type, int index)
        {
            this.type = type;
            this.index = index;
        }

        public string Type { get => type; set => type = value; }
        public int Index { get => index; set => index = value; }
    }
}
