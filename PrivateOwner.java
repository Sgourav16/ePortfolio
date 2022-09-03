/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicleregistration;


/**
 *
 * @author Kumar
 */
public class PrivateOwner extends Owner  {
    
    private int id;
    private String dateofBirth;

    public PrivateOwner(String name, String address, String phoneNumber,int id, String dateofBirth) {
        super(name, address, phoneNumber);
        this.id = id;
	this.dateofBirth = dateofBirth; 
    }
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
	this.id = id;
    }
    public String getDateofBirth() 
    {
	return dateofBirth;
    }
    public void setDateofBirth(String dateofBirth)
    {
        this.dateofBirth = dateofBirth;
    }

    String getPhonenumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getDateofbirth() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
    

