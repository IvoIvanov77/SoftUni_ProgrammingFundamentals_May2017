using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_3.Immune_System
{
    class Program
    {
        static void Main(string[] args)
        {
            var initialHealth = long.Parse(Console.ReadLine());
            var remaining = initialHealth;
            var line = Console.ReadLine();

            Dictionary<string, long> viruses = new Dictionary<string, long>();

            while(line != "end")
            {
                var virus = line;
                long virusStrength = GetStrength(virus);
                long secondsToDefeat;
                if (!viruses.ContainsKey(virus))
                {
                    secondsToDefeat = virusStrength * virus.Length;
                    viruses[virus] = secondsToDefeat;
                }
                else
                {
                    secondsToDefeat = viruses[virus] / 3;
                }
                Console.WriteLine($"Virus {virus}: {virusStrength} => {secondsToDefeat} seconds");

                if (remaining > secondsToDefeat)
                {
                    long remainingHealth = remaining - secondsToDefeat;                    
                    DefeatedVirus(secondsToDefeat, virus);
                    Console.WriteLine($"Remaining health: {remainingHealth}");
                    long newHealt = (long)(remainingHealth * 1.2);
                    if(newHealt < initialHealth)
                    {
                        remaining = newHealt;
                    }
                    else
                    {
                        remaining = initialHealth;
                    }
                }
                else
                {
                    Console.WriteLine("Immune System Defeated.");
                    return;
                }
                line = Console.ReadLine();
            }
            Console.WriteLine($"Final Health: {remaining}");
        }

        static long GetStrength(string virus)
        {
            return virus.ToCharArray().Select(ch => (int)ch).Sum() / 3;
        }

        static void DefeatedVirus(long secondsToDefeat, string name)
        {
            long minits = secondsToDefeat / 60;
            long seconds = secondsToDefeat % 60;
            Console.WriteLine($"{name} defeated in {minits}m {seconds}s.");
                
        }
    }
}
