using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace String_and_Regex
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(IsExchangeable().ToString().ToLower());
            
        }

        static bool IsExchangeable()
        {
            var input = Console.ReadLine().Split(' ').OrderBy(s => s).ToArray();
            string shorter = input[0];
            string longer = input[1];
            Dictionary<char, char> dict = new Dictionary<char, char>();

            int index = 0;
            while (index < shorter.Length)
            {
                if (!dict.ContainsKey(shorter[index]))
                {
                    if (dict.ContainsValue(longer[index]))
                    {
                        return false;
                    }
                    dict[shorter[index]] = longer[index];
                }
                else
                {
                    if(dict[shorter[index]] != longer[index])
                    {
                        return false;
                    }
                }
                index++;
            }

            while(index < longer.Length)
            {
                if (!dict.ContainsValue(longer[index]))
                {
                    return false;
                }
                index++;
            }

            return true;
        }
    }
}
