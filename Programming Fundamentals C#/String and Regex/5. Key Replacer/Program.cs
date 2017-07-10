using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _5.Key_Replacer
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();
            var start = Regex.Match(input, @"^[a-zA-Z]+(?=[\|\<\\])").Value;
            var end = Regex.Match(input, @"(?<=[\|\<\\])[a-zA-Z]+$").Value;
            var text = Console.ReadLine();
            
            MatchCollection coll = Regex.Matches(text, "(?<=" + start + ")(.*?)(?=" + end + ")");
            
            StringBuilder b = new StringBuilder();

            foreach (Match m in coll)
            {     
                if(m.Value != string.Empty)
                b.Append(m.Value);
            }
            if(b.Length == 0)
            {
                Console.WriteLine("Empty result");
            }
            else
            {
                Console.WriteLine(b.ToString());
            }
            
        }
    }
}
