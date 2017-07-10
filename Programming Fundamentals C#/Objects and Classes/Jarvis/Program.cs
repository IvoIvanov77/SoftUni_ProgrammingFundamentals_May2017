using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading.Tasks;

namespace Jarvis
{
    class Program
    {
        static void Main(string[] args)
        {
            Robot jarvis = new Robot(Console.ReadLine());
            var line = Console.ReadLine();

            while (line != "Assemble!")
            {
                ConstructRobot(jarvis, line);
                line = Console.ReadLine();
            }

            jarvis.PrintRobot();
        }

        static void ConstructRobot(Robot r, string line)
        {
            var input = line.Split(' ');
            var component = input[0];
            switch (component)
            {
                case "Arm": r.AddArm(new Arm(long.Parse(input[1]), int.Parse(input[2]), int.Parse(input[3])));
                    break;
                case "Leg": r.AddLeg(new Leg(long.Parse(input[1]), int.Parse(input[2]), int.Parse(input[3])));
                    break;
                case "Torso": r.AddTorso(new Torso(int.Parse(input[1]), double.Parse(input[2]), input[3]));
                    break;
                case "Head": r.AddHead(new Head(int.Parse(input[1]), int.Parse(input[2]), input[3]));
                    break;
            }
        }
    }

    class Robot
    {
        public BigInteger MaxEnergy { get; set; }
        public List<Arm> Arms { get; set; }
        public List<Leg> Legs { get; set; }
        public Torso Torso { get; set; }
        public Head Head { get; set; }

        public Robot(string energy)
        {
            this.MaxEnergy = BigInteger.Parse(energy);
            this.Arms = new List<Arm>(2);
            this.Legs = new List<Leg>(2);
        }

        bool HasArms()
        {
            return this.Arms.Count == 2;
        }

        bool HasLegs()
        {
            return this.Legs.Count == 2;
        }

        bool HasTorso()
        {
            return this.Torso != null;
        }

        bool HasHead()
        {
            return this.Head != null;
        }

        public void AddArm(Arm arm)
        {
            if (!HasArms())
            {
                this.Arms.Add(arm);
            }
            else
            {
                for (int i = 0; i < this.Arms.Count; i++)
                {
                    if(arm.EnergyConsumption < this.Arms[i].EnergyConsumption)
                    {
                        this.Arms[i] = arm;
                        break;
                    }
                }
            }
        }

        public void AddLeg(Leg leg)
        {
            if (!HasLegs())
            {
                this.Legs.Add(leg);
            }
            else
            {
                for (int i = 0; i < this.Legs.Count; i++)
                {
                    if (leg.EnergyConsumption < this.Legs[i].EnergyConsumption)
                    {
                        this.Legs[i] = leg;
                        break;
                    }
                }
            }
        }

        public void AddTorso(Torso torso)
        {
            if(!HasTorso() || torso.EnergyConsumption < this.Torso.EnergyConsumption)
            {
                this.Torso = torso;
            }         
            
        }

        BigInteger GetTotalConsumption()
        {
            BigInteger result = 0;
            result += HasHead() ? this.Head.EnergyConsumption : 0;
            result += HasTorso() ? this.Torso.EnergyConsumption : 0;
            result += this.Arms.Count > 0 ?
                this.Arms.Select(arm => arm.EnergyConsumption).Sum() : 0;
            result += this.Legs.Count > 0 ?
                this.Legs.Select(leg => leg.EnergyConsumption).Sum() : 0;

            return result;
        }

        public void AddHead(Head head)
        {
            if (!HasHead() || head.EnergyConsumption < this.Head.EnergyConsumption)
            {
                this.Head = head;
            }

        }

        bool IsCompleted()
        {
            return HasArms() && HasLegs() && HasTorso() && HasHead();
        }

        public void PrintRobot()
        {
            if(this.MaxEnergy < GetTotalConsumption())
            {
                Console.WriteLine("We need more power!");
            }
            else if (!IsCompleted())
            {
                Console.WriteLine("We need more parts!");
            }
            else
            {
                Console.WriteLine($"Jarvis:\n" +
                    $"#Head:\n" +
                    $"###Energy consumption: {this.Head.EnergyConsumption}\n" +
                    $"###IQ: {this.Head.IQ}\n" +
                    $"###Skin material: {this.Head.SkinMaterial}\n" +
                    $"#Torso:\n" +
                    $"###Energy consumption: {this.Torso.EnergyConsumption}\n" +
                    $"###Processor size: {this.Torso.ProcessorSize:F1}\n" +
                    $"###Corpus material: {this.Torso.HousingMaterial}");
                PrintArms();
                PrintLegs();                   
            }
        }

        void PrintArms()
        {
            this.Arms.OrderBy(arm => arm.EnergyConsumption).ToList().ForEach(arm =>
            Console.WriteLine($"#Arm:\n" +
            $"###Energy consumption: {arm.EnergyConsumption}\n" +
            $"###Reach: {arm.ReachDistance}\n" +
            $"###Fingers: {arm.CountOfFingers}"));
        }

        void PrintLegs()
        {
            this.Legs.OrderBy(leg => leg.EnergyConsumption).ToList().ForEach(leg =>
            Console.WriteLine($"#Leg:\n" +
            $"###Energy consumption: {leg.EnergyConsumption}\n" +
            $"###Strength: {leg.Strength}\n" +
            $"###Speed: {leg.Speed}"));
        }
    }


    class Arm
    {
        public Arm(long energyConsumption, int reachDistance, int countOfFingers)
        {
            EnergyConsumption = energyConsumption;
            ReachDistance = reachDistance;
            CountOfFingers = countOfFingers;
        }

        public long EnergyConsumption {get; set;}
        public int ReachDistance { get; set; }
        public int CountOfFingers { get; set; }
    }

    class Leg
    {
        public Leg(long energyConsumption, int strength, int speed)
        {
            EnergyConsumption = energyConsumption;
            Strength = strength;
            Speed = speed;
        }

        public long EnergyConsumption { get; set; }
        public int Strength { get; set; }
        public int Speed { get; set; }
    }

    class Torso
    {
        public Torso(int energyConsumption, double processorSize, string housingMaterial)
        {
            EnergyConsumption = energyConsumption;
            ProcessorSize = processorSize;
            HousingMaterial = housingMaterial;
        }

        public int EnergyConsumption { get; set; }
        public double ProcessorSize { get; set; }
        public string HousingMaterial { get; set; }
    }

    class Head
    {
        public Head(int energyConsumption, int iQ, string skinMaterial)
        {
            EnergyConsumption = energyConsumption;
            IQ = iQ;
            SkinMaterial = skinMaterial;
        }

        public int EnergyConsumption { get; set; }
        public int IQ { get; set; }
        public string SkinMaterial { get; set; }
    }

    

}
