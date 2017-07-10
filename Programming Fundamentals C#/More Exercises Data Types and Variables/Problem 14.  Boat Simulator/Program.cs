using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_14.Boat_Simulator
{
    class Program
    {
        static void Main(string[] args)
        {
            int firstBoat = (int)char.Parse(Console.ReadLine());
            int secondBoat = (int)char.Parse(Console.ReadLine());
            int n = int.Parse(Console.ReadLine());

            int firstBoatTiles = 0;
            int secondBoatTiles = 0;


            for (int i = 1; i <= n; i++)
            {
                String line = Console.ReadLine();
                if (line.Equals("UPGRADE"))
                {
                    firstBoat += 3;
                    secondBoat += 3;
                }
                else if(i % 2 != 0)
                {
                    firstBoatTiles += line.Length;
                    if(firstBoatTiles >= 50)
                    {
                        Console.WriteLine((char)firstBoat);
                        return;
                    }
                }
                else
                {
                    secondBoatTiles += line.Length;
                    if (secondBoatTiles >= 50)
                    {
                        Console.WriteLine((char)secondBoat);
                        return;
                    }
                }
            }
            if(firstBoatTiles > secondBoatTiles)
            {
                Console.WriteLine((char)firstBoat);
            }
            else
            {
                Console.WriteLine((char)secondBoat);
            }
            

        }
    }
}
