using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Mines
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            MatchCollection matches = Regex.Matches(line, "<(.)(.)>");

            StringBuilder b = new StringBuilder(line);

            foreach(Match m in matches)
            {
                int count = Math.Abs((int)m.Groups[1].Value[0] - (int)m.Groups[2].Value[0]);
                int start = m.Index - count < 0 ? 0 : m.Index - count;
                int len = start + 2 * count + m.Length > b.Length  ? b.Length - start : 2 * count + m.Length;
                if(start == 0)
                {
                    len = m.Index + count +  m.Length;
                }
                b.Remove(start, len);
                b.Insert(start, "_", len);
            }

            Console.WriteLine(b.ToString());
        }
    }
}
