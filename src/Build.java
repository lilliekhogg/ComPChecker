
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

    int CPU;
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
     * @param cpu
     */
    public void setCPU(int cpu) {
        CPU = cpu;
    }

    /**
     *
     * @param mobo
     */
    public void setMotherboard(int mobo) {
        motherboard = mobo;
    }

    /**
     *
     * @param ram
     */
    public void setRAM(int ram) {
        RAM = RAM;
    }

    /**
     *
     * @param gpu
     */
    public void setGPU(int gpu) {
        GPU = gpu;
    }

    /**
     *
     * @param Cooler
     */
    public void setCooler(int Cooler) {
        cooler = Cooler;
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
     * @param PCcase
     */
    public void setCase(int PCcase) {
        PCCase = PCcase;
    }

    /**
     *
     * @param access
     */
    public void setAccessory(int access) {
        accessory = access;
    }

    /**
     *
     */
    public void SaveBuild() {

        try {
            Connection con = DatabaseConnection.establishConnection();
            //SQL query for inserting data into account table
            String query = "INSERT INTO Build (Account, Motherboard, CPU, RAM,Storage,GPU,PSU,PCCase,Cooler,Accessory,name)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";

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

    public Build loadBuild(UserAccount user, String name) {
        Connection con = DatabaseConnection.establishConnection();

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT * From Build WHERE Account = '" + user.getUsername() + "'" + " AND name ='" + name +"'");
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
            this.CPU = rs.getInt("CPU");
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
