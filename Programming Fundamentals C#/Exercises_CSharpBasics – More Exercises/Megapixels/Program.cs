using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Megapixels
{
    class Program
    {
        static void Main(string[] args)
        {
            double width = double.Parse(Console.ReadLine()) ;
            double height = double.Parse(Console.ReadLine()) ;

            Console.WriteLine($"{width}x{height} => {Math.Round(width*height/1000000, 1)}MP");
        }
    }
}
