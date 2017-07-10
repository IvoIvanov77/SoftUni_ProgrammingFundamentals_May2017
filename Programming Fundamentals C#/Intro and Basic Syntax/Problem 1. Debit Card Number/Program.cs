using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_1.Debit_Card_Number
{
	class Program
	{
		static void Main(string[] args)
		{
			var a = int.Parse(Console.ReadLine());
			var b = int.Parse(Console.ReadLine());
			var c = int.Parse(Console.ReadLine());
			var d = int.Parse(Console.ReadLine());

			Console.WriteLine($"{a:D4} {b:D4} {c:D4} {d:D4}");
		}
	}
}
