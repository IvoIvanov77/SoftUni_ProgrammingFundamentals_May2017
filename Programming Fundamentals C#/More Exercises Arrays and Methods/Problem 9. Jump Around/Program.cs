using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_9.Jump_Around
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int sum = 0;
            int index = 0;

            while (true)
            {
                //Console.WriteLine(index);
                int value = array[index];
                sum += value;
                if(CanMoveRight(array, index))
                {
                    index = index + value;
                }
                else if(CanMoveLeft(array, index))
                {
                    index = index - value;
                }
                else
                {
                    break;
                }
            }
            Console.WriteLine(sum);

        }

        private static bool CanMove(int[] array, int index)
        {
            return CanMoveRight(array, index) || CanMoveLeft(array, index);
        }

        static bool CanMoveRight(int[] arr, int index)
        {
            return  index + arr[index] < arr.Length;
        }

        static bool CanMoveLeft(int[] arr, int index)
        {
            return  index - arr[index] > 0;
        }
    }
}
