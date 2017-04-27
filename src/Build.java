
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
public class Build {

    int CPU; //These attributes represents the INT ID's of the components.
    int motherboard;
    int RAM;
    int GPU;
    int cooler;
    int PSU;
    int storage;
    int PCCase;
    int accessory;
    String user;
    String name;

    /**
     *
     * @param cpu sets CPU ID.
     */
    public void setCPU(int cpu) {
        CPU = cpu;
    }
    
    /**
     *
     * @return gets CPU ID.
     */
    public int getCPU() {
        return CPU;
    }

    /**
     *
     * @param mobo sets Motherboard ID.
     */
    public void setMotherboard(int mobo) {
        motherboard = mobo;
    }
    
    /**
     *
     * @return gets motherboard ID.
     */
    public int getMotherboard() {
        return motherboard;
    }

    /**
     *
     * @param ram sets the RAM ID.
     */
    public void setRAM(int ram) {
        RAM = RAM;
    }
    
    /**
     *
     * @return gets the RAM ID
     */
    public int getRAM() {
        return RAM;
    }

    /**
     *
     * @param gpu sets the GPU ID.
     */
    public void setGPU(int gpu) {
        GPU = gpu;
    }
    
    /**
     *
     * @return gets the GPU ID.
     */
    public int getGPU() {
        return GPU;
    }

    /**
   *
     * @param Cooler Sets the cooler ID.
     */
    public void setCooler(int Cooler) {
        cooler = Cooler;
    }
    
    /**
     *
     * @return gets the cooler ID.
     */
    public int getCooler() {
        return cooler;
    }
    
     /**
   *
     * @param psu Sets the PSU ID.
     */
    public void setPSU(int psu) {
        PSU = psu;
    }
    
    /**
     *
     * @return gets the PSU ID.
     */
    public int getPSU() {
        return PSU;
    }  

    /**
     *
     * @param store
     */
    public void setStorage(int store) {
        storage = store;
    }
    
    /**
     *
     * @return storage ID.
     */
    public int getStorage() {
        return storage;
    }

    /**
     *This method sets the case.
     * @param PCcase sets Case ID.
     */
    public void setCase(int PCcase) {
        PCCase = PCcase;
    }
    
    /**
     *
     * @return case ID.
     */
    public int getCase() {
        return PCCase;
    }

    /**
     *
     * @param access sets accessory ID.
     */
    public void setAccessory(int access) {
        accessory = access;
    }
    
    /**
     *
     * @return
     */
    public int getAccessory() {
        return accessory;
    }
    
    /**
     *
     * @param myName
     */
    public void setName(String myName) {
        name = myName;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *Saves the current build object to the database.
     */
    public void SaveBuild() {

        try {
            Connection con = DatabaseConnection.establishConnection();
            //SQL query for inserting data into account table
            String query = "INSERT INTO Build (Account, Motherboard, CPU, RAM,Storage,GPU,PSU,PCCase,Cooler,Accessory,name)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)"; //Saves build into database.

            PreparedStatement statement = con.prepareStatement(query);

            //setting user inputs into sql query
            statement.setString(1, user);
            statement.setInt(2, motherboard);
            statement.setInt(3, CPU);
            statement.setInt(4, RAM);
            statement.setInt(5, storage);
            statement.setInt(6, GPU);
            statement.setInt(7, PSU);
            statement.setInt(8, PCCase);
            statement.setInt(9, cooler);
            statement.setInt(10, accessory);
            statement.setString(11, name);
            statement.execute();
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }
    
    /**
     *Deletes a given build.
     */
    public void deleteBuild() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String query = "DELETE FROM Build WHERE name = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, this.name);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

    /**
     *
     * @param user current username
     * @return a table of user's builds.
     */
    public ResultSet findUserBuilds(UserAccount user) {

        Connection con = DatabaseConnection.establishConnection();
        ResultSet rs = null;
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT ID, name FROM Build WHERE Account='" + user.getUsername() + "'");
            stmt.executeQuery(query);
            rs = stmt.getResultSet();

            return rs;

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return rs;
    }

    /**
     *
     * @param user current username
     * @param name String build name
     * @return returns the build.
     */
    public Build loadBuild(UserAccount user, String name) {
        Connection con = DatabaseConnection.establishConnection();

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT * From Build WHERE Account = '" + user.getUsername() + "'" + " AND name ='" + name + "'");
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                this.CPU = rs.getInt("CPU");
                System.out.println(CPU);
                this.motherboard = rs.getInt("Motherboard");
                this.RAM = rs.getInt("RAM");
                this.GPU = rs.getInt("GPU");
                this.cooler = rs.getInt("Cooler");
                this.PSU = rs.getInt("PSU");
                this.storage = rs.getInt("Storage");
                this.PCCase = rs.getInt("PCCase");
                this.accessory = rs.getInt("Accessory");
                this.user = user.getUsername();
                this.name = name;
                return this;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return null;
    }
}
