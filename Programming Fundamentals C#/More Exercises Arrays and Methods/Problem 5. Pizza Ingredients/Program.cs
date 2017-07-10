using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_5.Pizza_Ingredients
{
    class Program
    {
        static void Main(string[] args)
        {
            var ingradients = Console.ReadLine().Split(' ');
            int lenght = int.Parse(Console.ReadLine());
            int count = CountItemWithSpecifieldLenght(ingradients, lenght);
            string[] result = ExtractItemWithSpecifieldLenght(ingradients, lenght);
            Console.WriteLine($"Made pizza with total of {count} ingredients.");
            Console.WriteLine($"The ingredients are: {string.Join(", ", result)}.");

        }

        private static int CountItemWithSpecifieldLenght(string[] ingradients, int lenhgt)
        {
            int count = 0;
            foreach (var ingradient in ingradients)
            {
                if(ingradient.Length == lenhgt)
                {
                    count++;
                }
                if(count == 10)
                {
                    return count;
                }
            }
            return count;
        }

        private static string[] ExtractItemWithSpecifieldLenght(string[] ingradients, int lenght)
        {
            string[] resultingArray = new string[CountItemWithSpecifieldLenght(ingradients, lenght)];
            int index = 0;
            foreach (var ingradient in ingradients)
            {
                if (ingradient.Length == lenght)
                {
                    resultingArray[index++] = ingradient;
                    Console.WriteLine($"Adding {ingradient}.");
                }

                if(index == 10)
                {
                    return resultingArray;
                }
            }
            return resultingArray;
        }


    }
}
