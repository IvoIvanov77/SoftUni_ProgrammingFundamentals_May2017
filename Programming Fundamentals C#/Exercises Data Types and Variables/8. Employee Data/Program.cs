using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _8.Employee_Data
{
    class Program
    {
        static void Main(string[] args)
        {    

            string fn = "Amanda";
            string ln = "Jonson";
            int age = 27;
            char gender = 'f';
            long id = 8306112507;
            int number = 27563571;

            Console.WriteLine($"First name: {fn}\nLast name: {ln}\nAge: {age}\n" +
                $"Gender: {gender}\nPersonal ID: {id}\nUnique Employee number: {number}");
        }
    }
}
