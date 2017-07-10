using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10.Price_Change_Alert
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            double significance = double.Parse(Console.ReadLine());
            double lastPrice = double.Parse(Console.ReadLine());

            for (int i = 0; i < n - 1; i++)
            {
                double currentPrice = double.Parse(Console.ReadLine());
                double div = DivInPercent(lastPrice, currentPrice);
                bool isSignificantDifference = IsSignificantDifference(div, significance);
                string message = GetMessage(currentPrice, lastPrice, div, isSignificantDifference);
                Console.WriteLine(message);

                lastPrice = currentPrice;
            }
        }

        private static string GetMessage(double currentPrice, double lastPrice, double difference, bool isSignificantDifference)            
        {
            string message = "";
            if (difference == 0)
            {
                message = string.Format("NO CHANGE: {0}", currentPrice);
            }

            else if (!isSignificantDifference)
            {
                message = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
            }

            else if (isSignificantDifference && (difference > 0))
            {
                message = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
            }

            else if (isSignificantDifference && (difference < 0))
            {
                message = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference * 100);
            }
            
            return message;
        }

        private static bool IsSignificantDifference(double significance, double difference)
        {
            if (Math.Abs(significance) >= difference)
            {
                return true;
            }
            return false;
        }

        private static double DivInPercent(double last, double current)
        {
            double r = (current - last) / last;
            return r;
        }
    }
}
