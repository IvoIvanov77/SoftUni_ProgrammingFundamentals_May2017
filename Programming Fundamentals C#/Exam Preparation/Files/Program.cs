using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Files
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Dictionary<string, Dictionary<string, File>>rootDirectories = 
                new Dictionary<string, Dictionary<string, File>>();
            for (int i = 0; i < n; i++)
            {
                string line = Console.ReadLine();
                var input = line.Split('\\');
                string root = input[0];
                var fileAndSize = input.Last().Split(';').Where(s => s != string.Empty).ToArray();
                string name = fileAndSize[0];
                long size = long.Parse(fileAndSize.Last());
                File file = new File(root, name, size);

                if (!rootDirectories.ContainsKey(root))
                {
                    Dictionary<string, File> files = new Dictionary<string, File>();
                    files[name] = file;
                    rootDirectories[root] = files;
                }
                else
                {
                    rootDirectories[root][name] = file;
                }
            }

            var command = Console.ReadLine().Split(' ');
            var extention = command.First();
            var neededRoot = command.Last();

            if (rootDirectories.ContainsKey(neededRoot))
            {
                List<File> result = rootDirectories[neededRoot].Values.Where(f => f.Name.EndsWith(extention))
                .OrderByDescending(f => f.Size)
                .ThenBy(f => f.Name).ToList();

                if (result.Count == 0)
                {
                    Console.WriteLine("No");
                    return;
                }
                result.ForEach(f => Console.WriteLine($"{f.Name} - {f.Size} KB"));
            }
            else
            {
                Console.WriteLine("No");
            }
            

           
        }
    }

    class File
    {
        string root;
        string name;
        long size;

        public File(string root, string name, long size)
        {
            this.root = root;
            this.name = name;
            this.size = size;
        }

        public string Root { get => root; set => root = value; }
        public string Name { get => name; set => name = value; }
        public long Size { get => size; set => size = value; }
    }
}
