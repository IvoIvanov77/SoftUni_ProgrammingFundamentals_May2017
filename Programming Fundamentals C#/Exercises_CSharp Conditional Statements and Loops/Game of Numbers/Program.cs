using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game_of_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n1 = int.Parse(Console.ReadLine());
            int n2 = int.Parse(Console.ReadLine());
            int magic = int.Parse(Console.ReadLine());           
            int combination = 0;

            for (int i = n2; i >= n1; i--)
            {
                for (int j = n2; j >= n1; j--)
                {
                    if(i + j == magic)
                    {
                        Console.WriteLine($"Number found! {i} + {j} = {magic}");
                        return;
                    }
                    combination++;
                }
            }

            Console.WriteLine($"{combination} combinations - neither equals {magic}");
        }
    }
}
