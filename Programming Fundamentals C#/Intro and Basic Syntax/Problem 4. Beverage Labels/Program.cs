using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_4.Beverage_Labels
{
	class Program
	{
		static void Main(string[] args)
		{
			var name = Console.ReadLine();
			var volume = int.Parse(Console.ReadLine());
			var energy = double.Parse(Console.ReadLine());
			var sugar = double.Parse(Console.ReadLine());

			//	220ml Nuka-Cola: 660kcal, 154g sugars
			Console.WriteLine($"{volume}ml {name}:\n{energy / 100 * volume}kcal, {sugar /100 * volume}g sugars");

		}
	}
}
