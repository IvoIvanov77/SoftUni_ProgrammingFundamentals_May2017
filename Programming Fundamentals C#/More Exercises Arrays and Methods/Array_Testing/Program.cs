using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Array_Testing
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] a = { 1, 2, 2, 4, 4 };
            a = a.Distinct().ToArray();
            a = a.Reverse().ToArray();
            
            double b = a.Average();
            Console.WriteLine(string.Join(", ", a));
            Console.WriteLine(b);
        }

        static void Excange(int[] arr)
        {
            int[] b = { 3, 2, 1 };
            b.CopyTo(arr, 0);
            
        }
    }
}
