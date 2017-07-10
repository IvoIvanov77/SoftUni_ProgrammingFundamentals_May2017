using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_7.Sentence_the_Thief
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();
            int n = int.Parse(Console.ReadLine());

            switch (type)
            {
                case "sbyte":
                    {
                        sbyte max = sbyte.MinValue;
                        for (int i = 0; i < n; i++)
                        {
                            try
                            {
                                sbyte id = sbyte.Parse(Console.ReadLine());
                                if (id > max) { max = id; }
                            }
                            catch (Exception) { }


                        }
                        decimal result = max >= 0 ? Math.Ceiling((decimal)max / 127) : Math.Ceiling((decimal)max / - 128);
                        String year = result >= 2 ? "years" : "year";
                        Console.WriteLine($"Prisoner with id {max} is sentenced to {result} {year}");

                        break;
                    }

                case "int":
                    {
                        int max = int.MinValue;
                        for (int i = 0; i < n; i++)
                        {
                            try
                            {
                                int id = int.Parse(Console.ReadLine());
                                if (id > max) { max = id; }
                            }
                            catch (Exception) { }


                        }
                        decimal result = max >= 0 ? Math.Ceiling((decimal)max / 127) : Math.Ceiling((decimal)max / - 128);
                        String year = result >= 2 ? "years" : "year";
                        Console.WriteLine($"Prisoner with id {max} is sentenced to {result} {year}");
                        break;
                    }

                case "long":
                    {
                        long max = long.MinValue;
                        for (int i = 0; i < n; i++)
                        {
                            try
                            {
                                long id = long.Parse(Console.ReadLine());
                                if (id > max) { max = id; }
                            }
                            catch (Exception) { }


                        }
                        decimal result = max >= 0 ? Math.Ceiling((decimal)max / 127) : Math.Ceiling((decimal)max / - 128);
                        String year = result >= 2 ? "years" : "year";
                        Console.WriteLine($"Prisoner with id {max} is sentenced to {result} {year}");
                        break;
                    }

                default:
                    break;
            }
        }
    }
}
