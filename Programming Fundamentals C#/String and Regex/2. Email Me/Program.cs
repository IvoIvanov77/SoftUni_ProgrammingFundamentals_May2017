using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.Email_Me
{
    class Program
    {
        static void Main(string[] args)
        {
            var email = Console.ReadLine();
            var input = email.Split('@');
            if(input[0].Select(ch => (int)ch).Sum() >= input[1].Select(ch => (int)ch).Sum())
            {
                Console.WriteLine("Call her!");
            }
            else
            {
                Console.WriteLine("She is not the one.");
            }

        }
    }
}
