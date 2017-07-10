using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ladybugs
{
    class Program
    {
        static void Main(string[] args)
        {

            var fieldSize = int.Parse(Console.ReadLine());
            var field = new byte[fieldSize];
            var populateIndexes = Console.ReadLine().Split(' ').Select(int.Parse);
            foreach (var index in populateIndexes)
            {
                try
                {
                    field[index] = 1;
                }
                catch (Exception) { }                
            }

            var line = Console.ReadLine();

            while (line != "end")
            {
                var input = line.Split(' ');
                var index = int.Parse(input[0]);
                var direction = input[1];
                var movment = int.Parse(input[2]);
                if(index < 0 || index >= field.Length || field[index] == 0)
                {
                    line = Console.ReadLine();
                    continue;
                }
                if(direction == "right")
                {
                    MoveRight(field, index, movment);
                }
                else
                {
                    MoveLeft(field, index, movment);
                }
                line = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ", field));
        }

        static void MoveRight(byte[] arr, int index, int len)
        {
            if(len < 0)
            {
                MoveLeft(arr, index, 0 - len);
                return;
            }
            int newIndex = index + len;
            arr[index] = 0;
            try
            {
                while (arr[newIndex] != 0)
                {
                    newIndex += len;
                }
                arr[newIndex] = 1;                
            }
            catch (Exception) { }            
        }

        static void MoveLeft(byte[] arr, int index, int len)
        {
            if (len < 0)
            {
                MoveRight(arr, index, 0 - len);
                return;
            }
            int newIndex = index - len;
            arr[index] = 0;
            try
            {
                while (arr[newIndex] != 0)
                {
                    newIndex -= len;
                }
                arr[newIndex] = 1;
            }
            catch (Exception) { }
        }
    }
}
