using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Use_Your_Chains_Buddy
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();

            MatchCollection matches = Regex.Matches(line, @"(?<=<p>).*?(?=<\/p>)");
            StringBuilder b = new StringBuilder();

            foreach (Match m in matches)
            {
                //Console.WriteLine(m.Value);
                string result = ReplaceWithASpace(m.Value);
                result = ChangeAllLeters(result);
                b.Append(ReplaceSpaces(result));
            }

            Console.WriteLine(b.ToString());

        }

        static string ReplaceWithASpace(string input)
        {
            return Regex.Replace(input, "[^a-z0-9]", " ");

        }

        static string ChangeAllLeters(string input)
        {
            var arr = input.ToCharArray().Select(ch => ReplaceChar(ch)).ToArray();

            return new string(arr);
        }

        static char ReplaceChar(char ch)
        {
            if(ch >= 'a' && ch <= 'm')
            {
                return (char)(ch + 13);
            }
            else if(ch >= 'n' && ch <= 'z')
            {
                return (char)(ch - 13);
            }
            else
            {
                return ch;
            }
        }

        static string ReplaceSpaces(string input)
        {
            return Regex.Replace(input, @"[\s]{2,}", " ");
        }
    }
}
