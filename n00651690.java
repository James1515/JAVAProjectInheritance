//*************************************************************
// Program: n00651690.java         Author: James Anthony Ortiz
//
// Purpose: To demonstrate how classes and methods in classes
// may be used to read from a file, and be able to display the
// correct data from the file.
//*************************************************************


//Java libraries to be implemented in the program:
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;


public class n00651690 //Public class
{

 //Comparator used to compare emails between vehicble objects
 //So that they may be sorted.
 static class emailComparer implements Comparator <vehicle>
 {
   
   public int compare(vehicle one, vehicle two)
   {
    vehicle ar1 = (vehicle) one;
    vehicle ar2 = (vehicle) two;
    return(ar1.getEmail().compareTo(ar2.getEmail()));
   }
 }
   public static void main(String[] args) throws FileNotFoundException
   {  
      //Creates an instance of a file class:
      File file = new File(args[0]);
      
      //Creates an instance of a scanner to cread from a file:
      Scanner scan = new Scanner(file);
      
      //Creates an array list called "vehicles":
      ArrayList<vehicle> vehicles = new ArrayList<vehicle>();
      
      //Scans file for the vehicle types to organize the correct information:     
      while(scan.hasNextLine())
      {
        String line = scan.nextLine();
        
        if(line.equals("vehicle"))
        {
          
          String name = scan.nextLine();
          String address = scan.nextLine();
          String phone = scan.nextLine();
          String email = scan.nextLine();
          
          vehicles.add(new vehicle(name, address, phone, email));
         } 
          else if(line.equals("car"))
          {
             String name = scan.nextLine();
             String address = scan.nextLine();
             String phone = scan.nextLine();
             String email = scan.nextLine();
             boolean convertible = scan.nextBoolean();
             scan.nextLine();
             String color = scan.nextLine();
                          
             vehicles.add(new car(name, address, phone, email, convertible, color));
          
          }
          else if(line.equals("american car"))
          {
            String name = scan.nextLine();
            String address = scan.nextLine();
            String phone = scan.nextLine();
            String email = scan.nextLine();
            
            boolean convertible  = scan.nextBoolean();
            scan.nextLine(); 
            String color = scan.nextLine();
            boolean madeInDetroit = scan.nextBoolean();
            boolean madeInUnionShop = scan.nextBoolean();
            
            
            vehicles.add(new american_car(name, address, phone, email, convertible, color, madeInDetroit, madeInUnionShop)); 
            
          }
          else if(line.equals("foreign car"))
          {
            String name = scan.nextLine();
            String address = scan.nextLine();
            String phone = scan.nextLine();
            String email = scan.nextLine();
            boolean convertible = scan.nextBoolean();
            scan.nextLine();
            String color = scan.nextLine();
            String countryOfManufacturer = scan.nextLine();
            float importDuty = scan.nextFloat();
            scan.nextLine();
            
            vehicles.add(new foreign_car(name, address, phone, email, convertible, color, countryOfManufacturer, importDuty));
          }
          else if(line.equals("bicycle"))
          {
            String name = scan.nextLine();
            String address = scan.nextLine();
            String phone = scan.nextLine();
            String email = scan.nextLine();
            int numberOfSpeeds = scan.nextInt();
            scan.nextLine();
            
            vehicles.add(new bicycle(name, address, phone, email, numberOfSpeeds));
            
          }
          else if(line.equals("truck"))
          {
            String name = scan.nextLine();
            String address = scan.nextLine();
            String phone = scan.nextLine();
            String email = scan.nextLine();
            float numberOfTons = scan.nextFloat();
            float costOfTruck = scan.nextFloat();
            scan.nextLine();
            String datePurchased = scan.nextLine();            
            vehicles.add(new truck(name, address, phone, email, numberOfTons, costOfTruck, datePurchased));
          }
          
      }
      //Closes the File:
      scan.close();   
      
      //-------------------------------------------------------
      //Method 1: printAll(ArrayList<vehicle> vehicles)
      //Prints all of the vehicles:
      //-------------------------------------------------------
      
      System.out.println("------------------------------------");
      System.out.println("All vehicles on file: ");
      System.out.println("------------------------------------");
      printAll(vehicles);
      
      //--------------------------------------------------------
      //Method 2: sort(ArrayList<vehicle> vehicles)
      //Sorts the array
      //--------------------------------------------------------
      
      System.out.println("------------------------------------");
      System.out.println("Sorted Array by E-mail address: ");
      System.out.println("------------------------------------");
      sort(vehicles);
      
      
      //-------------------------------------------------
      //Method 3: numberOfRecords(ArrayList<vehicle> vehicles)
      //Displays the number of records:
      //-------------------------------------------------
      
      System.out.println("------------------------------------");
      System.out.print("The number of records is: ");
      numberOfRecords(vehicles);
      System.out.println("------------------------------------");
      
      //----------------------------------------------------
      //Method 4: onlyBicyclesAndTrucks(ArrayList<vehicle> vehicles)
      //Displays only the vehicles that are bicycles and trucks. 
      //----------------------------------------------------
      
      System.out.println("------------------------------------");
      System.out.println("Only bicycles and trucks: ");
      System.out.println("------------------------------------");
      onlyBicyclesAndTrucks(vehicles);
      
      //-----------------------------------------------------
      //Method 5: onlyAreaCode987(ArrayList<vehicle> vehicles)
      //Displays all vehicles that are in area code "(987)":
      //-----------------------------------------------------
      System.out.println("---------------------------------------------------");
      System.out.println("The vehicles that are located in area code (987):" );
      System.out.println("---------------------------------------------------");
      onlyAreaCode987(vehicles);
      
      
      
   }
   
   //--------------------------------------------------------
   //printAll Method:
   //Passed an array of type vehicle which prints
   //each element of the array using the appropriate toString()
   //methods.
   //--------------------------------------------------------
   
   public static void printAll(ArrayList<vehicle> vehicles)
   {
     
      for(int i = 0; i <= vehicles.size() - 1; i++)
      {
        System.out.print(vehicles.get(i).toString());
        System.out.print("\n");
      }

   }
   
   
   //--------------------------------------------------------
   //sort Method: 
   //Passed an array of type ArrayList<vehicle> which sorts the array 
   //by email addresses and prints the new sorted array using
   //appropriate toString() methods. 
   //--------------------------------------------------------
   public static void sort(ArrayList<vehicle> vehicles)
   {
     Collections.sort(vehicles, new emailComparer());
     for(int i = 0; i <= vehicles.size() - 1;i++)
     {
       System.out.println(vehicles.get(i).toString());
     }
     
     
   }
   
   
   //-------------------------------------------------------
   //numberOfRecords Method:
   //prints the number of records of all of the vehicles.
   //-------------------------------------------------------
   public static void numberOfRecords(ArrayList<vehicle> vehicles)
   { 
     System.out.println(vehicles.size());

   }
   
   
   //-------------------------------------------------------
   //onlyBicyclesandTrucks Method:
   //Prints only bicycles and trucks from the list of vehicles
   //useing the approprate toString() method.
   //-------------------------------------------------------
   public static void onlyBicyclesAndTrucks(ArrayList<vehicle> vehicles)
   {
   
     for(int i = 0; i <= vehicles.size() - 1; i++)
     {
       
       if(vehicles.get(i) instanceof bicycle)
       {
         System.out.println(vehicles.get(i).toString());
         
       }
       else if(vehicles.get(i) instanceof truck)
       {
        System.out.println(vehicles.get(i).toString());
       }
     }
   
   
   }
   
   
   //-------------------------------------------------------
   //onlyAreaCode987 method:
   //Prints all vehicles that are in area code "(987)".
   //-------------------------------------------------------
   
   public static void onlyAreaCode987(ArrayList<vehicle> vehicles)
   {     
     vehicle[] newVa = new vehicle[vehicles.size()];
     newVa = vehicles.toArray(newVa);
     
     for(int i = 0; i < newVa.length; i++)
     {
       if(newVa[i].getPhone().startsWith("(987)",0))
       {        
         
         System.out.println(newVa[i].toString());
 
       }
     }
     
   }
   
   
   
}

//-----------------------------------------
//parent class Vehicle:
//-----------------------------------------

class vehicle
{
  //Variables:
   private String name;
   private String address;
   private String phone;
   private String email;
  
  
  //Methods:
  //Constructors:  
   public vehicle(String name, String address, String phone, String email)
   {
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.email = email;
   
   }
  
  
  //Getters:
   public String getName()
   {
      return name;
   }
  
   public String getAddress()
   {
      return address;
   }
   public String getPhone()
   {
      return phone;
   }
   public String getEmail()
   {
      return email;
   }
  
  //Setters:
   public void setName(String name)
   {
      this.name = name;
   }
  
   public void setAddress(String address)
   {
      this.address = address;
   }
  
   public void setPhone(String phone)
   {
      this.phone = phone;
   }
  
   public void setEmail(String email)
   {
      this.email = email;
   }
   
   //toString:
   public String toString()
   {
      return "Vehicle Type: " + "vehicle" + "\n" + "Name: " + getName() + "\n"
           + "Address: " + getAddress() + "\n"
           + "Phone: " + getPhone() + "\n"
           + "Email: " + getEmail() + "\n";
           
   }

}

//------------------------------------------------
//child class car: (extends vehicle parent class)
//------------------------------------------------

class car extends vehicle
{
   private boolean convertible;
   private String color;
  
  //Constructors:
   public car(String name, String address, String phone, String email, boolean convertible, String color)
   {
      super(name, address, phone, email);
      setConvertible(convertible);
      setColor(color);
   }
  
  //Getters:
  
   public boolean getConvertible()
   {
      return convertible;
   }
  
   public String getColor()
   {
      return color;
   }
  
  //Setters:
   public void setConvertible(boolean convertible)
   {
      this.convertible = convertible;
   }
  
   public void setColor(String color)
   {
      this.color = color;
    
   }
   
   //toString:
  
   public String toString()
   {
      return "Vehicle type: " + "car" + "\n" + super.toString()
         + "Convertible: " + getConvertible() + "\n"
         + "Color: " + getColor() + "\n";
   }

}

//------------------------------------------------
//child class american_car extends car
//------------------------------------------------

class american_car extends car
{
  
   private boolean madeInDetroit;
   private boolean madeInUnionShop;
   
   //Constructor:
   public american_car(String name, String address, String phone, String email, boolean convertible, String color, boolean madeInDetroit, boolean madeInUnionShop)
   {
      super(name, address, phone, email, convertible, color);
      setMadeInDetroit(madeInDetroit);
      setMadeInUnionShop(madeInUnionShop);
   }
   
   //Getters:
   public boolean getMadeInDetroit()
   {
      return madeInDetroit;
     
   }
   public boolean getMadeInUnionShop()
   {
      return madeInUnionShop;
   }
   
   //Setters:
   public void setMadeInDetroit(boolean madeInDetroit)
   {
      this.madeInDetroit = madeInDetroit;
     
   }
   
   public void setMadeInUnionShop(boolean madeInUnionShop)
   {
      this.madeInUnionShop = madeInUnionShop;
   }
   
   //toString:
   public String toString()
   {
      return "Vehicle type: " + "american car" + "\n" + super.toString() 
            + "Made In Detroit: " + getMadeInDetroit() + "\n"
            + "Made In Union Shop: " + getMadeInUnionShop() + "\n";
   }
   
   
}

//---------------------------------------
//child class foreign_car extends car
//---------------------------------------

class foreign_car extends car
{

   private String countryOfManufacturer;
   private float importDuty;
   
   //Constructor:
   public foreign_car(String name, String address, String phone, String email, boolean convertible, String color, String countryOfManufacturer, float importDuty)
   {
      super(name, address, phone, email, convertible, color);
      setCountryOfManufacturer(countryOfManufacturer);
      setImportDuty(importDuty);
     
   }
   
   //Getters:
   public String getCountryOfManufacturer()
   {
      return countryOfManufacturer;
     
   }
   
   public float getImportDuty()
   {
      return importDuty;
   }
   
   //Setters:
   public void setCountryOfManufacturer(String countryOfManufacturer)
   {
      this.countryOfManufacturer = countryOfManufacturer;
   }
   
   public void setImportDuty(float importDuty)
   {
      this.importDuty = importDuty;
   }
   
   //toString:
   
   public String toString()
   {
      return "Vehicle type: " + "foreign car" + "\n" + super.toString() +
         "Country Of Manufacturer: " + getCountryOfManufacturer() + "\n" +
         "Import Duty: " + getImportDuty() + "\n";
   }
   
}


//------------------------------------------
//child class bicycle extends vehicle
//------------------------------------------

class bicycle extends vehicle
{
  private int numberOfSpeeds;
  
  //Constructor:
  
  public bicycle(String name, String address, String phone, String email, int numberOfSpeeds)
  {
    super(name, address, phone, email);
    setNumberOfSpeeds(numberOfSpeeds);
  }
  
  //Getters:
  public int getNumberOfSpeeds()
  {
    return numberOfSpeeds;
  }
  
  //Setters:
  public void setNumberOfSpeeds(int numberOfSpeeds)
  {
  
    this.numberOfSpeeds = numberOfSpeeds;
  }
  
  //toString:
  public String toString()
  {
    return "Vehicle Type: " + "bicycle" + "\n" + super.toString() +
    "Number Of Speeds: " + getNumberOfSpeeds() + "\n";
  }
  
  
}

//----------------------------------------
//child class truck extends vehicle
//----------------------------------------

class truck extends vehicle
{
  private float numberOfTons;
  private float costOfTruck;
  private String datePurchased;
  
  public truck(String name, String address, String phone, String email, float numberOfTons, float costOfTruck, String datePurchased)
  {
    super(name, address, phone, email);
    setNumberOfTons(numberOfTons);
    setCostOfTruck(costOfTruck);
    setDatePurchased(datePurchased);
  }
  
  //Getters:
  public float getNumberOfTons()
  {
     return numberOfTons;
  }
  
  public float getCostOfTruck()
  {
    return costOfTruck;
  }
  
  public String getDatePurchased()
  {
    return datePurchased;
  }
  
  //Setters:
  public void setNumberOfTons(float numberOfTons)
  {
    this.numberOfTons = numberOfTons;
    
  }
  
  public void setCostOfTruck(float costOfTruck)
  {
    this.costOfTruck = costOfTruck;
  }
  
  public void setDatePurchased(String datePurchased)
  {
    this.datePurchased = datePurchased;
  }
  
  //toString:
  public String toString()
  {
    return "Vehicle Type: " + "truck" + "\n" + super.toString() +
    "Number Of Tons: " + getNumberOfTons() + "\n" + 
    "Cost Of Truck: " + getCostOfTruck() + "\n" + 
    "Date Purchased: " + getDatePurchased() + "\n";
  }

}