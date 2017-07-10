using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Globalization;


namespace Problem_2.Vehicle_Catalogue
{
    class Program
    {

        
        static void Main(string[] args)
        {
            var line = Console.ReadLine();
            Dictionary<string, Vehicle> dict = new Dictionary<string, Vehicle>();

            while (line != "End")
            {
                Vehicle vehicle = new Vehicle(line);
                dict[vehicle.Model] = vehicle;
                line = Console.ReadLine();
            }

            line = Console.ReadLine();

            while (line != "Close the Catalogue")
            {
                Vehicle vehicle = dict[line];
                vehicle.PrintVehicle();
                line = Console.ReadLine();
            }
            double CarsAverageHorsepower = 0;
            double TrucksAverageHorsepower = 0;
            try
            {
                CarsAverageHorsepower = dict.Values.Where(v => v.TypeOfVehicle == TypeOfVehicle.Car)
               .Select(v => v.Horsepower).Average();
            }
            catch (Exception) { }           

            try
            {
                TrucksAverageHorsepower = dict.Values.Where(v => v.TypeOfVehicle == TypeOfVehicle.Truck)
                .Select(v => v.Horsepower).Average();
            }
            catch (Exception) { }
           
           
            

            Console.WriteLine($"Cars have average horsepower of: {CarsAverageHorsepower:F2}.");
            Console.WriteLine($"Trucks have average horsepower of: {TrucksAverageHorsepower:F2}.");

        }
    }

    class Vehicle
    {
        

        public TypeOfVehicle TypeOfVehicle { get; set; }
        public string Model { get; set; }
        public string Color { get; set; }
        public int Horsepower { get; set; }

        public Vehicle(string line)
        {
            var input = line.Split(' ');            
            TypeOfVehicle = (TypeOfVehicle)Enum.Parse(typeof(TypeOfVehicle), input[0], true);
            Model = input[1];
            Color = input[2];
            Horsepower = int.Parse(input[3]);
        }

        public void PrintVehicle()
        {
            Console.WriteLine($"Type: {this.TypeOfVehicle}\n" +
                $"Model: {this.Model}\n" +
                $"Color: {this.Color}\n" +
                $"Horsepower: {this.Horsepower}");

        }

    }

    enum TypeOfVehicle {Car, Truck}
}
