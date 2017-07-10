using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Censorship
{
    class Program
    {
        static void Main(string[] args)
        {
            var censor = Console.ReadLine();
            var senetence = Console.ReadLine();

            Console.WriteLine(senetence.Replace(censor, new String('*', censor.Length)));

        }
    }
}
