package vehicletester;

public class VehicleIshP 
{
  private double gasKilometrage; //in litres per 100 km
  private double fuelTankSize; 
  private double fuelAvailable; 
  private double kilometresTravelled;
  private int passengerNum;
  private double passengerFare;
  private double fuelCost;
  
  public VehicleIshP() 
  {
    //Default Constructor
    gasKilometrage = 0;
    fuelTankSize = 0;
    fuelAvailable = 0;
    kilometresTravelled = 0;
    passengerNum = 0;
    passengerFare = 0;
    fuelCost = 0;
  }
  
  public VehicleIshP(double gK, double fTS, double fA, double kT,int pN, double pF, double fC)
  {
    gasKilometrage = gK;  
    fuelTankSize = fTS;
    fuelAvailable = fA;
    kilometresTravelled = kT;
    passengerNum = pN;
    passengerFare = pF;
    fuelCost = fC;
  }
  
  // the following method is essentially a setter method for fuelAvailable 
  // that first checks if the value in gas is valid
  public void addFuel(double gas)
  {
    if((fuelTankSize - fuelAvailable) >= gas)
    {
      fuelAvailable += gas;
      System.out.println("Added " + gas + 
                         "L of gas to the tank.");
    }
    else 
    {
      System.out.println("You tried to add "+gas+"L of gas.");
      System.out.println("There is only room for " + 
                         (fuelTankSize - fuelAvailable) + "L.");
      fuelAvailable=fuelTankSize;
    }
  }
  
  // the following method is essentially a setter for both fuelAvailable 
  // and kilometersTravelled (driving effects both properties)
  public void driveVehicle(double kms)
  {
    //Drive the vehicle
    //ex.  If the vehicle uses 9.5L/100 km then
    //litresNeeded = kms * (9.5/100)
    System.out.println("Drive " + kms + "kms.  Start with " + 
                       fuelAvailable + "L of gas.");
    
    double litresNeeded=kms*(gasKilometrage/100.0);
    
    if(fuelAvailable >= litresNeeded)
    {
      fuelAvailable -= litresNeeded;
      kilometresTravelled += kms;
      System.out.println("Used " + litresNeeded + "L of gas.");
    }
    else 
    {
      System.out.println("Ran out of fuel!");
      //Calculate how many kms were driven
      //ex. If the vehicle uses 9.5L/100km then
      //kmsThisDrive=fuelAvailable/(9.5/100)
      double kmsThisDrive=fuelAvailable/(gasKilometrage/100.0);
      kilometresTravelled += kmsThisDrive;
      fuelAvailable = 0;
      System.out.println("The vehicle drove " + kmsThisDrive +
                         " before running out of gas.");
    }
  }
  public double calculateRevenue()
  {
    double revenue;
    
    revenue = passengerNum * passengerFare;
    
    return revenue;
  }
  public double calculateCost()
  {
    double cost;
    
    cost = kilometresTravelled * (gasKilometrage/100) * fuelCost;
    
    return cost;
  }
  public double calculateProfit(double revenue, double cost)
  {
    double profit;
    
    profit = revenue - cost;
    
    return profit;
  } 
  public String toString() 
  {
    String output = "\nGas Kilometrage = " + gasKilometrage+"\n";
    output += "Fuel Tank Size = " + fuelTankSize + "\n";
    output += "Fuel Available = " + fuelAvailable + "\n";
    output += "Kilometres Driven = "+kilometresTravelled+"\n";
    output += "Passengers = "+passengerNum+"\n";
    output += "Fare = "+passengerFare+"\n";
    output += "Fuel Cost = "+fuelCost+"/L\n";
    return output;
  }
}