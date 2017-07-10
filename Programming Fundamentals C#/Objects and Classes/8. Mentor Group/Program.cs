using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _8.Mentor_Group
{
    class Program
    {
        static void Main(string[] args)
        {
            var line = Console.ReadLine();
            SortedDictionary<string, User> users = new SortedDictionary<string, User>();
            while (line != "end of dates")
            {
                var input = line.Split(' ');
                if (!users.ContainsKey(input[0]))
                {
                    User user = input.Length > 1 ? new User(input[0], input[1]) : new User(input[0]);
                    users[user.Name] = user;
                }
                else
                {
                    if(input.Length > 1)
                    {
                        users[input[0]].AddDates(input[1]);
                    }
                    
                }
                
                line = Console.ReadLine();
            }

            while (line != "end of comments")
            {
                var input = line.Split('-');
                if (users.ContainsKey(input[0]))
                {
                    users[input[0]].AddComment(input[1]);
                }
                line = Console.ReadLine();
            }
            foreach (var kv in users)
            {
                Console.WriteLine(kv.Key);
                Console.WriteLine("Comments:");
                kv.Value.PrintComments();
                Console.WriteLine("Dates attended:");
                kv.Value.PrintDates();
            }
        }
    }

    class User
    {
        
        public string Name { get; }
        public List<DateTime> Dates { get; }
        public List<string> Comments { get; }

        public User(string name)
        {
            Name = name;
            Dates = new List<DateTime>();           
            Comments = new List<string>();
        }

        public User(string name, string dates)
        {
            Name = name;
            Dates = dates.Split(',').Select(d => 
            DateTime.ParseExact(d, "dd/MM/yyyy", CultureInfo.InvariantCulture)).ToList();
            Comments = new List<string>();
        }

        public void AddComment(string comment)
        {
            this.Comments.Add(comment);
        }

        public void AddDates(string str)
        {
            var dates = str.Split(',').Select(d =>
            DateTime.ParseExact(d, "dd/MM/yyyy", CultureInfo.InvariantCulture)).ToList();
            this.Dates.AddRange(dates);
        }

        public void PrintDates()
        {
            this.Dates.OrderBy(d => d).ToList()
                .ForEach(d => Console.WriteLine($"-- {d.ToString("dd/MM/yyyy")}"));
        }

        public void PrintComments()
        {
            Comments.ForEach(c => Console.WriteLine($"- {c}"));
        }

    }
}
