using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            //DayOfWeek();
            // RandomizeWords();
            //BigFactorial();
            //DistanceBetweenPoints();
            ClosestTwoPoints();
        }

        static void DayOfWeek()
        {
            string dateAsText = Console.ReadLine();
            DateTime date = DateTime.ParseExact(dateAsText, "d-M-yyyy", CultureInfo.InvariantCulture);
            Console.WriteLine(date.DayOfWeek);
        }

        static void RandomizeWords()
        {
            string[] words = Console.ReadLine().Split(' ');
            Random r = new Random();

            for (int i = 0; i < words.Length; i++)
            {
                int j = r.Next(words.Length);
                var tmp = words[i];
                words[i] = words[j];
                words[j] = tmp;
            }

            Console.WriteLine(string.Join("\n", words));
        }

        static void BigFactorial()
        {
            int n = int.Parse(Console.ReadLine());
            BigInteger bi = 1;

            for (int i = 2; i <= n; i++)
            {
                bi *= i;
            }
            Console.WriteLine(bi);
        }

        static void DistanceBetweenPoints()
        {
            var p1 = ReadPoint();
            var p2 = ReadPoint();
            Console.WriteLine(p1.Distance(p2));
        }

        static Point ReadPoint()
        {
            var coor = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            return new Point(coor[0], coor[1]);
        }

        static void ClosestTwoPoints()
        {
            var n = int.Parse(Console.ReadLine());
            Point[] points = new Point[n];
            for (int i = 0; i < n; i++)
            {
                points[i] = ReadPoint();
            }
            FindClosestPoint(points);
        }

        static void FindClosestPoint(Point[] arr)
        {
            double minDist = Double.MaxValue;
            Point p1 = null;
            Point p2 = null;
            for (int i = 0; i < arr.Length - 1; i++)
            {
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if(arr[i].Distance(arr[j]) < minDist)
                    {
                        minDist = arr[i].Distance(arr[j]);
                        p1 = arr[i];
                        p2 = arr[j];
                    }
                }
            }
            Console.WriteLine(minDist);
            Console.WriteLine(p1);
            Console.WriteLine(p2);
        }
    }

    class Point
    {      

        public int X { get; set; }
        public int Y { get; set; }

        public Point(int x, int y)
        {
            X = x;
            Y = y;
        }

        public double Distance(Point a)
        {
           return CalculateDistance(this, a);
        }

        public static double CalculateDistance(Point one, Point two)
        {
            return Math.Sqrt(Math.Pow((one.X - two.X), 2) + Math.Pow((one.Y - two.Y), 2));
        }

        public override string ToString()
        {
            return "(" + this.X + ", " + this.Y + ")";
        }
    }
}
