using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Melrah_Shake_With_Substrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string text = Console.ReadLine();
            string pattern = Console.ReadLine();

            while (true)
            {
                int count = text.Where((s, index) => 
                index <= text.Length - pattern.Length 
                && text.Substring(index, pattern.Length) == pattern)
                    .Count();               
                if (pattern == string.Empty || count < 2)
                {
                    Console.WriteLine("No shake.");
                    break;
                }
                text = text.Remove(text.LastIndexOf(pattern), pattern.Length);
                text = text.Remove(text.IndexOf(pattern), pattern.Length);
                pattern = pattern.Remove(pattern.Length / 2, 1);
                Console.WriteLine("Shaked it.");
            }

            Console.WriteLine(text);
        }        
    }
}
