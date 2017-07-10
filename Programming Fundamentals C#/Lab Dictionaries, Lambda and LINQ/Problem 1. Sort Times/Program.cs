using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_1.Sort_Times
{
    class Program
    {
        static void Main(string[] args)
        {
            var times = Console.ReadLine().Split(' ').Select(s => new Time(s))
                .OrderBy(time => time.Hour)
                .ThenBy(time => time.Minits).ToList();

            Console.WriteLine(string.Join(", ", times));    

            
        }
    }

    class Time
    {
        public int Hour { get; set; }
        public int Minits { get; set; }

        public Time(string s)
        {
            var input = s.Split(':');
            this.Hour = int.Parse(input[0]);
            this.Minits = int.Parse(input[1]);

        }

        public override String ToString()
        {
            return $"{this.Hour:D2}:{this.Minits:D2}";
        }

       


    }

}
