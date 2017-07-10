using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12.Rectangle_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double height = double.Parse(Console.ReadLine());
            double width = double.Parse(Console.ReadLine());

            double perimeter = (height + width) * 2;
            double area = height * width;
            double diagonal = Math.Sqrt(Math.Pow(height, 2) + Math.Pow(width,2));

            Console.WriteLine($"{perimeter}\n{area}\n{diagonal}");
        }

    }
}
