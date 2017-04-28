
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
public class Storage {
    
    String make;
    String model;
    double price;
    String series;
    boolean HHD;
    int speed;
    int capacityGB;
  
    /**
     *
     * @param make
     */
    public void setMake (String make){
    this.make = make;
 }
 
    /**
     *
     * @param model
     */
    public void setModel (String model){
     this.model = model;
 }
 
    /**
     *
     * @param price
     */
    public void setPrice (double price){
     this.price = price;
 }
 
    /**
     *
     * @param series
     */
    public void setSeries (String series){
     this.series = series;
 }
 
    /**
     *
     * @param HHD
     */
    public void setHHD (boolean HHD){
     this.HHD = HHD;
 }
 
    /**
     *
     * @param speed
     */
    public void setSpeed (int speed){
     this.speed = speed;
 }
 
    /**
     *
     * @param capacityGB
     */
    public void setCapacityGB (int capacityGB){
     this.capacityGB = capacityGB;
 }
 
    /**
     *
     * @return
     */
    public boolean saveStorage() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            String query = "INSERT INTO Part (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Storage");
            statement.execute();
            String model = this.model;
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Storage'";

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }

            query = "INSERT INTO Storage values (?,?,?,?,?)";

            statement = con.prepareStatement(query);

            statement.setInt(1, partID);
            statement.setString(2, this.series);
            statement.setBoolean(3, this.HHD);
            statement.setInt(4, this.speed);
            statement.setInt(5, this.capacityGB);
            statement.execute();


            return true;

        } catch (SQLException err) {
            return false;

        }

 
 
  } 
}
