using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Charity_Marathon
{
    class Program
    {
        static void Main(string[] args)
        {           
            var days = int.Parse(Console.ReadLine());
            var runners = int.Parse(Console.ReadLine());
            var numberOfLaps = int.Parse(Console.ReadLine());
            var lapLength = int.Parse(Console.ReadLine());
            var trackCapacity = int.Parse(Console.ReadLine());
            var moneyPerKilometer = double.Parse(Console.ReadLine());

            int totalCapacity = days * trackCapacity;

            long finalRunners = totalCapacity < runners ? totalCapacity : runners;

            long totalKm = finalRunners * numberOfLaps * lapLength / 1000;

            double totalMoney = totalKm * moneyPerKilometer;

            Console.WriteLine($"Money raised: {totalMoney:F2}");
        }
    }
}
