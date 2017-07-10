using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _7.Hideout
{
    class Program
    {
        static void Main(string[] args)
        {
            var text = Console.ReadLine();

            while (true)
            {
                var input = Console.ReadLine().Split(' ');
                var pattern = @"[" + Regex.Escape(input[0]) + "]{" + input[1] + ",}";
                Match m = Regex.Match(text, pattern);
                if (m.Success)
                {
                    Console.WriteLine($"Hideout found at index {m.Index} " +
                        $"and it is with size {m.Length}!");
                    return;
                }
            }

        }
    }
}
