using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ladybugs
{
    class Program
    {
        static void Main(string[] args)
        {

            var fieldSize = int.Parse(Console.ReadLine());
            var field = new byte[fieldSize];
            var populateIndexes = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            for (int i = 0; i < populateIndexes.Length; i++)
            {
                if (IsValidIndex(field, populateIndexes[i]))
                {
                    field[populateIndexes[i]] = 1;
                }
            }

            var line = Console.ReadLine();

            while (line != "end")
            {
                var input = line.Split(' ');
                var index = int.Parse(input[0]);
                var direction = input[1];
                var movment = int.Parse(input[2]);
                if (index < 0 || index >= field.Length || field[index] == 0)
                {
                    line = Console.ReadLine();
                    continue;
                }
                if (direction == "right")
                {
                    MoveRight(field, index, movment);
                }
                else
                {
                    MoveLeft(field, index, movment);
                }
                line = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", field));
        }

        static void MoveRight(byte[] arr, int index, int len)
        {
            if (len < 0)
            {               
                return;
            }
            if (!IsValidIndex(arr, index)) return;
            int newIndex = index + len;
            arr[index] = 0;
            if (!IsValidIndex(arr, newIndex)) return;
            for (int i = newIndex; i < arr.Length; i++)
            {
                if (arr[i] == 0)
                {
                    arr[i] = 1;
                    return;
                }
            }
        }

        static void MoveLeft(byte[] arr, int index, int len)
        {
            if (len < 0)
            {                
                return;
            }
            if (!IsValidIndex(arr, index)) return;
            int newIndex = index - len;
            arr[index] = 0;
            if (!IsValidIndex(arr, newIndex)) return;
            for (int i = newIndex; i >= 0; i--)
            {
                if (arr[i] == 0)
                {
                    arr[i] = 1;
                    return;
                }
            }
        }

        static bool IsValidIndex(byte[] arr, int index)
        {
            return index >= 0 && index < arr.Length;
        }
    }
}

