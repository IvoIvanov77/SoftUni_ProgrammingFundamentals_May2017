using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_7.Play_Catch
{
    class Program
    {
        static int exceptionCounter = 0;
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            while (exceptionCounter < 3)
            {
                var line = Console.ReadLine().Split(' ');
                var command = line[0];
                switch (command)
                {
                    case "Replace": Replace(input, line[1], line[2]); break;
                    case "Print": Print(input, line[1], line[2]); break;
                    case "Show": Show(input, line[1]); break;
                }
            }

            Console.WriteLine(string.Join(", ", input));
        }

        static void Replace(int[] arr, string index, string item)
        {
            try
            {
                int i = int.Parse(index);
                int value = int.Parse(item);
                try
                {
                    arr[i] = value;
                }
                catch (IndexOutOfRangeException)
                {
                    Console.WriteLine("The index does not exist!");
                    exceptionCounter++;
                }
            }
            catch (FormatException)
            {
                Console.WriteLine("The variable is not in the correct format!");
                exceptionCounter++;
            }
            
            
        }

        static void Print(int[] arr, string start, string end)
        {
            try
            {
                int startIndex = int.Parse(start);
                int endIndex = int.Parse(end);
                try
                {
                    var first = arr[startIndex];
                    var last = arr[endIndex];
                    Console.WriteLine(string.Join(", ", arr.Where((el, i) => i >= startIndex && i <= endIndex)));
                }
                catch (Exception)
                {
                    Console.WriteLine("The index does not exist!");
                    exceptionCounter++;
                }
            }
            catch (FormatException)
            {
                Console.WriteLine("The variable is not in the correct format!");
                exceptionCounter++;
            }


            
        }

        static void Show(int[]arr, string input)
        {
            try
            {
                int index = int.Parse(input);
                try
                {
                    Console.WriteLine(arr[index]);
                }
                catch (IndexOutOfRangeException)
                {
                    Console.WriteLine("The index does not exist!");
                    exceptionCounter++;
                }
            }
            catch (FormatException)
            {
                Console.WriteLine("The variable is not in the correct format!");
                exceptionCounter++;
            }

            
        }
    }
}
