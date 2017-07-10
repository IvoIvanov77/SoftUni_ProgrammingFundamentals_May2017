using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Foreign_Languages
{
    class Program
    {
        static void Main(string[] args)
        {
            var country = Console.ReadLine();

            switch (country)
            {
                case "England" :     
                    
                case "USA":
                    Console.WriteLine("English");
                    break;
                case "Spain":                
                    
                case "Mexico":
                   
                case "Argentina":
                    Console.WriteLine("Spanish");
                    break;                
                default:
                    Console.WriteLine("unknown");
                    break;

            }
        }
    }
}
