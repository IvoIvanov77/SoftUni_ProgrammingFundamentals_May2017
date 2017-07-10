using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace SoftUni_Coffee_Orders
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            
            decimal grandTotal = 0;

            for (int i = 0; i < n; i++)
            {
                decimal price = decimal.Parse(Console.ReadLine());
                DateTime date = DateTime.ParseExact(Console.ReadLine(), "d/M/yyyy", CultureInfo.InvariantCulture);
                int capsules = int.Parse(Console.ReadLine());
                var month  = date.Month;
                var year = date.Year;
                var daysInMonth = DateTime.DaysInMonth(year, month);
                decimal totalPrice = price * daysInMonth * capsules;
                grandTotal += totalPrice;
                Console.WriteLine($"The price for the coffee is: ${totalPrice:F2}");
            }

            Console.WriteLine($"Total: ${grandTotal:F2}");
        }
    }
}
