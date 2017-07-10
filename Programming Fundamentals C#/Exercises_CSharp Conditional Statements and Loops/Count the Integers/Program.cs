using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Count_the_Integers
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = 0;
            while (true)
            {
                try
                {
                    var i = int.Parse(Console.ReadLine());
                }
                catch (Exception)
                {

                    break;
                }
                count++;
            }
            Console.WriteLine(count);
        }
    }
}
