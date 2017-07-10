using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_6.Catch_the_Thief
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
                        Console.WriteLine(max);
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
                        Console.WriteLine(max);
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
                        Console.WriteLine(max);
                        break;
                    }

                default:
                    break;
            }
        }

        
    }
}
