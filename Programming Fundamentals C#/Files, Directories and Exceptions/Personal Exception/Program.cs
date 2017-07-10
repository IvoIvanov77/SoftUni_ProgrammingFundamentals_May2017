using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Personal_Exception
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                try
                {
                    Number num = new Number(double.Parse(Console.ReadLine()));
                    Console.WriteLine(num);
                }
                catch (NegativeNumberException e)
                {
                    Console.WriteLine(e.Message);
                    break;                   
                }
                
            }
        }
    }

    class NegativeNumberException : Exception
    {
        public NegativeNumberException() : base("My first exception is awesome!!!")
        {
            
        }
    }

    class Number
    {
        double number;

        public Number(double number)
        {
            if(number < 0)
            {
                throw (new NegativeNumberException());
            }
            else
            {
                this.number = number;
            }
           
        }

        public override string ToString()
        {
            return number.ToString();
        }
    }

}
