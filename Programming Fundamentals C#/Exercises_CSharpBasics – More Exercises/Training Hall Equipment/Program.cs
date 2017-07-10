using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Training_Hall_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            var buget = double.Parse(Console.ReadLine());
            var n = int.Parse(Console.ReadLine());
            var balance = buget;

            for (int i = 0; i < n; i++)
            {
                var itemName = Console.ReadLine();
                var itemPrice = double.Parse(Console.ReadLine());
                var itemCount = int.Parse(Console.ReadLine());
                var pluralize = itemCount > 1 ? "s" : "";
                Console.WriteLine($"Adding {itemCount} {itemName}{pluralize} to cart.");
                balance -= itemPrice * itemCount;
            }

            Console.WriteLine($"Subtotal: ${buget - balance:F2}");

            if(balance > 0)
            {
                Console.Write($"Money left: ${balance:F2}");
            }
            else
            {
                Console.Write($"Not enough. We need ${Math.Abs(balance):F2} more.");
            }
        }
    }
}
