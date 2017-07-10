using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cake_Ingredients
{
    class Program
    {
        static void Main(string[] args)
        {
            int count = 0;
            while (true)
            {
                var ingredient = Console.ReadLine();
                if (ingredient.Equals("Bake!"))
                {
                    break;
                }
                Console.WriteLine($"Adding ingredient { ingredient}.");
                count++;
            }

            Console.WriteLine($"Preparing cake with { count} ingredients.");
            
        }
    }
}
