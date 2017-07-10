using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Melrah_Shake
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            string pattern = Console.ReadLine();           



            while(true)
            {
                if(pattern == string.Empty)
                {
                    Console.WriteLine("No shake.");
                    break;
                }
                Regex r = new Regex(pattern);
                MatchCollection matches = r.Matches(text);                
                int count = matches.Count;
                if(count >= 2 )
                {
                    text = text.Remove(matches[count - 1].Index, pattern.Length);
                    text = text.Remove(matches[0].Index, pattern.Length);
                    pattern = pattern.Remove(pattern.Length / 2, 1);
                    Console.WriteLine("Shaked it.");
                }
                else
                {
                    Console.WriteLine("No shake.");
                    break;
                }

            }

            Console.WriteLine(text);

        }
    }
}
