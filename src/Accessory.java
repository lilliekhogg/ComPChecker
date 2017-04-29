
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents an accessory. An accessory is a type of component in a
 * PC.
 *
 * @author Lillie
 */
public class Accessory {

    String make;
    String model;
    double price;
    String description;

    //setting inputs
    /**
     * Sets the attribute make.
     *
     * @param make the make of the part
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Sets the attribute model
     *
     * @param model the model of the part
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * This method sets the price attribute.
     *
     * @param price a double representing a price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method sets the description attribute.
     *
     * @param description a String representing desciption.
     */
    public void setDesc(String description) {
        this.description = description;
    }

    /**
     * This method saves a new accessory to the database.
     *
     * @return returns if the saving was successful.
     */
    public boolean saveAccessory() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            //Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Accessory");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Accessory'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            //Inserts data in Accessory table.
            query = "INSERT INTO Accessory values (?,?)";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setString(2, description);

            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
    /**
     * Deletes a given build.
     */
    public void deleteAccessory() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String model = this.model;
            String query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Accessory'";
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            
            query = "DELETE FROM Accessory WHERE ID = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

}
