using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Neighbour_Wars
{
    class Program
    {
        static void Main(string[] args)
        {
            int PDamage = int.Parse(Console.ReadLine());
            int GDamage = int.Parse(Console.ReadLine());

            int PHealt = 100;
            int GHealt = 100;

            int tour = 1;
            while (true)
            {
                if(tour % 2 == 0)
                {
                    PHealt -= GDamage;
                    if (PHealt <= 0)
                    {
                        break;
                    }
                    Console.WriteLine("Gosho used Thunderous fist and reduced Pesho to {0} health.", PHealt);
                }
                else
                {
                    GHealt -= PDamage;
                    if (GHealt <= 0)
                    {
                        break;
                    }
                    Console.WriteLine("Pesho used Roundhouse kick and reduced Gosho to {0} health.", GHealt);
                }
                
                if(tour % 3 == 0)
                {
                    PHealt += 10;
                    GHealt += 10;
                }
                tour++;

            }

            String winner = PHealt > 0 ? "Pesho" : "Gosho";

            Console.WriteLine("{0} won in {1}th round.", winner, tour);
        }
    }
}
