using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_11.String_Concatenation
{
    class Program
    {
        static void Main(string[] args)
        {
            char delimiter = char.Parse(Console.ReadLine());
            String evenOrOdd = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());
            int index = evenOrOdd.Equals("even") ? 0 : 1;           
            string result = string.Empty;

            for (int i = 1; i <= n; i++)
            {
                string word = Console.ReadLine();
                if ((i + index) % 2 == 0)
                {
                    result += word + delimiter;
                }
            }

            Console.WriteLine(result.Remove(result.LastIndexOf(delimiter)));
        }
    }
}
