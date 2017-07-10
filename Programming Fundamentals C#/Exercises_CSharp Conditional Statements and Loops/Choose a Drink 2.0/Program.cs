using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Choose_a_Drink_2._0
{
    class Program
    {
        static void Main(string[] args)
        {
            var profesion = Console.ReadLine();
            var quantity = int.Parse(Console.ReadLine());

            switch (profesion)
            {
                case "Athlete": Console.WriteLine($"The {profesion} has to pay {quantity * 0.7:F2}."); break;
                case "Businessman":
                case "Businesswoman": Console.WriteLine($"The {profesion} has to pay {quantity * 1.0:F2}."); break;
                case "SoftUni Student": Console.WriteLine($"The {profesion} has to pay {quantity * 1.7:F2}."); break;
                default: Console.WriteLine($"The {profesion} has to pay {quantity * 1.2:F2}."); break;
            }
        }
    }
}
