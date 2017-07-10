using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_2.Odd_Filter
{
    class Program
    {
        static void Main(string[] args)
        {
            var evenNumbers = Console.ReadLine().Split(' ').Select(int.Parse).Where(n => n % 2 == 0).ToList();

            var oddNumbers = evenNumbers.Select(a => a > evenNumbers.Average() ? a+=1 : a-=1).ToList();

            Console.WriteLine(string.Join(" ", oddNumbers));
        }
    }
}
