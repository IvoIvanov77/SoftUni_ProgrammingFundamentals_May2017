using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_6.Byte_Flip
{
    class Program
    {
        static void Main(string[] args)
        { 

            var result = Console.ReadLine().Split(' ')
                .Where(s => s.Length == 2)
                .Select(s => ReverseString(s))
                .Select(s=> Convert.ToInt32(s, 16))
                .Select(i => (char)i)
                .Reverse().ToList();          

            Console.WriteLine(string.Join("", result));               
        }

        public static string ReverseString(string s)
        {
            char[] arr = s.ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }
    }
}
