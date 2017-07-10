using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _3.Search_for_a_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            var list = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            var array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var elementsToTake = array[0];
            var elementsToDelete = array[1];
            var element = array[2];

            list.RemoveRange(elementsToTake, list.Count - elementsToTake);

            for (int i = 0; i < elementsToDelete; i++)
            {
                list.RemoveAt(0);
            }

            if (list.Contains(element))
            {
                Console.WriteLine("YES!");
            }
            else
            {
                Console.WriteLine("NO!");
            }
        }
    }
}
