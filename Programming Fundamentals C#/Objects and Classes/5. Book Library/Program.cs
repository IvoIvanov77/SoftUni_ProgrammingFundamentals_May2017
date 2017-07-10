using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _5.Book_Library
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());

            Library lib = new Library();

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split(' ');
                Book book = new Book(input[0], input[1], input[2], input[3], input[4], input[5]);
                lib.Books.Add(book);
            }

            //PrintBookByAuthorAndPrice(lib);
            PrintBookByTitleAndDate(lib);
           
        }

        static void PrintBookByAuthorAndPrice(Library lib)
        {
            Dictionary<string, double> authors = new Dictionary<string, double>();

            foreach (var book in lib.Books)
            {
                if (authors.ContainsKey(book.Author))
                {
                    authors[book.Author] += book.Price;
                }
                else
                {
                    authors.Add(book.Author, book.Price);
                }
            }

            authors.OrderByDescending(kv => kv.Value).ThenBy(kv => kv.Key).ToList().ForEach(kv =>
            Console.WriteLine($"{kv.Key} -> {kv.Value:F2}"));
        }

        static void PrintBookByTitleAndDate(Library lib)
        {
            DateTime date = DateTime.ParseExact(Console.ReadLine(), "dd.MM.yyyy", CultureInfo.InvariantCulture);
            Dictionary<string, DateTime> titles = new Dictionary<string, DateTime>();
            lib.Books.Where(b => b.ReleaseDate > date).OrderBy(b => b.ReleaseDate)
                .ThenBy(b => b.Title).ToList()
                .ForEach(b => Console.WriteLine($"{b.Title} -> {b.ReleaseDate.ToString("dd.MM.yyyy")}"));
        }
    }

    class Book
    {
        
        //title, author, publisher, release date(in dd.MM.yyyy format), ISBN-number and price.
        public string Title { get; set; }
        public string Author { get; set; }
        public string Publisher { get; set; }
        public DateTime ReleaseDate { get; set; }
        public string ISBNNumber { get; set; }
        public double Price { get; set; }

        public Book(string title, string author, string publisher, string releaseDate, string iSBNNumber, 
            string price)
        {
            Title = title;
            Author = author;
            Publisher = publisher;
            ReleaseDate = DateTime.ParseExact(releaseDate, "dd.MM.yyyy", CultureInfo.InvariantCulture);
            ISBNNumber = iSBNNumber;
            this.Price = double.Parse(price);
        }
    }

    class Library {
        public List<Book> Books { get; }

        public Library()
        {
            this.Books = new List<Book>();
        }


    }

}
