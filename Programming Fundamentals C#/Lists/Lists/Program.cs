using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            SquareNumbers();
        }

        //reading list
        static List<int> ReadList()
        {
            return Console.ReadLine().Split(' ').Select(int.Parse).ToList();
        }

        //print list
        static void PrintList(List<int> list)
        {
            Console.WriteLine(string.Join(" ", list));
        }

        //sort list

        static void SortList(List<int> list, string sortingType)
        {
            if(sortingType == "asc")
            {
                list.Sort();
            }
            else
            {
                list.Sort();
                list.Reverse();
            }
        }

        static void SquareNumbers()
        {
            var list = ReadList();
            var squares = new List<int>();
            foreach (var num in list)
            {
                if(Math.Sqrt(num) == (int)Math.Sqrt(num))
                {
                    squares.Add(num);
                }
            }

            SortList(squares, "desc");
            PrintList(squares);
        }
    }
}
