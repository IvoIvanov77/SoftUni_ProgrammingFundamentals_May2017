using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_8.House_Builder
{
    class Program
    {
        static void Main(string[] args)
        {
            
            long price = 0;

            for (int i = 0; i < 2; i++)
            {
                var number = Console.ReadLine();
                try
                {
                    sbyte sb = sbyte.Parse(number);
                    price += 4 * sb;
                   
                }
                catch (Exception)
                {
                    price += 10 * long.Parse(number);                    
                }
            }
            Console.WriteLine(price);
        }
    }
}
