using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_2.Manipulate_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(' ');
            int n = int.Parse(Console.ReadLine());   
            
            for (int i = 0; i < n; i++)
            {
                arr = ExecuteCommand(Console.ReadLine(), arr);
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
                    
                case "Replace": Replace(arr, line);
                    return arr;

                default: return arr;
            }
        }

        private static void Replace(string[] arr, string line)
        {
            string[] input = line.Split(' ');
            int index = int.Parse(input[1]);
            string item = input[2];
            arr[index] = item;

        }

        private static void Distinct(string[] arr)
        {
            arr = arr.Distinct().ToArray();
        }

        

        private static void Reverse(string[] arr)
        {
            for (int i = 0; i < arr.Length / 2; i++)
            {
                string tmp = arr[i];
                arr[i] = arr[arr.Length - 1 - i];
                arr[arr.Length - 1 - i] = tmp;
            }
        }

        

        
    }
}
