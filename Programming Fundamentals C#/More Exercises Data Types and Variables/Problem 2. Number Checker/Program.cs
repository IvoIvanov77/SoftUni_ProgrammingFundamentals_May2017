using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_2.Number_Checker
{
    class Program
    {
        static void Main(string[] args)
        {
            var number = Console.ReadLine();
            if (number.Contains(".")) 
            {
                Console.WriteLine("floating-point");
            }
            else
            {
                Console.WriteLine("integer");
            }
        }
    }
}
