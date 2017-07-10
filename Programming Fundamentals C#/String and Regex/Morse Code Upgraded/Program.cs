using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Morse_Code_Upgraded
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split('|');
            StringBuilder b = new StringBuilder();

            foreach (var item in input)
            {
                b.Append(GetLetter(item));
            }

            Console.WriteLine(b.ToString());
        }

        static char GetLetter(string line)
        {
            int sum = 0;
            foreach(char ch in line)
            {
                if(ch == '0')
                {
                    sum += 3;
                }
                else
                {
                    sum += 5;
                }                
            }
           // Console.WriteLine(sum);
            for (int i = 0; i < line.Length - 1; i++)
            {
                if(line.ElementAt(i) == line.ElementAt(i + 1))
                {
                    sum++;
                }
                while (i < line.Length - 1 && line.ElementAt(i) == line.ElementAt(i + 1))
                {
                    //Console.WriteLine(i);
                    sum++;
                    i++;
                }
            }
           // Console.WriteLine(sum);
            return (char)sum;
        }
    }
}
