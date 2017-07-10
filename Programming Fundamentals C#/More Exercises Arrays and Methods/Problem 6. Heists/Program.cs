using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_6.Heists
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] prices = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int jewelsPrice = prices[0];
            int goldPrice = prices[1];

            var line = Console.ReadLine();
            long totalJail = 0;
            long totalExpenses = 0;

            while (!line.Equals("Jail Time"))
            {
                string[] input = line.Split(' ');
                string lot = input[0];
                int heistExpenses = int.Parse(input[1]);
                totalJail += GetJail(lot, jewelsPrice, goldPrice);
                totalExpenses += heistExpenses;
                line = Console.ReadLine();
            }

            long diff = totalJail - totalExpenses;

            if(diff < 0)
            {
                Console.WriteLine($"Have to find another job. Lost: {Math.Abs(diff)}.");
            }
            else
            {                
                Console.WriteLine($"Heists will continue. Total earnings: {diff}.");
            }
        }

        private static int GetJail(string lot, int jewelsPrice, int goldPrice)
        {
            int jail = 0;
            foreach (char ch in lot)
            {
                if(ch == '%')
                {
                    jail += jewelsPrice;
                }
                else if(ch == '$')
                {
                    jail += goldPrice;
                }
            }
            return jail;
        }
    }
}
