using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11.Convert_Speed_Units
{
    class Program
    {
        static void Main(string[] args)
        {
            float distance = float.Parse(Console.ReadLine());
            float hours = float.Parse(Console.ReadLine());
            float minutes = float.Parse(Console.ReadLine());
            float seconds = float.Parse(Console.ReadLine());
            float miles = distance / 1609;

            float totalSeconds = hours * 3600 + minutes * 60 + seconds;

            float metersPerSeconds = distance / totalSeconds;

            float kilometerPerHour = distance / 1000 / totalSeconds * 3600;

            float milesPerHour = miles / totalSeconds * 3600;

            Console.WriteLine($"{metersPerSeconds}\n{kilometerPerHour}\n{milesPerHour}");
        }
    }
}
