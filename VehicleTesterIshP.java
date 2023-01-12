package vehicletester;

import java.util.Scanner;

public class VehicleTesterIshP 
{
  public static void main(String[] args) 
  {
    double gasKilometrage=0,fuelTankSize,fuelAvailable,kilometresTravelled=0,passengerFare,fuelCost; //in litres per 100 km
    int passengerNum;
    double revenue,cost,profit; 
    
    printProgramDescription();
    
    gasKilometrage = getGasKilometrage();
    fuelTankSize = fuelTankSize();
    fuelAvailable = fuelAvailable();    
    passengerNum = passengerNum();
    passengerFare = passengerFare();
    fuelCost = fuelCost();
    
    VehicleIshP vehicle = new VehicleIshP(gasKilometrage,fuelTankSize,fuelAvailable,kilometresTravelled,passengerNum,passengerFare,fuelCost);
    
    simulateTrip(vehicle);
    
    revenue = calculateRevenue(vehicle);
    cost = calculateCost(vehicle);
    profit = calcualteProfit(vehicle,revenue,cost);
    
    printSimulationResuts(revenue,cost,profit);
  }
  /**
   * Prints out program description to the user
   */
  public static void printProgramDescription()
  {
    //Prints Program Description
    System.out.println("Hello!\nThis program will\n");
  }
  public static double getGasKilometrage()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("What is your Gas Kilometrage on your Vehicle in liters/100km(please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number above 0\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        if (num < 0)
        {
          num = Double.parseDouble("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double fuelTankSize()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("What is your Fuel tank size on your Vehicle in liters(please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number above 0\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        if (num < 0)
        {
          num = Double.parseDouble("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double fuelAvailable()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("How much fuel is available in your Vehicle before the trip in liters(please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static int passengerNum()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    int num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("How many passengers will board your Vehicle (please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not an integer\n";
      
      try
      {
        num = Integer.parseInt(numStr); // Convert the number from a String to an double
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double passengerFare()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("What is the passenger fare you charge (please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double fuelCost()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("What is the fuel cost per liter (please enter a number)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number above 0\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        if (num < 0)
        {
          num = Double.parseDouble("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static int getChoice()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    int num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("\nYou have 3 options (Drive: 1), (Add Fuel: 2), (End Trip: 3).");
      System.out.println("Please Pick one of the above option for your trip.");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not an integer between 1 to 3\n";
      
      try
      {
        num = Integer.parseInt(numStr); // Convert the number from a String to an double
        
        if (num < 1 || num > 4)
        {
          num = Integer.parseInt("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static void simulateTrip(VehicleIshP vehicle)
  {
    Scanner input = new Scanner(System.in);
    boolean isTripOver = true;
    int choice;
    double kms,fuelAdded;
    
    System.out.println("\nThe Trip Has Started!\n");
    
    do{
      choice = getChoice();
      
      if (choice == 1)
      {
        kms = getKms();
        vehicle.driveVehicle(kms);
        //Show Vehicle Info
        System.out.println(vehicle);
      }
      else if(choice == 2)
      {
        fuelAdded = getFuelAddedAmount();
        vehicle.addFuel(fuelAdded);  
        //Show Vehicle Info
        System.out.println(vehicle);
      }
      else
      {
        isTripOver = false;
      }
      
    }while(isTripOver);
    
    System.out.println("\nThe Trip Has Ended.\n");
  }
  public static double getKms()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("How far do you want to drive your vehicle (in Kms)?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number above 0\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        if (num < 0)
        {
          num = Double.parseDouble("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double getFuelAddedAmount()
  {
    Scanner input = new Scanner(System.in);
    String numStr = "", errMsg;
    double num = 0;
    boolean notValidInput = true; 
    
    do
    {
      System.out.println("How much fuel in liters are you you adding to your vehicle?");
      numStr = input.nextLine();
      
      errMsg = "Sorry, \" " + numStr + " \" is not a number above 0\n";
      
      try
      {
        num = Double.parseDouble(numStr); // Convert the number from a String to an double
        
        if (num < 0)
        {
          num = Double.parseDouble("Error");
        }
        
        notValidInput = false;
      }                              
      catch (NumberFormatException error)  
      {
        System.out.println(errMsg);
      }
      
    }while(notValidInput);  // As long as input is a negative, repeat
    
    return num;
  }
  public static double calculateRevenue(VehicleIshP vehicle)
  {
    double revenue;
    
    revenue = vehicle.calculateRevenue();
    
    return revenue;
  }
  public static double calculateCost(VehicleIshP vehicle)
  {
    double cost;
    
    cost = vehicle.calculateCost();
    
    return cost;
  }
  public static double calcualteProfit(VehicleIshP vehicle,double revenue,double cost)
  {
    double profit;
    
    profit = vehicle.calculateProfit(revenue,cost);
    
    return profit;
  }
  public static void printSimulationResuts(double revenue,double cost,double profit)
  {
    System.out.println("Revenue = " + revenue);
    System.out.println("Cost = " + cost);
    System.out.println("Profit = " + profit);
  }
}