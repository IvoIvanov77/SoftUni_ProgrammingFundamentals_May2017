using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _3.Karate_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            StringBuilder b = new StringBuilder(input);
            MatchCollection matches = Regex.Matches(input, @"(?<=>)([\d])([a-zA_Z0-9]*)");
            int resudae = 0;
            foreach (Match m in matches)
            {
                int strength = int.Parse(m.Groups[1].Value) + resudae;
                int index = m.Index;
                if (strength <= m.Value.Length)
                {                    
                    b.Remove(index, strength);
                    b.Insert(index, " ", strength);
                    resudae = 0;
                }
                else
                {
                    b.Remove(index, m.Value.Length);
                    b.Insert(index, " ", m.Value.Length);
                    resudae = strength - m.Value.Length;
                }
                
            }

            Console.WriteLine(b.Replace(" ", "").ToString());
        }
    }
}
