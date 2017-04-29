
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lillie
 */
public class RAM {

    String make;
    String model;
    double price;
    String speed;
    int size;
    int sticks;

    /**
     * Setting the make of RAM
     *
     * @param make
     */
    public void setMake(String make) {

        this.make = make;
    }

    /**
     * Setting the model of the RAM
     *
     * @param model
     */
    public void setModel(String model) {

        this.model = model;
    }

    /**
     * Setting the price of the RAM
     *
     * @param price
     */
    public void setPrice(double price) {

        this.price = price;
    }

    /**
     * Setting the speed of the RAM
     *
     * @param speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;

    }

    /**
     * Setting the size of the RAM
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;

    }

    /**
     * Setting the number of sticks the RAM has
     *
     * @param sticks
     */
    public void setSticks(int sticks) {
        this.sticks = sticks;

    }

    /**
     * Saving the RAM to the database
     *
     * @return RAM
     */
    public boolean saveRAM() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            String query = "INSERT INTO Part (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "RAM");
            statement.execute();
            String model = this.model;
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'RAM'";

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }

            query = "INSERT INTO RAM values (?,?,?,?)";

            statement = con.prepareStatement(query);

            statement.setInt(1, partID);
            statement.setString(2, this.speed);
            statement.setInt(3, this.size);
            statement.setInt(4, this.sticks);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            return false;

        }

    }
    
    /**
     * Deletes a given RAM.
     */
    public void deleteRAM() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String query = "SELECT * FROM Part WHERE Model ='" + this.model + "' && PartType = 'RAM'";
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            
            query = "DELETE FROM RAM WHERE ID = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}
