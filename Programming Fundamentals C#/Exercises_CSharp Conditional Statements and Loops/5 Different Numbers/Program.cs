using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5_Different_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());

            if((n2 - n1) < 4)
            {
                Console.WriteLine("No");
            }

            for (int a = n1; a <= n2; a++)
            {
                for (int b = a + 1; b <= n2; b++)
                {
                    for (int c = b + 1; c <= n2; c++)
                    {
                        for (int d = c + 1; d <= n2; d++)
                        {
                            for (int e = d + 1; e <= n2; e++)
                            {
                                Console.WriteLine("{0} {1} {2} {3} {4}", a, b, c, d, e);
                            }
                        }
                    }
                }
            }
        }
    }
}
