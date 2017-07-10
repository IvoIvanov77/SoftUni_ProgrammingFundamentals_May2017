using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interval_of_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var n1 = int.Parse(Console.ReadLine());
            var n2 = int.Parse(Console.ReadLine());

            var min = Math.Min(n1, n2);
            var max = Math.Max(n1, n2);

            for (int i = min; i <= max; i++)
            {
                Console.WriteLine(i);
            }
        }
    }
}
