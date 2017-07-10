using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            var dragons = new SortedDictionary<string, string>();

            dragons["Ivo"] = "pesho";
            dragons["Ivo"] = "Hris";
            dragons.Add("Ivo", "");
        }
    }
}
