using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pokemon_Don_t_Go
{
    class Program
    {
        static void Main(string[] args)
        {
            var pokemons = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var line = Console.ReadLine();

            long sum = 0;

            while (pokemons.Count > 0)
            {
                int index = int.Parse(line);
                int item;
                if(index < 0)
                {
                    sum += pokemons[0];
                    item = pokemons[0];
                    pokemons[0] = pokemons[pokemons.Count - 1];
                }
                else if(index >= pokemons.Count)
                {
                    sum += pokemons[pokemons.Count - 1];
                    item = pokemons[pokemons.Count - 1];
                    pokemons[pokemons.Count - 1] = pokemons[0];
                }
                else
                {
                    item = pokemons[index];
                    sum += item;
                    pokemons.RemoveAt(index);                    
                }
                for (int i = 0; i < pokemons.Count; i++)
                {
                    if (pokemons[i] <= item)
                    {
                        pokemons[i] += item;
                    }
                    else
                    {
                        pokemons[i] -= item;
                    }
                }
                if (pokemons.Count == 0)
                {
                    break;
                }
                //Console.WriteLine(string.Join(", ", pokemons));
                line = Console.ReadLine();
            }

            Console.WriteLine(sum);

        }
    }
}
