using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Back_in_30_Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            var hours = int.Parse(Console.ReadLine());
            var minits = int.Parse(Console.ReadLine());

            minits += 30;

            if(minits > 59)
            {
                hours += 1;
                minits -= 60;
            }

            if(hours > 23)
            {
                hours -= 24;
            }

            Console.WriteLine("{0}:{1:D2}", hours, minits);
        }
    }
}
