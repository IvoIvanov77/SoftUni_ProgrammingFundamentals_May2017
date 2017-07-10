using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Winning_Ticket
{
    class Program
    {
        static void Main(string[] args)
        {
            var tickets = Regex.Split(Console.ReadLine().Trim(), @"\s*,\s+");

            foreach (var t in tickets)
            {
                Ticket ticket = new Ticket(t);
                if (!ticket.IsValid())
                {
                    Console.WriteLine("invalid ticket");
                    continue;
                }
                if (ticket.IsWinning())
                {
                    if (ticket.IsJakpot())
                    {
                        Console.WriteLine($"ticket \"{t}\" - {ticket.Count}{ticket.Win} Jackpot!");
                    }
                    else
                    {
                        Console.WriteLine($"ticket \"{t}\" - {ticket.Count}{ticket.Win}");
                    }
                }
                else
                {
                    Console.WriteLine($"ticket \"{t}\" - no match");
                }
            }
        }  


    }

    class Ticket
    {
        private string line;
        char[] symbols = { '@', '#', '$', '^' };
        char win;
        int count;

        public Ticket(string line)
        {
            this.line = line;
        }

        public char Win { get => win; set => win = value; }
        public int Count { get => count; set => count = value; }

        public bool IsValid()
        {
            return this.line.Length == 20;
        }

        public bool IsWinning() { 

            var firstHalf = line.Substring(0, 10);
            var secondHalf = line.Substring(10);
            for (int i = 0; i < symbols.Length; i++)
            {
                if(GetCharCount(firstHalf, symbols[i]) >= 6 
                    && GetCharCount(secondHalf, symbols[i]) >= 6)
                {
                    this.Win = symbols[i];
                    this.Count = Math.Min(GetCharCount(firstHalf, symbols[i]), 
                        GetCharCount(secondHalf, symbols[i]));
                    return true;
                }
            }
            return false;
        }

        public bool IsJakpot()
        {
            return GetCharCount(line, this.win) == 20;
        }


        private int GetCharCount(String line, char ch)
        {
            int count = 0;
            for (int i = 0; i < line.Length - 1; i++)
            {
                if (line[i] == ch)
                {
                    int counter = 1;
                    while (i < line.Length - 1 && line[++i] == ch)
                    {
                        counter++;
                    }
                    if (counter > count)
                    {
                        count = counter;
                    }
                }
            }
            return count;
        }
    }
}
