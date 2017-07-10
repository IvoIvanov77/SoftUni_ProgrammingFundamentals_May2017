using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _13.Vowel_or_Digit
{
    class Program
    {
        static void Main(string[] args)
        {
            Char ch = Char.Parse(Console.ReadLine().ToLower());
            if (IsDigit(ch))
            {
                Console.WriteLine("digit");
            }
            else if (IsVowel(ch))
            {
                Console.WriteLine("vowel");
            }
            else Console.WriteLine("other");
        }

        static bool IsDigit(char ch)
        {
            return ch.Equals('0') || ch.Equals('1')
                || ch.Equals('2') || ch.Equals('3')
                || ch.Equals('4') || ch.Equals('5')
                || ch.Equals('6') || ch.Equals('7')
                || ch.Equals('8') || ch.Equals('9');
        }

        static bool IsVowel(char ch)
        {
            return ch.Equals('a') || ch.Equals('e')
                || ch.Equals('i') || ch.Equals('o')
                || ch.Equals('u') ;
        }
    }
}
