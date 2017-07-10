using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Rage_Quit
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToUpper();

            var numbers = Regex.Split(input, "\\D+").Where(s => s != string.Empty).Select(int.Parse).ToArray(); ;
            var words = Regex.Split(input, "\\d+").Where(s => s != string.Empty).ToArray();
            //Console.WriteLine(string.Join(" ", words));
            //Console.WriteLine($"Unique symbols used: {CountOfUniqueChars(words)}");
            //Console.WriteLine($"Unique symbols used: {CountOfUniqueChars2(words)}");

            StringBuilder b = new StringBuilder();            
            for (int i = 0; i < numbers.Length; i++)
            {
                var str = words[i];
                var n = numbers[i];
                b.Append(RepeatString(str, n));
            }
            int count = b.ToString().ToCharArray().Distinct().Count();
            Console.WriteLine($"Unique symbols used: {count}");
            Console.WriteLine(b.ToString());
        }

        static string RepeatString(string str, int n)
        {
            StringBuilder b = new StringBuilder(str.Length * n);
            for (int i = 0; i < n; i++)
            {
                b.Append(str);
            }
            return b.ToString();
        }

        //static int CountOfUniqueChars(string[] arr)
        //{
        //    HashSet<char> characters = new HashSet<char>();
        //    foreach (var str in arr)
        //    {
        //        foreach (var ch in str)
        //        {                   
        //            characters.Add(ch);
        //        }
        //    }
        //    return characters.Count;
        //}

        //static int CountOfUniqueChars2(string[] arr)
        //{
        //    StringBuilder b = new StringBuilder();
        //    foreach (var str in arr)
        //    {
        //        b.Append(str);
        //    }
        //    return b.ToString().ToCharArray().Distinct().Count();
        //}
    }
}
