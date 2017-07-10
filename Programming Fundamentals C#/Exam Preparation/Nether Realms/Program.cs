using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Nether_Realms
{
    class Program
    {
        static void Main(string[] args)
        {
            var demons = Regex.Split(Console.ReadLine().Trim(), @"\s*,\s*");

            SortedDictionary<string, Demon> dict = new SortedDictionary<string, Demon>();

            foreach (var demon in demons)
            {
                int healt = GetHealt(demon);
                double damage = GetDamage(demon);
                dict[demon] = new Demon(demon, healt, damage);
            }

            foreach(var demon in dict.Values)
            {
                Console.WriteLine($"{demon.Name} - {demon.Healt} health, {demon.Damage:F2} damage");
            }
            
        }

        static int GetHealt(string name)
        {
            MatchCollection matches = Regex.Matches(name, @"[^0-9\+\-\*\/\.]");
            int healt = 0;
            foreach (Match m  in matches)
            {
                int code = m.Value[0];
                healt += code;
            }
            return healt;
        }

        static double GetDamage(string name)
        {
            MatchCollection digits = Regex.Matches(name, @"[+|-]*\d+\.*\d*");
            MatchCollection operators = Regex.Matches(name, @"[*|\/]");
            double damage = 0;
            foreach (Match m in digits)
            {
                double digit = double.Parse(m.Value);
                damage += digit;
            }
            foreach (Match m in operators)
            {
                if(m.Value == "*")
                {
                    damage *= 2;
                }
                else if(m.Value == "/")
                {
                    damage /= 2;
                }
               
            }
            return damage;
        }
    }

    class Demon
    {
        private string name;
        private int healt;
        private double damage;

        public string Name { get => name; set => name = value; }
        public int Healt { get => healt; set => healt = value; }
        public double Damage { get => damage; set => damage = value; }

        public Demon(string name, int healt, double damage)
        {
            this.Name = name;
            this.Healt = healt;
            this.Damage = damage;
        }
    }
}
