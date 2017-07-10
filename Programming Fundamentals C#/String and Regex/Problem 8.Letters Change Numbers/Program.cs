using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Problem_8.Letters_Change_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = new Regex("\\s+").Split(Console.ReadLine()).Where(s => s != string.Empty);
            //Console.WriteLine(string.Join(", ", input));
            double total = 0;
            foreach (var str in input)
            {                               
                total += Calculate(str);                  
            }
            Console.WriteLine($"{total:F2}");
        }

        static int GetAlphabetPosition(char leter)
        {
            return Char.ToLower(leter) - 'a' + 1;
        }

        static double Calculate(string str)
        {
            Regex leters = new Regex("[A-Za-z]");
            Regex number = new Regex("\\d+");

            var letersMatch = leters.Match(str);
            char leftLeter = letersMatch.Value[0];
            char rightLeter = letersMatch.NextMatch().Value[0];
            var numberMatch = number.Match(str).Value;
            double result = 0;

            if (char.IsUpper(leftLeter))
            {
                result += double.Parse(numberMatch) / GetAlphabetPosition(leftLeter);
               
            }
            else
            {
                result += double.Parse(numberMatch) * GetAlphabetPosition(leftLeter);
            }

            if (char.IsUpper(rightLeter))
            {
                result -= GetAlphabetPosition(rightLeter);
            }
            else
            {
                result  +=  GetAlphabetPosition(rightLeter);
                
            }
            
            return result;
        }
    }
}
