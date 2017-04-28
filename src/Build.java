
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
    String username;
    String name;

    /**
     *
     * @param cpu sets CPU ID.
     */
    public void setCPU(int cpu) {
        this.CPU = cpu;
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
        this.motherboard = mobo;
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
        this.RAM = RAM;
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
        this.GPU = gpu;
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
        this.cooler = Cooler;
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
        this.PSU = psu;
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
     * @param store sets Storage ID
     */
    public void setStorage(int store) {
        this.storage = store;
    }

    /**
     *
     * @return storage ID.
     */
    public int getStorage() {
        return storage;
    }

    /**
     * This method sets the case.
     *
     * @param PCcase sets Case ID.
     */
    public void setCase(int PCcase) {
        this.PCCase = PCcase;
    }

    /**
     *
     * @return case ID.
     */
    public int getCase() {
        return PCCase;
    }

    /**
     * Sets accessory ID.
     *
     * @param access sets accessory ID.
     */
    public void setAccessory(int access) {
        this.accessory = access;
    }

    /**
     * Returns accessory ID
     *
     * @return accessory ID
     */
    public int getAccessory() {
        return accessory;
    }

    /**
     *
     * @param myName BUILD NAME
     */
    public void setName(String myName) {
        this.name = myName;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @param theUser user name
     */
    public void setUser(String theUser) {
        this.username = theUser;
    }

    /**
     *
     * @return name
     */
    public String getUser() {
        return username;
    }

    /**
     * Saves the current build object to the database.
     */
    public void SaveBuild() {

        try {
            Connection con = DatabaseConnection.establishConnection();
            //SQL query for inserting data into account table
            String query = "INSERT INTO Build (Account, Motherboard, CPU, RAM,Storage,GPU,PSU,PCCase,Cooler,Accessory,name)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)"; //Saves build into database.

            PreparedStatement statement = con.prepareStatement(query);

            //setting user inputs into sql query
            statement.setString(1, username);
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
     * Deletes a given build.
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

    public void editBuild() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            //Saves build into database.
            String query = "UPDATE Build SET Account = ?, Motherboard = ?, CPU = ?, RAM = ?, "
                    + "Storage = ?, GPU = ?, PSU = ?, PCCase = ?, Cooler = ?, "
                    + "Accessory = ?, name = ? WHERE Account = ? AND name = ?";
            PreparedStatement statement = con.prepareStatement(query);
            //statement.setString(1, this.user);
            //careful this doesnt overwrite build author.
            statement.setString(1, username);
            statement.setInt(2, motherboard);
            System.out.println("3"+motherboard);
            statement.setInt(3, CPU);
            statement.setInt(4, RAM);
            statement.setInt(5, storage);
            statement.setInt(6, GPU);
            statement.setInt(7, PSU);
            statement.setInt(8, PCCase);
            statement.setInt(9, cooler);
            statement.setInt(10, accessory);
            statement.setString(11, name);
            statement.setString(12, username);
            statement.setString(13, name);

            statement.executeUpdate();
            System.out.println("Edit saved");
            statement.close();

        } catch (SQLException err) {
            System.out.println(err.getMessage());

        }
    }

    /**
     *
     * @param theUser current username
     * @param name String build name
     * @return returns the build.
     */
    public Build loadBuild(UserAccount theUser, String theName) {
        Connection con = DatabaseConnection.establishConnection();

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT * FROM Build WHERE Account = '" + (theUser.getUsername()) + "'" + " AND name ='" + theName + "'");
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                CPU = rs.getInt("CPU");
                motherboard = rs.getInt("Motherboard");
                RAM = rs.getInt("RAM");
                GPU = rs.getInt("GPU");
                cooler = rs.getInt("Cooler");
                PSU = rs.getInt("PSU");
                storage = rs.getInt("Storage");
                PCCase = rs.getInt("PCCase");
                accessory = rs.getInt("Accessory");
                
                username = rs.getString("Account");
                name = theName;
                //name = rs.getString("name");
                return this;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return null;
    }
}
