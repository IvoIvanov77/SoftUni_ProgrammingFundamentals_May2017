using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_5.Weather_Forecast
{
    class Program
    {
        static void Main(string[] args)
        {
            var number = Console.ReadLine();

            try
            {
                sbyte sb = sbyte.Parse(number);
                Console.WriteLine("Sunny");
            }
            catch (Exception)
            {
                try
                {
                    int n = int.Parse(number);
                    Console.WriteLine("Cloudy");
                }
                catch (Exception)
                {
                    try
                    {
                        long l= long.Parse(number);
                        Console.WriteLine("Windy");
                    }
                    catch (Exception)
                    {
                        Console.WriteLine("Rainy");
                    }
                }
               
            }
        }
    }
}
