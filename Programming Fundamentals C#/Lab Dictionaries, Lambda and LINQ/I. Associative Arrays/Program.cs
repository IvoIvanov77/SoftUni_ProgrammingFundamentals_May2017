using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace I.Associative_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            //CountRealNumber();
            OddOccurrences();
        }

        static void CountRealNumber()
        {
            List<double> numbers = Console.ReadLine().Split(' ').Select(double.Parse).ToList();
            var result = new SortedDictionary<double, int>();

            foreach (var item in numbers)
            {
                if (result.ContainsKey(item))
                {
                    result[item] += 1;
                }
                else
                {
                    result[item] = 1;
                }
            }

            foreach (var pair in result)
            {
                Console.WriteLine("{0} -> {1} times", pair.Key, pair.Value);
            }
            
        }

        static void OddOccurrences()
        {
            var words = Console.ReadLine().ToLower().Split(' ');
            Dictionary<string, int> occurrence = new Dictionary<string, int>();
            foreach (var word in words)
            {
                if (occurrence.ContainsKey(word))
                {
                    occurrence[word] += 1;
                }
                else
                {
                    occurrence[word] = 1;
                }
            }
            List<string> result = occurrence.Keys.Where(s => occurrence[s] % 2 != 0).ToList();
            Console.WriteLine(string.Join(", ", result));
        }
    }
}
