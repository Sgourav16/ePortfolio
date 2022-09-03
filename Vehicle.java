/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleregistration;

/**
 *
 * @author Kumar
 */
public class Vehicle {
    
    private String plateNumber;
    private String make;
    private String model;
    private int year;
    private boolean isPrivate;
    private int ownerId;
    private int ownerABN;
    
    public String getPlatenumber() {
    	return plateNumber;
    }
    public void setPlatenumber(String plateNumber) {
    	this.plateNumber=plateNumber;
    }
    public String getMake() {
    	return make;
    }
    public void setMake(String make) {
    	this.make=make;
    }
    public String getmodel() {
    	return model;
    }
    public void setModel(String model) {
    	this.model=model;
    }
    public int getYear() {
    	return year;
    }
    public void setPlatenumber(int year) {
    	this.year=year;
    }
    public boolean getPrivate() {
    	return isPrivate;
    }
    public void setPrivate(boolean isPrivate) {
    	this.isPrivate=isPrivate;
    }
    public int getownerId() {
    	return ownerId;
    }
    public void setownerId(int ownerId) {
    	this.ownerId=ownerId;
    }
    public int getownerABN() {
    	return ownerABN;
    }
    public void setownerABN(int ownerABN) {
    	this.ownerABN=ownerABN;
    }
    public Vehicle(String plateNumber, String make, String model, int year, boolean isPrivate, int ownerId,
			int ownerABN) 
    {
	super();
	this.plateNumber = plateNumber;
        this.make = make;
	this.model = model;
        this.year = year;
	this.isPrivate = isPrivate;
        this.ownerId = ownerId;
	this.ownerABN = ownerABN;
    }
    public Vehicle(){
        super();
    }
}
