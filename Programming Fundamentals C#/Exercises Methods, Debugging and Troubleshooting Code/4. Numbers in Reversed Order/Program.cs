using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.Numbers_in_Reversed_Order
{
    class Program
    {
        static void Main(string[] args)
        {
            String number = Console.ReadLine();
            Console.WriteLine(new string(number.ToCharArray().Reverse().ToArray()));
        }
    }
}
