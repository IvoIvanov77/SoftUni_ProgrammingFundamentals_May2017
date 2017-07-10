using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _6.Email_Statistics
{
    class Program
    {
        static void Main(string[] args)
        {
            var count = int.Parse(Console.ReadLine());
            Dictionary<string, List<String>> emails = new Dictionary<string, List<string>>();
            Regex r = new Regex(@"^([a-zA-Z]{5,})@([a-z]{3,}.(com|bg|org))$");
            for (int i = 0; i < count; i++)
            {
                var line = Console.ReadLine();
                if (r.IsMatch(line))
                {
                    Match m = r.Match(line);
                    var username = m.Groups[1].Value;
                    var domain = m.Groups[2].Value;
                    if (emails.ContainsKey(domain))
                    {
                        if (!emails[domain].Contains(username))
                        {
                            emails[domain].Add(username);
                        }
                    }
                    else
                    {
                        List<string> names = new List<string>();
                        names.Add(username);
                        emails[domain] = names;
                    }
                }
            }
            emails.OrderByDescending(kv => kv.Value.Count).ToList()
                .ForEach(kv => {
                    Console.WriteLine($"{kv.Key}:");
                    kv.Value.ForEach(d => Console.WriteLine($"### {d}"));
                    });

            
        }
    }
    
}
