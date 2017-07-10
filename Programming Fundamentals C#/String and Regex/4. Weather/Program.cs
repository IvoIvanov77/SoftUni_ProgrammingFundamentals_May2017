using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _4.Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern = @"([A-Z]{2})(-*\d+\.\d+)([a-zA-Z]+(?=\|))";
            var line = Console.ReadLine();
            Dictionary<string, Forecast> cities = new Dictionary<string, Forecast>();
            while (line != "end")
            {
                MatchCollection matches = Regex.Matches(line, pattern);

                foreach (Match m in matches)
                {
                    Forecast forecast = new Forecast(m.Groups[1].ToString(),
                        m.Groups[3].ToString(),
                        float.Parse(m.Groups[2].ToString()));
                    cities[forecast.City] = forecast;                                       
                }
                line = Console.ReadLine();
            }

            cities.Values.OrderBy(c => c.Temp).ToList()
                .ForEach(c => Console.WriteLine($"{c.City} => {c.Temp:F2} => {c.Wheather}"));    
        }
    }

    class Forecast
    {
        public Forecast(string sity, string wheather, float temp)
        {
            City = sity;
            Wheather = wheather;
            Temp = temp;
        }

        public string City { get; set; }
        public string Wheather { get; set; }
        public float Temp { get; set; }
    }

}
