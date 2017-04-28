
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
 * @author Lillie 
 */
public class GPU {
    
    String make;
    String model;
    double price;
    String series;
    String chipset;
    int memory;
    float coreClock;
    
    /**
     * Setting make of GPU
     * @param make
     */
    public void setMake (String make){
    
        this.make = make;
    }
    
    /**
     * Setting series of GPU
     * @param series
     */
    public void setSeries (String series){
        
        this.series = series;
    }
    
    /**
     * Set chipset of GPU
     * @param chipset
     */
    public void setChipset (String chipset){
    
        this.chipset = chipset;
    }
    
    /**
     * Set GPU memory
     * @param memory
     */
    public void setMemory (int memory){
    
        this.memory = memory;
    }
    
    /**
     * set core clock of GPU
     * @param coreClock
     */
    public void setCoreClock(float coreClock){
    
        this.coreClock = coreClock;
    } 
    
    /**
     * Set the model of GPU
     * @param model
     */
    public void setModel(String model){
    
        this.model = model;
    } 
    
    /**
     * Set GPU price
     * @param price
     */
    public void setPrice(Double price){
    
        this.price = price;
    } 
    
    /**
     * Saving the GPU to the database
     * @return GPU
     */
    public boolean saveGPU() {
        //saving user inputs to the database
        Connection con = DatabaseConnection.establishConnection();

        try { //adding GPU to part table in database
            String query = "INSERT INTO Part (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "GPU");
            statement.execute();
            String model = this.model;
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'GPU'";

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            //setting entry fields into the GPU table
            query = "INSERT INTO GPU values (?,?,?,?,?)";

            statement = con.prepareStatement(query);
            //order in which is added into database
            statement.setInt(1, partID);
            statement.setString(2, this.series);
            statement.setString(3, this.chipset);
            statement.setInt(4, this.memory);
            statement.setFloat(5, this.coreClock);
            statement.execute();


            return true;

        } catch (SQLException err) {
            return false;

        }
        
    }
    
}
