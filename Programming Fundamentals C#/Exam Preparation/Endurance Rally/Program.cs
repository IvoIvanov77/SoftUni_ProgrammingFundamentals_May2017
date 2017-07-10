using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Endurance_Rally
{
    class Program
    {
        static void Main(string[] args)
        {
            var drivers = Console.ReadLine().Split(' ');
            var zones = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();
            var checkpoints = Console.ReadLine().Split(' ').Select(int.Parse);

            foreach(var dr in drivers)
            {
                double fuel = dr[0];
                int index = 0;
                for (int i = 0; i < zones.Count(); i++)
                {
                    if (checkpoints.Contains(i))
                    {
                        fuel += zones[i];
                    }
                    else
                    {
                        fuel -= zones[i];
                    }
                    if (fuel <= 0)
                    {
                        index = i;
                        break;
                    }                                    
                                       
                }
                if (fuel <= 0)
                {
                    Console.WriteLine($"{dr} - reached {index}");
                }
                else
                {
                    Console.WriteLine($"{dr} - fuel left {fuel:F2}");
                }

            }

        }
    }
}
