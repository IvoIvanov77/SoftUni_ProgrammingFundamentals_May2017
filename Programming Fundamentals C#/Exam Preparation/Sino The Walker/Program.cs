using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Sino_The_Walker
{
    class Program
    {
        static void Main(string[] args)
        {
            var timeToLive = Console.ReadLine();
            int steps = int.Parse(Console.ReadLine()) % 86400;
            int timeForStep = int.Parse(Console.ReadLine()) % 86400;

            int totalTimeInSeconds = steps * timeForStep;

            int seconds = totalTimeInSeconds % 60;

            int minits = totalTimeInSeconds % 3600 / 60;

            int hours = totalTimeInSeconds / 3600;
          //  Console.WriteLine($"{hours} - {minits} - {seconds}");

            Console.WriteLine(addTime(timeToLive, hours, minits, seconds));

        }

        static string addTime(String time, int hours, int minits, int seconds)
        {
            int[] timeArr = time.Split(':').Select(int.Parse).ToArray();
            timeArr[0] += hours;
            timeArr[1] += minits;
            timeArr[2] += seconds;

            int newSeconds = timeArr[2] % 60;
            

            if (timeArr[2] / 60 != 0)
            {
                timeArr[1] += 1;

            }

            int newMinits = timeArr[1] % 60;

           
            if (timeArr[1] / 60 != 0)
            {
                timeArr[0] += 1;
            }

            int newHours = timeArr[0] % 24;

            return $"Time Arrival: {newHours:D2}:{newMinits:D2}:{newSeconds:D2}";

        }
    }
}
