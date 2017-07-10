using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            int limit = int.Parse(Console.ReadLine());
            int sum = 0;
            int combination = 0;

            for (int i = n1; i > 0; i--)
            {
                if (sum >= limit)
                {
                    break;
                }
                for (int j = 1; j <= n2; j++)
                {
                    sum += 3 * i * j;
                    combination++;
                    if (sum >= limit)
                    {
                        break;
                    }
                    
                }
            }

            if(sum >= limit)
            {                
                Console.WriteLine("{0} combinations", combination);
                Console.WriteLine("Sum: {0} >= {1}", sum, limit);

            }
            else
            {
                Console.WriteLine("{0} combinations", combination);
                Console.WriteLine("Sum: {0}", sum);
            }
        }
    }
}
