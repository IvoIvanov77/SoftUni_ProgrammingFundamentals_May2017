using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Photo_Gallery
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());
            int day = int.Parse(Console.ReadLine());
            int month = int.Parse(Console.ReadLine());
            int year = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());
            double size = double.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            int height = int.Parse(Console.ReadLine());

            String formatetSize;
            if(size < 1000) formatetSize = String.Format("{0}B",size);
            else if(size < 1000000) formatetSize = String.Format("{0}KB", Math.Round(size/1000));
            else formatetSize = String.Format("{0}MB", Math.Round(size / 1000000, 1));

            String orientation;
            if (width > height) orientation = "landscape";
            else if(width < height) orientation = "portrait";
            else orientation = "square";

            Console.WriteLine($"Name: DSC_{number:D4}.jpg");
            Console.WriteLine($"Date Taken: {day:D2}/{month:D2}/{year} {hours:D2}:{minutes:D2}");
            Console.WriteLine($"Size: {formatetSize}");
            Console.WriteLine($"Resolution: {width}x{height} ({orientation})");      


        }
    }
}
