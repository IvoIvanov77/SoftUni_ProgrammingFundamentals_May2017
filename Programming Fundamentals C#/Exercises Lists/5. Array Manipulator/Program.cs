using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5.Array_Manipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            var list = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            string line = Console.ReadLine();

            while(line != "print")
            {
                string[] command = line.Split(' ');
                ExecuteCommand(list, command);
                line = Console.ReadLine();
            }

            Console.WriteLine("[" + string.Join(", ", list) + "]");
        }

        private static void ExecuteCommand(List<int> list, string[] command)
        {
            switch (command[0])
            {
                case "addMany":
                    {
                        int index = int.Parse(command[1]);
                        for (int i = 2; i < command.Length; i++)
                        {
                            int number = int.Parse(command[i]);
                            list.Insert(index++, number);
                        }
                        break;
                    }                    

                case "add":
                    {
                        int index = int.Parse(command[1]);
                        for (int i = 2; i < command.Length; i++)
                        {
                            int number = int.Parse(command[i]);
                            list.Insert(index++, number);
                        }
                        break;
                    }

                case "contains":
                    {
                        int item = int.Parse(command[1]);
                        Console.WriteLine(list.IndexOf(item));
                        break;
                    }

                case "remove":
                    {
                        int index = int.Parse(command[1]);
                        list.RemoveAt(index);
                        break;
                    }

                case "shift":
                    {
                        int positions = int.Parse(command[1]);
                        for (int i = 0; i < positions; i++)
                        {
                            int item = list.ElementAt(0);
                            list.RemoveAt(0);
                            list.Add(item);
                        }
                        
                        break;
                    }

                case "sumPairs":
                    {                        
                        for (int i = 0; i < list.Count - 1; i++)
                        {
                            list[i] += list[i + 1];
                            list.RemoveAt(i + 1);
                        }

                        break;
                    }


                default:
                    break;
            }
        }
    }
}
