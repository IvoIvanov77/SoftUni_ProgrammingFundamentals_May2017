using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_1.X
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n/2; i++)
            {
                   Console.WriteLine(new String(' ', i) + "x" + new String(' ', n - 2 * i - 2) + "x");         
                
            }

            Console.WriteLine(new String(' ', n / 2) + "x");

            for (int i = n/2; i > 0 ; i--)
            {
                Console.WriteLine(new String(' ', i - 1) + "x" + new String(' ', n - 2 * i) + "x" );

            }

        }
    }
}
