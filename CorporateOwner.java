/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleregistration;

/**
 *
 * @author Kumar
 */
public class CorporateOwner extends Owner {
    
    private int ABN;

    public CorporateOwner(String name, String address, String phoneNumber, int ABN) 
    {
        super(name, address, phoneNumber);
        this.ABN = ABN;
    }
    public int getABN()
    {
        return ABN;
    }
    public void setABN(int ABN)
    {
       this.ABN = ABN;
    }

    String getPhonenumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
