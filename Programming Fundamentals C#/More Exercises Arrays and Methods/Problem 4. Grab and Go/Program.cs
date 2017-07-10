using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_4.Grab_and_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int number = int.Parse(Console.ReadLine());
            int index = IndexOfLastOccurance(arr, number);

            if ( index == -1)
            {
                Console.WriteLine("No occurrences were found!");
            }
            else
            {
                Console.WriteLine(GetSumTo(arr, index));
            }
        }

        private static long GetSumTo(int[] arr, int index)
        {
            long sum = 0;
            for (int i = 0; i < index; i++)
            {
                sum += arr[i];
            }

            return sum;
        }

        static int IndexOfLastOccurance(int[] arr, int item)
        {
            for (int i = arr.Length -1; i >= 0; i--)
            {
                if(arr[i] == item)
                {
                    return i;
                }
            }
            return -1;
        }
    }
}
