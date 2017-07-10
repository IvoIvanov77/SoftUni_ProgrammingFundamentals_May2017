using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_3.Safe_Manipulation
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(' ');
            string line = Console.ReadLine();

            while (!line.Equals("END"))
            {
                arr = ExecuteCommand(line, arr);
                line = Console.ReadLine();
            }

            PrintArray(arr);
        }

        private static void PrintArray(string[] arr)
        {
            Console.WriteLine(string.Join(", ", arr));
        }

        private static string[] ExecuteCommand(string line, string[] arr)
        {
            string[] input = line.Split(' ');
            string command = input[0];
            switch (command)
            {
                case "Reverse": return arr.Reverse().ToArray();

                case "Distinct": return arr.Distinct().ToArray();

                case "Replace":
                    Replace(arr, line);
                    return arr;

                default: Console.WriteLine("Invalid input!");
                    return arr;
            }
        }

        private static void Replace(string[] arr, string line)
        {
            string[] input = line.Split(' ');
            int index = int.Parse(input[1]);
            string item = input[2];
            try
            {
                arr[index] = item;
            }
            catch (IndexOutOfRangeException)
            {

                Console.WriteLine("Invalid input!");
            }
            

        }

        

    }
}
