using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace II.LINQ
{
    class Program
    {
        static void Main(string[] args)
        {
            //SumMinMaxAverage();
            //Largest3Numbers();
            ShortWordsSorted();
        }

        static void SumMinMaxAverage()
        {
            int n = int.Parse(Console.ReadLine());

            var list = new List<int>();

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                list.Add(number);                
            }

            Console.WriteLine($"Sum = {list.Sum()}\n" +
                    $"Min = {list.Min()}\n" +
                    $"Max = {list.Max()}\n" +
                    $"Average = {list.Average()}");
        }

        static void Largest3Numbers()
        {
            var nums = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();

            var result = nums.OrderByDescending(x => x).Take(3).ToArray();

            Console.WriteLine(string.Join(" ", result));
        }

        static void ShortWordsSorted()
        {
            char[] separators = { '.', ',', ':', ';', '(', ')', '[', ']', '\\', '\"', '\'', '/', '!', '?', ' ' };

            var words = Console.ReadLine().ToLower().Split(separators);

            var result = words.OrderBy(s => s).Distinct().Where(s => s.Length < 5 && s.Length > 0).ToArray();

            Console.WriteLine(string.Join(", ", result));

        }
    }
}
