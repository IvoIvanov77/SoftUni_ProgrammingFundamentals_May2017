using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Problem_4.Supermarket_Database
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();
            Dictionary<string, Product> products = new Dictionary<string, Product>();

            while (line != "stocked")
            {
                var input = line.Split(' ');
                var p = new Product(input);
                if (!products.ContainsKey(p.Name))
                {
                    products[p.Name] = p;
                }
                else
                {
                    products[p.Name].Price = p.Price;
                    products[p.Name].Quantyti += p.Quantyti;                   
                }
                line = Console.ReadLine();
            }

            decimal grandTotal = 0;

            foreach (var item in products)
            {
                var totalPrice = item.Value.Price * item.Value.Quantyti;
                Console.WriteLine("{0}: ${1} * {2} = ${3}", item.Key, item.Value.Price, 
                    item.Value.Quantyti, totalPrice);
                grandTotal += totalPrice;
            }
            Console.WriteLine(new string('-', 30));
            Console.WriteLine($"Grand Total: ${grandTotal}");

        }
    }

    class Product {
        public string Name { get; set; }
        public decimal Price { get; set; }
        public long Quantyti { get; set; }



        public Product(string[] input)
        {
            this.Name = input[0];
            this.Price = decimal.Parse(input[1]);
            this.Quantyti = long.Parse(input[2]);
        }
    }

}
