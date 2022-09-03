/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleregistration;

/**
 *
 * @author Kumar
 */
public class HeavyVehicle extends Vehicle{
    
    private int loadCapacity;

  /*  HeavyVehicle(String plateNumber, String make, String model, int parseInt, boolean equals, int parseInt0, int parseInt1, int parseInt2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

	public int getLoadCapacity() {
		return loadCapacity;
	}

	public void setLoadCapacity(int loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public HeavyVehicle(String plateNumber, String make, String model, int year, boolean isPrivate, int ownerId,
			int ownerABN) {
		super();
        }
}
