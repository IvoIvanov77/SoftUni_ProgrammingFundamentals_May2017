using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab
{
    class Program
    {
        static void Main(string[] args)
        {
            OddLines();
        }

        static void OddLines()
        {
            string[] lines = File.ReadAllLines("input.txt");
            var oddLines = lines.Where((line, index) => index % 2 != 0);
            File.WriteAllLines("odd-lines.txt", oddLines);

        }
    }

    
}
