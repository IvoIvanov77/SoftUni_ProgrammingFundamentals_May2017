using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Balanced_Brackets
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            bool hasOpening = false;

            for (int i = 0; i < n; i++)
            {
                String line = Console.ReadLine();
                if (line.Equals("("))
                {
                    if (hasOpening)
                    {
                        Console.WriteLine("UNBALANCED");
                        return;
                    }
                    else
                    {
                        hasOpening = true;
                    }
                }
                else if (line.Equals(")"))
                {
                    if (!hasOpening)
                    {
                        Console.WriteLine("UNBALANCED");
                        return;
                    }
                    else
                    {
                        hasOpening = false;
                    }
                }
            }
            if(hasOpening) Console.WriteLine("UNBALANCED");
            else Console.WriteLine("BALANCED");
        }
    }
}
