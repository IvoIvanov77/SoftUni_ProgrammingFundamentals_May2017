using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_13.Decrypting_Messages
{
    class Program
    {
        static void Main(string[] args)
        {
            int key = int.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());
            string result = string.Empty;

            for (int i = 0; i < n; i++)
            {
                int index = (int)char.Parse(Console.ReadLine()) + key;
                result += (char)index;
            }

            Console.WriteLine(result);

        }
    }
}
