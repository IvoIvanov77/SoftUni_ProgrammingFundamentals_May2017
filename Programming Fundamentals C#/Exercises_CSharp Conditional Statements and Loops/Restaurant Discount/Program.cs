using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Restaurant_Discount
{
    class Program
    {
        static void Main(string[] args)
        {
            var group = int.Parse(Console.ReadLine());
            var package = Console.ReadLine();
            var diskount = 0;

            double groupPrise;

            double packagePrise = 0;

            String hall;

            if(group > 120)
            {
                Console.WriteLine("We do not have an appropriate hall.");
                return;
            }

            if(group <= 50)
            {
                groupPrise = 2500;
                hall = "Small Hall";
            }
            else if (group > 50 && group <= 100)
            {
                groupPrise = 5000;
                hall = "Terrace";
            }
            else
            {
                groupPrise = 7500;
                hall = "Great Hall";
            }

            switch (package)
            {
                case "Normal":
                    packagePrise = 500;
                    diskount = 5;
                    break;
                case "Gold":
                    packagePrise = 750;
                    diskount = 10;
                    break;
                case "Platinum":
                    packagePrise = 1000;
                    diskount = 15;
                    break;
            }

            Console.WriteLine($"We can offer you the {hall}");
            Console.WriteLine($"The price per person is {(groupPrise + packagePrise)*(100 - diskount)/100/group:F2}$");

        }
    }
}
