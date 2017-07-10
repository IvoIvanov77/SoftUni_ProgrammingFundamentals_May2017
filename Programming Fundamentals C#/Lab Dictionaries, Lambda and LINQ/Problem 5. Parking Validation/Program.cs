using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace Problem_5.Parking_Validation
{
    class Program
    {
        static void Main(string[] args)
        {
            var n = int.Parse(Console.ReadLine());
            Dictionary<String, User> users = new Dictionary<string, User>();

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine().Split(' ');
                if (input.Length == 2)
                {
                    var username = input[1];
                    if (users.Remove(username))
                    {
                        Console.WriteLine($"user {username} unregistered successfully");
                    }
                    else
                    {
                        Console.WriteLine($"ERROR: user {username} not found");
                    }
                }
                else
                {
                    var username = input[1];
                    var plateNumber = input[2];

                    if (users.ContainsKey(username))
                    {
                        Console.WriteLine($"ERROR: already registered with plate number " +
                            $"{users[username].LicensePlateNumber}");
                    }
                    else
                    {
                        if (!IsValidPlateNumber(plateNumber)){
                            Console.WriteLine($"ERROR: invalid license plate {plateNumber}");
                        }
                        else
                        {
                            bool hasSameNumber = false;
                            foreach (User user in users.Values)
                            {
                                if (user.LicensePlateNumber == plateNumber)
                                {
                                    Console.WriteLine($"ERROR: license plate {plateNumber} is busy");
                                    hasSameNumber = true;
                                    break;
                                }
                            }
                            if (!hasSameNumber)
                            {
                                users.Add(username, new User(username, plateNumber));
                                Console.WriteLine($"{username} registered {plateNumber} successfully");
                            }
                        }
                        
                    }

                }
            }

            foreach (var user in users.Values)
            {
                Console.WriteLine($"{user.UserName} => {user.LicensePlateNumber}");
            }
        }

        static bool IsValidPlateNumber(string number)
        {
            return Regex.IsMatch(number, @"[A-Z]{2}\d{4}[A-Z]{2}");
        }
    }

    class User
    {
        public string UserName { get; set; }
        public string LicensePlateNumber { get; set; }

        public User(string userName, string licensePlateNumber)
        {
            UserName = userName;
            LicensePlateNumber = licensePlateNumber;
        }


    }
}
