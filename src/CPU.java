
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tom
 */
public class CPU {

    String make;
    String model;
    double price;
    float speed;
    int cores;
    boolean graphics;

    /**
     * Returns the make of the current object.
     *
     * @return make of the object.
     */
    public String getMake() {
        return make;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param make
     */
    public void setMake(String make) {

        this.make = make;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;

    }

    /**
     * Sets the cores attribute of the object.
     *
     * @param cores
     */
    public void setCores(int cores) {
        this.cores = cores;

    }

    /**
     * Sets the graphics attribute of the object. A true value means it has
     * integrated graphics. By default this attribute is set to true, as the
     * majority of CPUs have integrated graphics.
     *
     * @param graphics
     */
    public void setGraphics(boolean graphics) {
        this.graphics = graphics;

    }

    /**
     *Sava a CPU
     * @return a value to represent if saving has been successful. 
     */
    public boolean saveCPU() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "CPU");
            statement.execute();
            String model = this.model;
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'CPU'";

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }

            query = "INSERT INTO CPU values (?,?,?,?)";

            statement = con.prepareStatement(query);

            statement.setInt(1, partID);
            statement.setFloat(2, this.speed);
            statement.setInt(3, this.cores);
            statement.setInt(4, 1);
            statement.execute();

            return true;

        } catch (SQLException err) {
            return false;

        }

    }

    /**
     *Returns a CPU object from a given ID.
     * @param id CPU ID.
     * @return CPU object
     */
    public CPU getCPU(int id) {

        Connection con = DatabaseConnection.establishConnection();

        try {

            String query = "SELECT * FROM CPU WHERE ID ='" + id + "' JOIN Part ON PartID = CPU.'" + id + "'";
            PreparedStatement statement = con.prepareStatement(query);

            statement.executeQuery(query);
            ResultSet rs = statement.getResultSet();
            int partID = 0;
            CPU cpu = new CPU();
            while (rs.next()) {
                cpu.make = rs.getString("Make");
                cpu.model = rs.getString("Model");

            }

            statement = con.prepareStatement(query);

            statement.setInt(1, partID);
            statement.setFloat(2, this.speed);
            statement.setInt(3, this.cores);
            statement.setInt(4, 1);
            statement.execute();

            return cpu;

        } catch (SQLException err) {
            return null;

        }

    }

    /**
     *Updates a CPU.
     * @param ID ID attribute
     * @param newMake make value
     * @param newModel model value
     * @param newPrice price value
     * @param newSpeed speed value
     * @param newCores cores value
     * @param newGraphics graphics value
     */
    public void updateCPU(int ID, String newMake, String newModel, double newPrice, float newSpeed, int newCores, boolean newGraphics) {
        Connection con = DatabaseConnection.establishConnection();

        try {

            String query = "UPDATE CPU SET Speed = '" + newSpeed + "' ,Cores = '" + newCores + "' , Graphics = '" + newGraphics + "' WHERE ID ='" + ID + "'"; 
            query = "UPDATE CPU SET Speed = ?, Cores = ?, Graphics = ? WHERE ID = ?"; //What is happening here?

            PreparedStatement statement = con.prepareStatement(query);
            statement.setFloat(1, newSpeed);
            statement.setInt(2, newCores);
            statement.setBoolean(3, newGraphics);
            statement.setInt(4, ID);
            statement.executeUpdate(query);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

}
