using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DNA_Sequences
{
    class Program
    {
        static void Main(string[] args)
        {
            var number = int.Parse(Console.ReadLine());
            for (int i = 1; i <= 4; i++)
            {
                for (int j = 1; j <= 4; j++)
                {
                    for (int k = 1; k <= 4; k++)
                    {
                        int sum = i + j + k;
                        char ch = sum >= number ? 'O' : 'X';
                        Console.Write($"{ch}{digitToString(i, j, k)}{ch} ");
                        if(k == 4)
                        {
                            Console.WriteLine();
                        }
                    }
                }
            }
        }

        static String digitToString(int i, int j, int k)
        {
            String result = "";
            result = result + digitToCharacter(i);
            result = result + digitToCharacter(j);
            result = result + digitToCharacter(k);
            return result;
        }

        static char digitToCharacter(int i)
        {
            switch (i)
            {
                case 1: return 'A';
                case 2: return 'C';
                case 3: return 'G';
                case 4: return 'T';
                default: return ' ';
            }
        }
    }
}
