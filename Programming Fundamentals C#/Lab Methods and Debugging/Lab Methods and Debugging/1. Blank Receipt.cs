using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_Methods_and_Debugging
{
    class BlankReceipt
    {
        static void Main(string[] args)
        {
            //PrintReciept();    
            //int n = int.Parse(Console.ReadLine());
            //PrintSign(n);
            //PrintFilledSquare(n);
            PrintTriangleArea();
        }

        static void PrintRecieptHeader()
        {
            Console.WriteLine("CASH PECIEPT");
            Console.WriteLine("------------------------------");
        }

        static void PrintRecieptBody()
        {
            Console.WriteLine("Charged to____________________");
            Console.WriteLine("Received by___________________");
        }

        static void PrintRecieptFooter()
        {
            Console.WriteLine("------------------------------");
            Console.WriteLine("@© SoftUni");
        }

        static void PrintReciept()
        {
            PrintRecieptHeader();
            PrintRecieptBody();
            PrintRecieptFooter();
        }

        static void PrintSign(int n)
        {
            if (n > 0)
            {
                Console.WriteLine($"The number {n} is positive.");
            }
            else if(n < 0)
            {
                Console.WriteLine($"The number {n} is negative.");
            }
            else
            {
                Console.WriteLine($"The number {n} is zero.");
            }

        }

        static void PrintHeaderRow(int n)
        {            
            Console.WriteLine(new string('-', 2 * n));
        }

        static void PrintMidleRow(int n)
        {
            Console.Write("-");
            for (int i = 1; i < n; i++)
            {
                Console.Write("\\/");
            }
            Console.WriteLine("-");
        }

        static void PrintFilledSquare(int n)
        {
            PrintHeaderRow(n);
            for (int i = 1; i < n - 1; i++)
            {
                PrintMidleRow(n);
            }            
            PrintHeaderRow(n);
        }

        static double GetTriangleArea(double width, double height)
        {
            return width * height / 2;
        }

        static void PrintTriangleArea()
        {
            double width = double.Parse(Console.ReadLine());
            double height = double.Parse(Console.ReadLine());
            Console.WriteLine(GetTriangleArea(width, height));
        }
    }
}
