using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Theatre_Promotions
{
    class Program
    {
        static void Main(string[] args)
        {
            var day = Console.ReadLine();
            var age = int.Parse(Console.ReadLine());
            int price;

            if(age > 122 || age < 0)
            {
                Console.WriteLine("Error!");
                return;
            }

            if(age >= 0 && age <= 18)
            {
                if (day.Equals("Weekday"))
                {
                    price = 12;
                }
                else if (day.Equals("Weekend"))
                {
                    price = 15;
                }
                else
                {
                    price = 5;
                }
            }
            else if(age > 0 && age <= 64)
            {
                if (day.Equals("Weekday"))
                {
                    price = 18;
                }
                else if (day.Equals("Weekend"))
                {
                    price = 20;
                }
                else
                {
                    price = 12;
                }
            }
            else
            {
                if (day.Equals("Weekday"))
                {
                    price = 12;
                }
                else if (day.Equals("Weekend"))
                {
                    price = 15;
                }
                else
                {
                    price = 10;
                }
            }

            Console.WriteLine("{0}$", price);
        }
    }
}
