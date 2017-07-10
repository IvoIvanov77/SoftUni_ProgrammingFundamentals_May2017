using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _5.Only_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();           
            
            StringBuilder b = new StringBuilder(input);
            MatchCollection matches = Regex.Matches(input, @"(\d+)([a-zA-Z])");
            int counter = 0;
            foreach (Match m in matches)
            {
               // Console.WriteLine(m.Value);
                var number = m.Groups[1].Value;
                var letter = m.Groups[2].Value;
                int index = m.Index - counter;
                b.Remove(index, number.Length);
                b.Insert(index, letter);
                counter = number.Length - 1;
            }
            Console.WriteLine(b.ToString());
        }
    }
}
