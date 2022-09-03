/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleregistration;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Kumar
 */
public class VehicleRegistrationMenu {
    
    final int ENTER_OWNER = 1;
    final int ENTER_VEHICLE = 2;
    final int SEARCH_OWNER = 3;
    final int SEARCH_VEHICLE = 4;
    final int EXIT = 5;

    // TODO -- declare any further constants

    // TODO -- declare an ArrayList for Owner objects and another ArrayList for Vehicle objects
    ArrayList<Owner> OwnerArray = new ArrayList<Owner>();
   ArrayList<Vehicle> VehicleArray = new ArrayList<Vehicle>();
        
    private boolean isStringNumeric(String str)
    {
	for (int i = 0; i < str.length(); i++)
    	{
    	    if (!Character.isDigit(str.charAt(i)))
		return false;
	}

	return true;
    }
    
    
    private int getMenuItem()
    {
    
        Scanner inputMenuChoice = new Scanner(System.in);
       
        System.out.println("\nPlease select from the following");
        System.out.println(ENTER_OWNER + ". Enter owner details");
        System.out.println(ENTER_VEHICLE  + ". Enter vehicle details");
        System.out.println(SEARCH_OWNER + ". Search owner");
        System.out.println(SEARCH_VEHICLE + ". Search vehicle");
        System.out.println(EXIT + ". Exit the application");
        System.out.print("\nEnter choice==> ");

        String choice = inputMenuChoice.nextLine();

	    while (choice.equals("") || !isStringNumeric(choice))
	    {
            System.out.println("Error - Menu selection name cannot be blank and must be numeric");
	        System.out.print("Enter choice==> ");

	        choice = inputMenuChoice.nextLine();
	    }

	    return Integer.parseInt(choice);
    }
    
    
    private void processOrders()
    {
	           
        int choice = getMenuItem();
	
        while (choice != EXIT)
	    {
     	    switch (choice)
	        {
                case ENTER_OWNER:
                	enterOwnerRecord();
                    break;
		        case ENTER_VEHICLE:
			        enterVehicleRecord();
			        break;
		        case SEARCH_OWNER:
                    searchOwner();
			        break;
		        case SEARCH_VEHICLE:
			        searchVehicle();
			        break;
		        default:
			        System.out.println("ERROR choice not recognised");
            }
            
            choice = getMenuItem();
    	}
        System.out.println("--------Thankyou--------");
    }
    
         
    private void enterOwnerRecord()
    {        
        // TODO 
        Scanner input = new Scanner(System.in);
        // Get owner type
        System.out.println("\nEnter Owner Type(Private/Corporate) : ");
    	String type= input.nextLine();
    	while (type.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Owner Type(Private/Corporate) : ");
        	type= input.nextLine();
	    }
        // If the owner is private, get owner ID and date of birth. Check if a owner with that ID already exists
        String id = null;
    	String dateofBirth = null;
    	String ownerABN=null;
    	if(type.equals("Private")) {
    		System.out.println("\nEnter Owner Id : ");
    		id=input.nextLine();
    		while (id.equals("") || !isStringNumeric(id))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner Id : ");
        		id=input.nextLine();
    	    }
        	for(Owner o:OwnerArray) {
        		if(o instanceof PrivateOwner) {
        			if(((PrivateOwner) o).getId()==Integer.parseInt(id)) {
        				System.out.println("ID already exists...");
        			    return;
        		     }
        		}
        	}
        	System.out.println("\nEnter Owner's Date of Birth  : ");
        	dateofBirth=input.nextLine();
        	while (dateofBirth.equals(""))
    	    {
                System.out.println("Error - field cannot be blank");
                System.out.println("\nEnter Owner's Date of Birth  : ");
            	dateofBirth=input.nextLine();
    	    }
    	}
        else if(type.equals("Corporate")) {
    		System.out.println("\nEnter Owner ABN : ");
        	ownerABN= input.nextLine();
        	while (ownerABN.equals("") || !isStringNumeric(ownerABN))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner ABN : ");
            	ownerABN= input.nextLine();
    	    }
        	for(Owner o:OwnerArray) {
        		if(o instanceof CorporateOwner) {
        			if(((CorporateOwner) o).getABN()==Integer.parseInt(ownerABN)) {
            			System.out.println("ABN already exists...");
            			return;
            		}
        		}
        	}
    	}
    	else {
    		System.out.println("\nSorry Incorrect input");
    		return;
    	}
    	// Regradless of the owner type, get name, address and phone number
    	System.out.println("\nEnter Owner Name  : ");
    	String name=input.nextLine();
    	while (name.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Owner Name  : ");
        	name=input.nextLine();
	    }
    	System.out.println("\nEnter Owner Address  : ");
    	String address=input.nextLine();
    	while (address.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Owner Address  : ");
        	address=input.nextLine();
	    }
    	System.out.println("\nEnter Owner Phone number  : ");
    	String phoneNumber=input.nextLine();
    	while (phoneNumber.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Owner Phone number  : ");
        	phoneNumber=input.nextLine();
	    }
		// Depending on the owner type, create an object of the relevant owner class, append the object to the owner ArrayList 
        // and print the owner info in the console
    	if(type.equals("Private")) {
    		PrivateOwner p=new PrivateOwner(name,address,phoneNumber,Integer.parseInt(id),dateofBirth);
    		OwnerArray.add(p);
    		System.out.println("Name of the Owner : "+p.getName());
    		System.out.println("ID number : "+p.getId());
    		System.out.println("Adddress : "+p.getAddress());
    		System.out.println("Date of Birth : "+p.getDateofbirth());
    		System.out.println("Phone Number : "+p.getPhonenumber());
    	}
    	else {
    		CorporateOwner p=new CorporateOwner(name,address,phoneNumber,Integer.parseInt(ownerABN));
    		OwnerArray.add(p);
    		System.out.println("Name of the Owner : "+p.getName());
    		System.out.println("ABN number : "+p.getABN());
    		System.out.println("Adddress : "+p.getAddress());
    		System.out.println("Phone Number : "+p.getPhonenumber());
    	}
    }
        // If the owner is corporate, get owner ABN and check if a owner with that ABN already exists 
        // Regradless of the owner type, get name, address and phone number
        // Depending on the owner type, create an object of the relevant owner class, append the object to the owner ArrayList 
        // and print the owner info in the console   
    
    
    
    private void enterVehicleRecord()
    {
        // TODO 
    	Scanner input = new Scanner(System.in);
        // Get plate number. Check if a vehicle with that plate number already exists
    	String plateNumber=null;
    	System.out.println("\nEnter Plate Number : ");
    	plateNumber=input.nextLine();
    	while (plateNumber.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Plate Number : ");
        	plateNumber=input.nextLine();
	    }
    	for(Vehicle o:VehicleArray) {
    		if(o.getPlatenumber()==plateNumber) {
    			System.out.println("Plate Number already exists...");
    			return;
    		}
    	}
        // Get vehicle type
    	String type=null;
    	System.out.println("\nEnter Type of Vehicle(Heavy/Light) : ");
    	type=input.nextLine();
    	while (type.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Type of Vehicle(Heavy/Light) : ");
        	type=input.nextLine();
	    }
        String loadCapacity=null,numberOfseats=null;
    	// If the vehicle is heavy, get load capacity
    	if(type.equals("Heavy")){
    		System.out.println("\nEnter Load Capacity : ");
    		loadCapacity=input.nextLine();
    		while (loadCapacity.equals("") || !isStringNumeric(loadCapacity))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Load Capacity : ");
        		loadCapacity=input.nextLine();
    	    }
    	} // If the owner is light, get number of seats 
    	else if(type.equals("Light")) {
    		System.out.println("\nEnter Number of seats : ");
    		numberOfseats=input.nextLine();
    		while (numberOfseats.equals("") || !isStringNumeric(numberOfseats))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
        		System.out.println("\nEnter Number of seats : ");
        		numberOfseats=input.nextLine();
    	    }
    	}
        // Regradless of the vehicle type, get make, model, and year
    	String make=null,model=null,year=null,vehicleownerType=null;
    	System.out.println("\nEnter Make : ");
    	make=input.nextLine();
    	while (make.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Make : ");
        	make=input.nextLine();
	    }
    	System.out.println("\nEnter Model : ");
    	model=input.nextLine();
    	while (model.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Model : ");
        	model=input.nextLine();
	    }
    	System.out.println("\nEnter Year : ");
    	year=input.nextLine();
    	while (year.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Year : ");
        	year=input.nextLine();
	    }
        // Afterwards get the vehicle owner type. 
    	System.out.println("\nEnter Vehicle owner type(Private/Corporate) : ");
    	vehicleownerType=input.nextLine();
    	while (vehicleownerType.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Vehicle owner type(Private/Corporate) : ");
        	vehicleownerType=input.nextLine();
	    }
        // Get the onwer ID or ABN depending on the owner type. Check if a owner with that ID or ABN exists
    	String ownerABN=null;
    	String ownerId=null;
    	boolean isPresent=false;
    	if(vehicleownerType.equals("Private")) {
    		System.out.println("\nEnter Owner Id : ");
    		ownerId=input.nextLine();
    		while (ownerId.equals("") || !isStringNumeric(ownerId))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner Id : ");
        		ownerId=input.nextLine();
    	    }
    		for(Owner o:OwnerArray) {
    			if(o instanceof PrivateOwner) {
        		    if(((PrivateOwner) o).getId()==Integer.parseInt(ownerId)) {
        			     isPresent=true;
        		    }
    			}
        	}
    	}  
    	else if(vehicleownerType.equals("Corporate")) {
    		System.out.println("\nEnter Owner ABN : ");
    		ownerABN=input.nextLine();
    		while (ownerABN.equals("") || !isStringNumeric(ownerABN))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner ABN : ");
        		ownerABN=input.nextLine();
    	    }
    		for(Owner o:OwnerArray) {
    			if(o instanceof CorporateOwner) {
        		    if(((CorporateOwner) o).getABN()==Integer.parseInt(ownerABN)) {
        			    isPresent=true;
        		    }
    			}
        	}
    	}
    	else {
    		System.out.println("\nSorry Incorrect input");
    		return;
    	}
        // If a onwer with that ID or ABN deosn't exist, then print an error message and exit 
    	if(!isPresent) {
    		System.out.println("\nError occured....");
    		return;
    	}
        // Depending on the vehicle type, create an object of the relevant vehicle class, append the object to the vehicle ArrayList 
        // and print the owner info in the console
    	if(ownerABN==null) {
    		ownerABN="-1";
    	}
    	if(ownerId==null) {
             ownerId = "-1";
    	}
        if(type.equals("Heavy")) {
        	HeavyVehicle h;
                h = new HeavyVehicle(plateNumber,make,model,Integer.parseInt(year),vehicleownerType.equals("Private"),Integer.parseInt(ownerId),Integer.parseInt(ownerABN),Integer.parseInt(loadCapacity));
        	VehicleArray.add(h);
        	System.out.println("Plate Number of Vehicle : "+h.getPlatenumber());
    		System.out.println("Maker of Vehicle : "+h.getMake());
    		System.out.println("Model of Vehicle : "+h.getmodel());
    		System.out.println("Current Year : "+h.getYear());
    		System.out.println("Owner is Private or Not : "+h.getPrivate());
    		if(h.getownerId()!=-1)
    		     System.out.println("ID Number : "+h.getownerId());
    		if(h.getownerABN()!=-1)
    			System.out.println("ABN Number : "+h.getownerABN());
               
    		System.out.println("Load Capacity of Vehicle : "+h.getLoadCapacity());
        }
        else {
        	LightVehicle h;
                h = new LightVehicle(plateNumber,make,model,Integer.parseInt(year),vehicleownerType.equals("Private"),Integer.parseInt(ownerId),Integer.parseInt(ownerABN),Integer.parseInt(numberOfseats));
        	VehicleArray.add(h);
        	System.out.println("Plate Number of Vehicle : "+h.getPlatenumber());
    		System.out.println("Maker of Vehicle : "+h.getMake());
    		System.out.println("Model of Vehicle : "+h.getmodel());
    		System.out.println("Current Year : "+h.getYear());
    		System.out.println("Owner is Private or Not : "+h.getPrivate());
    		if(h.getownerId()!=-1)
   		         System.out.println("ID Number : "+h.getownerId());
   		    if(h.getownerABN()!=-1)
   			     System.out.println("ABN Number : "+h.getownerABN());
   		    System.out.println("Number of seats in Vehicle : "+h.getNumberofSeats());
        }
   	// TODO 
        // Get plate number. Check if a vehicle with that plate number already exists
        // Get vehicle type
        // If the vehicle is heavy, get load capacity 
        // If the owner is light, get number of seats 
        // Regradless of the vehicle type, get make, model, and year
        // Afterwards get the vehicle owner type. 
        // Get the onwer ID or ABN depending on the owner type. Check if a owner with that ID or ABN exists 
        // If a onwer with that ID or ABN deosn't exist, then print an error message and exit 
        // Depending on the vehicle type, create an object of the relevant vehicle class, append the object to the vehicle ArrayList 
        // and print the owner info in the console
        
    }
    
    
    private void searchOwner()
    {
        	// TODO
    	Scanner input = new Scanner(System.in);
        // Get owner type
    	System.out.println("\nEnter Owner Type(Private/Corporate) : ");
    	String type= input.nextLine();
    	while (type.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Owner Type(Private/Corporate) : ");
        	type= input.nextLine();
	    }
    	// If the owner is private, get owner ID and date of birth. Check if a owner with that ID already exists
    	String id = null;
    	String ownerABN=null;
    	boolean isPresent=false;
    	// Get the onwer ID or ABN depending on the type
    	// Check each element of the owner ArrayList to find a match for that owner ID or ABN   
    	// If a matching owner is found, then print the owner info in the console 
    	if(type.equals("Private")) {
    		System.out.println("\nEnter Owner Id : ");
    		id=input.nextLine();
    		while (id.equals("") || !isStringNumeric(id))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner Id : ");
        		id=input.nextLine();
    	    }
        	for(Owner o:OwnerArray) {
        		if(o instanceof PrivateOwner) {        			
        			if(((PrivateOwner) o).getId()==Integer.parseInt(id)) {
        				System.out.println("Name of the Owner : "+o.getName());
        	    		System.out.println("ID number : "+((PrivateOwner) o).getId());
        	    		System.out.println("Adddress : "+o.getAddress());
        	    		System.out.println("Date of Birth : "+((PrivateOwner) o).getDateofbirth());
        	    		System.out.println("Phone Number : "+o.getPhoneNumber());
                		isPresent=true;
            		}
        		}
        	}
    	} 
    	else if(type.equals("Corporate")) {
    		System.out.println("\nEnter Owner ABN : ");
        	ownerABN= input.nextLine();
        	while (ownerABN.equals("") || !isStringNumeric(ownerABN))
    	    {
                System.out.println("Error - field cannot be blank and must be numeric");
                System.out.println("\nEnter Owner ABN : ");
            	ownerABN= input.nextLine();
    	    }
        	for(Owner o:OwnerArray) {
        		if(o instanceof CorporateOwner) {
        			if(((CorporateOwner) o).getABN()==Integer.parseInt(ownerABN)) {
            			System.out.println("Name of the Owner : "+o.getName());
                		System.out.println("ABN number : "+((CorporateOwner) o).getABN());
                		System.out.println("Adddress : "+o.getAddress());
                		System.out.println("Phone Number : "+o.getPhoneNumber());
                		isPresent=true;
            		}
        		}
        	}
    	}
    	else {
    		System.out.println("\nSorry Incorrect input");
    		return;
    	}
    	// If there is no match, print 'No record found' and exit
    	if(!isPresent) {    		
    		System.out.println("\nNo record found");         
    	}
    
        // TODO
        // Get owner type
        // Get the onwer ID or ABN depending on the type
        // Check each element of the owner ArrayList to find a match for that owner ID or ABN   
        // If a matching owner is found, then print the owner info in the console  
        // If there is no match, print 'No record found' and exit
    }
    
    
    private void searchVehicle()
    {
        Scanner input = new Scanner(System.in);
        // Get vehicle plate number
    	String plateNumber=null;
    	System.out.println("\nEnter Plate Number : ");
    	plateNumber=input.nextLine();
    	while (plateNumber.equals(""))
	    {
            System.out.println("Error - field cannot be blank");
            System.out.println("\nEnter Plate Number : ");
        	plateNumber=input.nextLine();
	    }
    	boolean isPresent=false;
    	// Check each element of the vehicle ArrayList to find a match for that plate number   
    	for(Vehicle o:VehicleArray) {
    		// If a matching vehicle is found, then print the vehicle info in the console  
    		if(o.getPlatenumber().equals(plateNumber)) {
    			System.out.println("Plate Number of Vehicle : "+o.getPlatenumber());
        		System.out.println("Maker of Vehicle : "+o.getMake());
        		System.out.println("Model of Vehicle : "+o.getmodel());
        		System.out.println("Current Year : "+o.getYear());
        		System.out.println("Owner is Private or Not : "+o.getPrivate());
        		if(o.getownerId()!=-1)
        		     System.out.println("ID Number : "+o.getownerId());
        		if(o.getownerABN()!=-1)
        			System.out.println("ABN Number : "+o.getownerABN());
        		if(o instanceof HeavyVehicle) {
        			System.out.println("Load Capacity of Vehicle : "+((HeavyVehicle) o).getLoadCapacity());
        		}
        		else {
        			System.out.println("Number of seats in Vehicle : "+((LightVehicle) o).getNumberofSeats());
        		}
        		isPresent=true;
    		}
    	}
        // If there is no match, print 'No record found' and exit
    	if(!isPresent) {    		
    		System.out.println("\nNo record found");         
    	}
        // TODO
        // Get vehicle plate number
        // Check each element of the vehicle ArrayList to find a match for that plate number   
        // If a matching vehicle is found, then print the vehicle info in the console  
        // If there is no match, print 'No record found' and exit
		
    }
    
    
    public static void main(String[] args) {
        
        VehicleRegistrationMenu app = new VehicleRegistrationMenu();
        System.out.println("--------Welcome to TMR Application--------");
	app.processOrders();
    }
    
}
