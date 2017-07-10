using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            var str = Console.ReadLine();

            var arr = Regex.Split(str, "\\s+").Where(s => s != String.Empty).ToArray(); 

            string line = Console.ReadLine();

            while (line != "end")
            {
                var command = line.Split(' ')[0];
                if (command == "reverse" || command == "sort")
                {
                    Regex r = new Regex("[-]?\\d+");
                    var match = r.Match(line);
                    int index = int.Parse(match.Value);
                    if(index >= arr.Length)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        line = Console.ReadLine();
                        continue;
                    }
                    int count = int.Parse(match.NextMatch().Value);
                    switch (command)
                    {
                        case "reverse":
                            {
                                try
                                {
                                    Array.Reverse(arr, index, count);
                                }
                                catch (Exception)
                                {
                                    Console.WriteLine("Invalid input parameters.");
                                }
                                break;
                            }

                        case "sort":
                            {
                                try
                                {
                                    Array.Sort(arr, index, count);
                                }
                                catch (Exception)
                                {
                                    Console.WriteLine("Invalid input parameters.");
                                }
                                break;
                            }

                    }
                }
                else
                {
                    Regex r = new Regex("[-]?\\d+");
                    var match = r.Match(line);
                    int count = int.Parse(match.Value);
                    if(count < 0)
                    {
                        Console.WriteLine("Invalid input parameters.");
                        line = Console.ReadLine();
                        continue;
                    }
                    int ofset = count % arr.Length;
                    switch (command)
                    {
                        case "rollLeft": arr = arr.Skip(ofset).Concat(arr.Take(ofset)).ToArray();
                            break;
                        case "rollRight": arr = arr.Skip(arr.Length - ofset).Concat(arr.Take(arr.Length - ofset)).ToArray();
                            break;
                    }
                }
                
                line = Console.ReadLine();
            }              
            Console.WriteLine("[" + string.Join(", ", arr) + "]");           
        }
    }
}
