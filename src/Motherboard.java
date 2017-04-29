
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tom
 * @author Lillie
 */
public class Motherboard {

    String make;
    String model;
    double price;
    String size;
    String socket;
    int ramSlots;
    int maxRAM;

    /**
     *Sets the make of the object
     * @param make the make 
     */
    public void setMake(String make) {

        this.make = make;
    }

    /**
     *Sets the socket of the object.
     * @param socket String type of the socket.
     */
    public void setSocket(String socket) {
        this.socket = socket;
    }

    /**
     *Sets the model of the object.
     * @param model String value of model
     */
    public void setModel(String model) {
        this.model = model;

    }

    /**
     *Sets the price of the object.
     * @param price sets the double value of price.
     */
    public void setPrice(double price) {
        this.price = price;

    }

    /**
     *Sets the size pf the object.
     * @param size the size of the object.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *Set ram slots of object.
     * @param slots an int value representing max ram slots.
     */
    public void setRamSlots(int slots) {
        this.ramSlots = slots;
    }

    /**
     *Set MAX Ram of object.
     * @param max an int value representing the maximum amout of ram.
     */
    public void setMaxRAM(int max) {
        this.maxRAM = max;
    }

    /**
     *
     * @return the motherboard from database
     */
    public boolean saveMotherboard() {
        
        
        Connection con = DatabaseConnection.establishConnection();

        try {
//Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Motherboard");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Motherboard'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
//Inserts data in Motherboard table.
            query = "INSERT INTO Motherboard values (?,?,?,?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setString(2, socket);
            statement.setString(3, size);
            statement.setInt(4, ramSlots);
            statement.setInt(5, maxRAM);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
    /**
     * Deletes a given motherboard.
     */
    public void deleteMotherboard() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String query = "SELECT * FROM Part WHERE Model ='" + this.model + "' && PartType = 'Motherboard'";
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            
            query = "DELETE FROM Motherboard WHERE ID = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

}
