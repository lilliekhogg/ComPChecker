
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lillie Hogg
 */
public class Accessory {
    
    String make;
    String model;
    double price;
    String description;
   
    
    //setting inputs
    public void setMake(String make){
        this.make = make;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public void setPrice (double price){
        this.price = price;
    }
    
    public void setDesc (String description){
        this.description = description;
    }
    
    
     public boolean saveAccessory() {
        
        
        Connection con = DatabaseConnection.establishConnection();

        try {
//Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Accessory");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Accessory'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
//Inserts data in Motherboard table.
            query = "INSERT INTO Accessory values (?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setString(2, description);
 
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
    
}
