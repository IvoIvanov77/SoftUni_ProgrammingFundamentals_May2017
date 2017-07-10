using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_8.Upgraded_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] products = Console.ReadLine().Split(' ');
            long[] quantities = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            decimal[] prices = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            string line = Console.ReadLine();

            while (line != "done")
            {
                var input = line.Split(' ');
                var product = input[0];
                var quantity = long.Parse(input[1]);
                int index = IndexOf(products, product);
                if(HasQuantity(quantities, index, quantity))
                {
                    Console.WriteLine($"{product} x {quantity} costs {quantity * prices[index]:F2}");
                    quantities[index] -= quantity;
                }
                else
                {
                    Console.WriteLine($"We do not have enough {product}");
                }
                line = Console.ReadLine();
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

        static bool HasQuantity(long[] arr, int index, long quantity)
        {
            return index < arr.Length && arr[index] >= quantity;
        }
    }
}
