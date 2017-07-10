using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _7.Population_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            var countries = new Dictionary<string, Dictionary<string, long>>();

            var line = Console.ReadLine();

            while (line != "report")
            {
                var input = line.Split('|');
                var city = input[0];
                var country = input[1];
                var population = long.Parse(input[2]);
                if (!countries.ContainsKey(country))
                {
                    Dictionary<string, long> cities = new Dictionary<string, long>();
                    cities[city] = population;
                    countries.Add(country, cities);
                }
                else
                {
                    countries[country].Add(city, population);
                }

                line = Console.ReadLine();
            }
                        

            var countryPopulation = countries.ToDictionary(pair => pair.Key, pair => pair.Value.Values.Sum())
                .OrderByDescending(pair=>pair.Value);

            foreach (var country in countryPopulation)
            {
                Console.WriteLine("{0} (total population: {1})", country.Key, country.Value);
                countries[country.Key].OrderByDescending(pair => pair.Value).ToList()
                    .ForEach(item => Console.WriteLine("=>{0}: {1}", item.Key, item.Value));
            }
        }
    }
}
