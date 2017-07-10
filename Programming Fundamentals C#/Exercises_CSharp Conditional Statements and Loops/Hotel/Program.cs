using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hotel
{
    class Program
    {
        static void Main(string[] args)
        {
            var month = Console.ReadLine();
            var nightsCount = int.Parse(Console.ReadLine());
           
            double studioPrise = 0;
            double doublePrise = 0;
            double suitePrise = 0;

            int studioDiscount = 0;
            int doubleDiscount = 0;
            int suiteDiscount = 0;

           

            if (month.Equals("May") || month.Equals("October"))
            {
                studioPrise = 50;
                doublePrise = 65;
                suitePrise = 75;

                if (nightsCount > 7)
                {
                    studioDiscount = 5;
                    doubleDiscount = 0;
                    suiteDiscount = 0;
                }

                
            }
            else if (month.Equals("June") || month.Equals("September"))
            {
                studioPrise = 60;
                doublePrise = 72;
                suitePrise = 82;

                if (nightsCount > 14)
                {
                    studioDiscount = 0;
                    doubleDiscount = 10;
                    suiteDiscount = 0;
                }
            }
            else
            {
                studioPrise = 68;
                doublePrise = 77;
                suitePrise = 89;

                if (nightsCount > 14)
                {
                    studioDiscount = 0;
                    doubleDiscount = 0;
                    suiteDiscount = 15;
                }
            }

            if (nightsCount > 7 && (month.Equals("September") || month.Equals("October")))
            {
                studioPrise = studioPrise - studioPrise/nightsCount;
            }       

            Console.WriteLine($"Studio: {(studioPrise * nightsCount)*(100 - studioDiscount)/100:F2} lv.");
            Console.WriteLine($"Double: {(doublePrise * nightsCount) * (100 - doubleDiscount) / 100:F2} lv.");
            Console.WriteLine($"Suite: {(suitePrise * nightsCount) * (100 - suiteDiscount) / 100:F2} lv." );
        }
   
    }
}
