using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Employee_Data
{
	class Program
	{
		static void Main(string[] args)
		{
			//	Name: Ivan
			//	Age: 24
			//	Employee ID: 00001192
			//	Salary: 1500.35
			var name = Console.ReadLine();
			var age = int.Parse(Console.ReadLine());
			var id = int.Parse(Console.ReadLine());
			var salary = double.Parse(Console.ReadLine());

			Console.WriteLine($"name: {name}");
			Console.WriteLine($"Age: {age}");
			Console.WriteLine($"Employee ID: {id:D8}");
			Console.WriteLine($"Salary: {salary:F2}");
		}
	}
}
