using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Read_and_write_arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            string line = Console.ReadLine();

            int[] arr = line.Split(' ').Select(int.Parse).ToArray();

            foreach (var item in arr)
            {
                Console.WriteLine(item);
            }

            Console.WriteLine(string.Join("-", arr));
        }
    }
}
