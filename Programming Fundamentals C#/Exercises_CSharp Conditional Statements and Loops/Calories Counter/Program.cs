using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calories_Counter
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int calories = 0;
            for (int i = 0; i < n; i++)
            {
                var ingredient = Console.ReadLine().ToLower();

                if (ingredient.Equals("cheese"))
                {
                    calories += 500;
                }
                else if (ingredient.Equals("tomato sauce"))
                {
                    calories += 150;
                }
                else if (ingredient.Equals("salami"))
                {
                    calories += 600;
                }
                else if (ingredient.Equals("pepper"))
                {
                    calories += 50;
                }
            }
            Console.WriteLine($"Total calories: {calories}");
        }
    }
}
