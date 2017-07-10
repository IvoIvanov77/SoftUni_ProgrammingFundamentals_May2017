using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_9.Make_a_Word
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            string result = string.Empty;

            for (int i = 0; i < n; i++)
            {
                result += Console.ReadLine();
            }

            Console.WriteLine($"The word is: {result}");
        }
    }
}
