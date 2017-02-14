
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
 * @author User
 */
public class Cooler {
    
    String make;
    String model;
    double price;
    int minRPM;
    int maxRPM;
    
    
    public void setMake(String make){
        this.make = make;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public void setPrice (double price){
        this.price = price;
    }
    
    public void setMinRPM (int minRPM){
        this.minRPM = minRPM;
    }
  
    public void setMaxRPM (int maxRPM){
        this.maxRPM = maxRPM;
    }
    
     public boolean saveCooler() {
        
        
        Connection con = DatabaseConnection.establishConnection();

        try {
//Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Cooler");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Cooler'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
//Inserts data in Motherboard table.
            query = "INSERT INTO Motherboard values (?,?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setInt(2, minRPM);
            statement.setInt(3, maxRPM);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
}
