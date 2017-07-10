using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Max_Method
{
    class Program
    {
        static void Main(string[] args)
        {
            var a = int.Parse(Console.ReadLine());
            var b = int.Parse(Console.ReadLine());
            var c = int.Parse(Console.ReadLine());

            Console.WriteLine(getMax(a, b, c));
        }

        static int getMax(int a, int b)
        {
            if (a >= b)
            {
                return a;
            }
            else return b;
        }

        static int getMax(int a, int b, int c)
        {
            return getMax(a, b) >= c ? getMax(a, b) : c;
        }
    }
}
