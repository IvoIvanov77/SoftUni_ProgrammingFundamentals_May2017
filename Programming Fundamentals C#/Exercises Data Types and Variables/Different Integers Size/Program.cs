using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Different_Integers_Size
{
    class Program
    {
        static void Main(string[] args)
        {
            var number = Console.ReadLine();
            // sbyte < byte < short < ushort < int < uint < long
            string result = $"{number} can fit in:\n";
            try
            {
                sbyte sb = sbyte.Parse(number);
                result = result + "* sbyte\n";
                
            }
            catch (Exception) { }

            try
            {
                byte b = byte.Parse(number);
                result = result + "* byte\n";
            }
            catch (Exception) { }

            try
            {                
                short sh = short.Parse(number);
                result = result + "* short\n";
            }
            catch (Exception) { }

            try
            {
                ushort sb = ushort.Parse(number);
                result = result + "* ushort\n";
            }
            catch (Exception) { }

            try
            {
                int b = int.Parse(number);
                result = result + "* int\n";
            }
            catch (Exception) { }

            try
            {
                uint sh = uint.Parse(number);
                result = result + "* uint\n";
            }
            catch (Exception) { }

            try
            {
                long sh = long.Parse(number);
                result = result + "* long\n";
            }
            catch (Exception)
            {
                result = $"{number} can't fit in any type";                               
            }

            Console.WriteLine(result);

        }
    }
}
