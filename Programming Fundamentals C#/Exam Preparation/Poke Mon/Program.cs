using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Poke_Mon
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            var m = int.Parse(Console.ReadLine());
            var y = int.Parse(Console.ReadLine());
            var initial = n;

            int count = 0;

            while(n >= m)
            {
                count++;
                n -= m;
                if(initial % (0.5 * initial) == 0)
                {
                    try
                    {
                        n /= y;
                    }
                    catch (Exception)
                    {                       
                    }
                    
                }
            }

            Console.WriteLine(n);
            Console.WriteLine(count);

        }
    }
}
