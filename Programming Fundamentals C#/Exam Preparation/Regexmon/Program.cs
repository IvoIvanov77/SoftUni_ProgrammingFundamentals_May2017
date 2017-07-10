using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Regexmon
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            int index = 0;
            var input = line;
            
            while (true)
            {
                try
                {
                    input = input.Substring(index);
                }
                catch (Exception)
                {                   
                }
                
                Match didimon = Regex.Match(input, @"[^a-zA-Z\-]+");

                if(!didimon.Success)
                {
                   return;
                }
                Console.WriteLine(didimon.Value);
                index = didimon.Index + didimon.Length;
                try
                {
                    input = input.Substring(index);
                }
                catch (Exception)
                {
                }
                Match bojomon = Regex.Match(input, @"[a-zA-Z]+\-[a-zA-Z]+");
                if (!bojomon.Success)
                {
                    return;
                }
                Console.WriteLine(bojomon.Value);
                index = bojomon.Index + bojomon.Length;
                
            }

           

        }
    }
}
