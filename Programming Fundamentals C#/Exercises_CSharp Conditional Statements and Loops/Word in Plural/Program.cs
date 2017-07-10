using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Word_in_Plural
{
    class Program
    {
        static void Main(string[] args)
        {
            String word = Console.ReadLine();

            if (word.EndsWith("y"))
            {
                word = word.Remove(word.Length - 1);
                word = word + "ies";
            }
            else if(new String [] {"o", "ch", "s", "sh", "x", "z"}.Any(ext => word.EndsWith(ext)))
            {
                word = word + "es";
            }
            else word = word + "s";

            Console.WriteLine(word);
        }
    }
}
