using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Change_List
{
    class Program
    {
        static void Main(string[] args)
        {
            var list = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            string line = Console.ReadLine();

            while (line != "Odd" && line != "Even")
            {
                var input = line.Split(' ');
                var command = input[0];
                if(command == "Delete")
                {
                    list.RemoveAll(number => number == int.Parse(input[1]));
                }
                else
                {
                    list.Insert(int.Parse(input[2]), int.Parse(input[1]));
                }
                line = Console.ReadLine();
            }

            List<int> result;

            if(line == "Odd")
            {
                result = list.Where(number => number % 2 != 0).ToList();
            }
            else
            {
                result = list.Where(number => number % 2 == 0).ToList();
            }

            Console.WriteLine(string.Join(" ", result));
        }
    }
}
