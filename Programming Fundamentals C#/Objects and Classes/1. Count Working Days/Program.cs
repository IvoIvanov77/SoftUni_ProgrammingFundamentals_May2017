using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.Count_Working_Days
{
    class Program
    {
        static void Main(string[] args)
        {
            var start = Console.ReadLine();
            var end = Console.ReadLine();
            DateTime[] holl = Hollidays();
            
            DateTime startDate = DateTime.ParseExact(start, "dd-MM-yyyy", CultureInfo.InvariantCulture);
            DateTime endDate = DateTime.ParseExact(end, "dd-MM-yyyy", CultureInfo.InvariantCulture);
            var workingDaysCounter = 0;

            while (startDate <= endDate)
            {
                if(startDate.DayOfWeek != DayOfWeek.Saturday && startDate.DayOfWeek != DayOfWeek.Sunday 
                    && !IsHolliday(startDate, holl))
                {
                    workingDaysCounter++;
                }
                startDate = startDate.AddDays(1);
            }
            Console.WriteLine(workingDaysCounter);
        }

        static DateTime[] Hollidays()
        {
            return new DateTime[]
            {
                DateTime.ParseExact("01-01", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("03-03", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("01-05", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("06-05", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("24-05", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("06-09", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("22-09", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("01-11", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("24-12", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("25-12", "dd-MM", CultureInfo.InvariantCulture),
                DateTime.ParseExact("26-12", "dd-MM", CultureInfo.InvariantCulture),
               
            };
        }

        static bool IsHolliday(DateTime date, DateTime[] hollidays)
        {
            foreach (var holl in hollidays)
            {
                if(date.Day == holl.Day && date.Month == holl.Month)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
