using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_1.Order_by_Age
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();
            List<Person> persons = new List<Person>();

            while (line != "End")
            {
                persons.Add(new Person(line));
                line = Console.ReadLine();
            }

            persons.OrderBy(p => p.Age).ToList().ForEach(p => p.PrintPerson());
        }
    }

    class Person
    {
        public string Name { get; set; }
        public string ID { get; set; }
        public int Age { get; set; }

        public Person(string line)
        {
            var input = line.Split(' ');
            Name = input[0];
            ID = input[1];
            Age = int.Parse(input[2]);
        }

        public void PrintPerson()
        {
            Console.WriteLine($"{this.Name} with ID: {this.ID} is {this.Age} years old.");
        }
    }
}


