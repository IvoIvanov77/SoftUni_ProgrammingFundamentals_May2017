using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_7.Multiply_Big_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            var bigNumber = Console.ReadLine().Select(ch => int.Parse(ch.ToString())).ToArray();
            var n = int.Parse(Console.ReadLine());

            StringBuilder b = new StringBuilder();

            var residue = 0;

            for (int i = bigNumber.Length - 1; i >= 0; i--)
            {
                var result = residue + bigNumber[i] * n;
                b.Append(result % 10 );
                residue = result / 10;
            }

            b.Append(residue);
            int index = b.Length - 1;

            while(b[index] == '0' && index > 0)
            {               
                b.Remove(index--, 1);
            }
            

            char[] arr = b.ToString().ToCharArray();
            Array.Reverse(arr);

            Console.WriteLine(new string(arr));
        }
    }
}
