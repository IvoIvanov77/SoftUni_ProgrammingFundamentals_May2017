using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _1.Extract_Emails
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            var pattern = @"(?<=^|\s)([A-Za-z0-9]+[-\._]*)+@([\w]+[-\.])+[\w]+";

            MatchCollection matches = Regex.Matches(line, pattern);

            foreach (var item in matches)
            {
                Console.WriteLine(item);
            }
        }
    }
}
