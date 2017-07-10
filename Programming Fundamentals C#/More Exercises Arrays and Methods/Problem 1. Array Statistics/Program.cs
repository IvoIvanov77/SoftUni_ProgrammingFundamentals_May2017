using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_1.Array_Statistics
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int min = int.MaxValue;
            int max = int.MinValue;
            double sum = 0;

            for (int i = 0; i < arr.Length; i++)
            {
                sum += arr[i];
                if(arr[i] < min)
                {
                    min = arr[i];
                }

                if (arr[i] > max)
                {
                    max = arr[i];
                }
            }

            Console.WriteLine($"Min = {min}\n" +
                $"Max = {max}\n" +
                $"Sum = {sum}\n" +
                $"Average = {sum / arr.Length}");
        }
    }
}
