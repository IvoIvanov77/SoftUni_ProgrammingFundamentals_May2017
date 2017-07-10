using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_7.Inventory_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] products = Console.ReadLine().Split(' ');
            long[] quantities = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            decimal[] prices = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            string product = Console.ReadLine();

            while (product != "done")
            {
                int index = IndexOf(products, product);
                Console.WriteLine($"{product} costs: {prices[index]}; Available quantity: {quantities[index]}");
                product = Console.ReadLine();
            }
        }

        static int IndexOf(string[] array, string item)
        {
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] == item)
                {
                    return i;
                }
            }
            return -1;
        }
    }

    
}
