using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_5.BPM_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            var BPM = int.Parse(Console.ReadLine());
            var number = double.Parse(Console.ReadLine());

            var bars = number / 4;
            int totalSeconds = (int)(number / BPM * 60);

            var minutes = totalSeconds / 60;
            var seconds = totalSeconds % 60;

            Console.WriteLine($"{Math.Round(bars,1)} bars - {minutes}m {seconds}s");
        }
    }
}
