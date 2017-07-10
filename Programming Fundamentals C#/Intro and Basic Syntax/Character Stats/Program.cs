using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Character_Stats
{
	class Program
	{
		static void Main(string[] args)
		{
			var name = Console.ReadLine();
			var currentHealt = int.Parse(Console.ReadLine());
			var MaxHealt = int.Parse(Console.ReadLine());
			var currentEnergy = int.Parse(Console.ReadLine());
			var MaxEnergy = int.Parse(Console.ReadLine());
		
			Console.WriteLine($"Name: {name}");
			Console.WriteLine($"Health: {new String('|', currentHealt + 1) + (new String('.', MaxHealt - currentHealt))+ "|"}");
			Console.WriteLine($"Energy: {new String('|', currentEnergy + 1) + (new String('.', MaxEnergy - currentEnergy)) + "|"}");

		}
	}
}
