using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_7.TakeOrSkip_Rope
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().ToCharArray();
            var leters = input.Where(ch => !char.IsDigit(ch)).ToArray();
            var digits = input.Where(ch => char.IsDigit(ch)).Select(ch => (int)(ch - '0')).ToArray();

            var takeList = digits.Where((digit, i) => i % 2 == 0).ToList();
            var skipList = digits.Where((digit, i) => i % 2 != 0).ToList();

            var index = 0;
            List<char> result = new List<char>();
            for (int i = 0; i < takeList.Count; i++)
            {
                var chars = leters.Skip(index).Take(takeList[i]).ToArray();
                result.AddRange(chars);
                index += takeList[i] + skipList[i];
            }

            Console.WriteLine(string.Join("", result));
        }
    }
}
