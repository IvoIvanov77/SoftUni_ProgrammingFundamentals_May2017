using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SMS_Typing
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            String result = String.Empty;

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                int numberOfDigits = countDigits(number);
                int mainDigit = number % 10;
                int offset = (mainDigit - 2) * 3;
                if (mainDigit == 8 || mainDigit == 9) offset += 1;
                int letterIndex = offset + numberOfDigits - 1;
                char ch = number!= 0 ? (char)('a' + letterIndex) : ' ';
                result += ch;
            }

            Console.WriteLine(result);
        }

        static int countDigits(int number)
        {
            int count = 1;
            while ((number = number / 10) != 0)
            {
                count++;
            }
            return count;
        }
    }

    
}
