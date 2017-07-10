using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Vapor_Store
{
    class Program
    {
        static void Main(string[] args)
        {
            var money = double.Parse(Console.ReadLine());

            var balance = money;
            var comand = Console.ReadLine();

            while(!comand.Equals("Game Time"))
            {             

                switch (comand)
                {
                    case "OutFall 4":
                        {
                            double price = 39.99;
                            if (balance < price)
                            {
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }
                        

                    case "CS: OG":
                        {
                            double price = 15.99;
                            if (balance < price)
                            {
                                
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }

                    case "Zplinter Zell":
                        {
                            double price = 19.99;
                            if (balance < price)
                            {
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }

                    case "Honored 2":
                        {
                            double price = 59.99;
                            if (balance < price)
                            {
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }

                    case "RoverWatch":
                        {
                            double price = 29.99;
                            if (balance < price)
                            {
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }
                    case "RoverWatch Origins Edition":
                        {
                            double price = 39.99;
                            if (balance < price)
                            {
                                Console.WriteLine("Too Expensive");
                            }
                            else
                            {
                                Console.WriteLine("Bought {0}", comand);
                                balance -= price;
                            }
                            break;
                        }
                    default:
                        Console.WriteLine("Not Found"); break;
                }
                if (balance == 0)
                {
                    Console.WriteLine("Out of money!");
                    break;
                }
                comand = Console.ReadLine();

            }
            if(balance > 0)
            {
                Console.WriteLine("Total spent: ${0:F2}. Remaining: ${1:F2}", money - balance, balance);   
            }
            

            
        }
    }
}
