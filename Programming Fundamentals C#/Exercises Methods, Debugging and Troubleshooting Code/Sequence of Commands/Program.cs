using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sequence_of_Commands
{
    class Program
    {
        private const char ArgumentsDelimiter = ' ';

        public static void Main()
        {
            int sizeOfArray = int.Parse(Console.ReadLine());

            long[] array = Console.ReadLine()
                .Split(ArgumentsDelimiter)
                .Select(long.Parse)
                .ToArray();

            string line = Console.ReadLine();

            while (!line.Equals("stop"))
            {
                
                int[] args = new int[2];                

                string[] stringParams = line.Split(ArgumentsDelimiter);
                string command = stringParams[0];

                if (command.Equals("add") ||
                    command.Equals("subtract") ||
                    command.Equals("multiply"))
                {
                    
                    args[0] = int.Parse(stringParams[1]);
                    args[1] = int.Parse(stringParams[2]);

                    
                }

                PerformAction(array, command, args);

                PrintArray(array);
                //Console.WriteLine('\n');

                line = Console.ReadLine();
            }
        }

        static void PerformAction(long[] array, string action, int[] args)
        {
            //long[] array = arr.Clone() as long[];
            int pos = args[0];
            int value = args[1];

            switch (action)
            {
                case "multiply":
                    array[pos - 1] *= value;
                    break;
                case "add":
                    array[pos - 1] += value;
                    break;
                case "subtract":
                    array[pos - 1] -= value;
                    break;
                case "lshift":
                    ArrayShiftLeft(array);
                    break;
                case "rshift":
                    ArrayShiftRight(array);
                    break;
            }
        }

        private static void ArrayShiftRight(long[] array)
        {
            long tmp = array[array.Length - 1];
            for (int i = array.Length - 1; i >= 1; i--)
            {                
                array[i] = array[i - 1];
            }
            array[0] = tmp;
        }

        private static void ArrayShiftLeft(long[] array)
        {
            long tmp = array[0];
            for (int i = 0; i < array.Length - 1; i++)
            {
                array[i] = array[i + 1];
            }
            array[array.Length - 1] = tmp;
        }


        private static void PrintArray(long[] array)
        {
            for (int i = 0; i < array.Length; i++)
            {
                Console.Write(array[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
