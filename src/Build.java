
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
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
     * @param cpu Sets the CPU ID.
     */
    public void setCPU(int cpu) {
        this.CPU = cpu;
    }

    /**
     *
     * @return Returns the CPU ID.
     */
    public int getCPU() {
        return CPU;
    }

    /**
     *
     * @param mobo Sets the Motherboard ID.
     */
    public void setMotherboard(int mobo) {
        this.motherboard = mobo;
    }

    /**
     *
     * @return Gets the motherboard ID.
     */
    public int getMotherboard() {
        return motherboard;
    }

    /**
     *
     * @param ram Sets the RAM ID.
     */
    public void setRAM(int ram) {
        this.RAM = RAM;
    }

    /**
     *
     * @return Gets the RAM ID
     */
    public int getRAM() {
        return RAM;
    }

    /**
     *
     * @param gpu Sets the GPU ID.
     */
    public void setGPU(int gpu) {
        this.GPU = gpu;
    }

    /**
     *
     * @return Gets the GPU ID.
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
     * @return Gets the cooler ID.
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
     * @return Gets the PSU ID.
     */
    public int getPSU() {
        return PSU;
    }

    /**
     *
     * @param store Sets the storage ID
     */
    public void setStorage(int store) {
        this.storage = store;
    }

    /**
     *
     * @return Returns the storage ID.
     */
    public int getStorage() {
        return storage;
    }

    /**
     * @param PCcase sets Case ID.
     */
    public void setCase(int PCcase) {
        this.PCCase = PCcase;
    }

    /**
     *
     * @return Returns the case ID.
     */
    public int getCase() {
        return PCCase;
    }

    /**
     * @param access Sets the accessory ID.
     */
    public void setAccessory(int access) {
        this.accessory = access;
    }

    /**
     * @return Returns the accessory ID
     */
    public int getAccessory() {
        return accessory;
    }

    /**
     *
     * @param myName Sets the build name.
     */
    public void setName(String myName) {
        this.name = myName;
    }

    /**
     *
     * @return Returns the build name.
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @param theUser Sets the username.
     */
    public void setUser(String theUser) {
        this.username = theUser;
    }

    /**
     *
     * @return Returns the username.
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
     * Finds a user's builds.
     * @param user current user.
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
     * Edits a user's build and updates the database.
     */
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
     * @param theUser current user.
     * @param theName the user of the build to load.
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
