using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _3.Camera_View
{
    class Program
    {
        static void Main(string[] args)
        {
            var arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int skip = arr[0];
            int take = arr[1];
            var line = Console.ReadLine();
            var input = Regex.Split(line, @"\|\<");

            var result = input.Skip(1).Select(s => new string(s.Skip(skip).Take(take).ToArray()));

            Console.WriteLine(string.Join(", ", result));
        }

    }
}
