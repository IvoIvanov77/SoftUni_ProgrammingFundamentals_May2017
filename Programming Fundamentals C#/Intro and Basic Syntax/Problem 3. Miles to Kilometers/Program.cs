using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_3.Miles_to_Kilometers
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine($"{1.60934 * double.Parse(Console.ReadLine()):F2}");
		}
	}
}
