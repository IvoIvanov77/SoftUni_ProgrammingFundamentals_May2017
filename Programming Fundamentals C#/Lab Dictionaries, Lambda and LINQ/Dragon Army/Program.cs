using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dragon_Army
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            var types = new Dictionary<string, SortedDictionary<string, Stats>>();

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split(' ');
                var type = input[0];
                var name = input[1];
                var stats = new Stats(input[2], input[3], input[4]);

                if (!types.ContainsKey(type))
                {
                    var dragons = new SortedDictionary<string, Stats>();
                    dragons.Add(name, stats);
                    types.Add(type, dragons);
                }
                else
                {
                    types[type][name] = stats;
                }                
            }

            foreach (var type in types)
            {
                double totalDamage = 0;
                type.Value.Values.ToList().ForEach(st => totalDamage += st.Damage);

                double totalHealth = 0;
                type.Value.Values.ToList().ForEach(st => totalHealth += st.Health);

                double totalArmor = 0;
                type.Value.Values.ToList().ForEach(st => totalArmor += st.Armor);

                Console.WriteLine("{0}::({1:F2}/{2:F2}/{3:F2})", type.Key, totalDamage/type.Value.Count, 
                    totalHealth/type.Value.Count, totalArmor/type.Value.Count);
                foreach (var dragon in type.Value)
                {
                    Console.WriteLine("-{0} -> damage: {1}, health: {2}, armor: {3}", dragon.Key, dragon.Value.Damage,
                        dragon.Value.Health, dragon.Value.Armor);
                }
            }
        }
    }

    class Stats
    {
        public int Damage { get; set; } = 45;
        public int Health { get; set; } = 250;
        public int Armor { get; set; } = 10;
        

        public Stats(string damage, string health, string armor)
        {
            if (damage.All(char.IsDigit))
            {
                this.Damage = int.Parse(damage);
            }
            if (health.All(char.IsDigit))
            {
                this.Health = int.Parse(health);
            }
            if (armor.All(char.IsDigit))
            {
                this.Armor = int.Parse(armor);
            }
            
        }
    }
}
