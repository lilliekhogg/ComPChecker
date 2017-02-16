
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
public class PCCase {
 
    String make;
    String model;
    double price;
    int height;
    int width;
    int CDepth;
    String colour;
    String motherboard;
    
    
    //sets inputs into the database
    public void setMake(String make){
        this.make = make;
    }
    
    public void setModel (String model){
        this.model = model;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public void setCDepth(int CDepth){
        this.CDepth = CDepth;
    }
    
    public void setColour(String colour){
        this.colour = colour;
    }
    
    public void setMotherboard (String motherboard){
        this.motherboard = motherboard;
    }
    
    
     public boolean savePCCase() {
        
        //saving user inputs to the database
        Connection con = DatabaseConnection.establishConnection();

        try {
//Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "PCCase");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'PCCase'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            //Inserts data in Motherboard table.
            query = "INSERT INTO PCCase values (?,?,?,?,?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setInt(2, height);
            statement.setInt(3, width);
            statement.setInt(4, CDepth);
            statement.setString(5, colour);
            statement.setString(6, motherboard);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
    
    
    
}
