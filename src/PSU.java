
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lillie
 */
public class PSU {

    String make;
    String model;
    double price;
    int wattage;
    boolean modular;

    //sets inputs into the form
    /**
     * Setting the make of the PSU
     *
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setting the model of the PSU
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setting the price of the PSU
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setting the wattage of the PSU
     *
     * @param wattage
     */
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    /**
     * Setting the PSU modular
     *
     * @param modular
     */
    public void setModular(boolean modular) {
        this.modular = modular;
    }

    /**
     * Saving the power supply to the database
     *
     * @return PSU
     */
    public boolean savePSU() {

        Connection con = DatabaseConnection.establishConnection();

        try {
            //Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "PSU");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'PSU'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            //Inserts data in Motherboard table.
            query = "INSERT INTO PSU values (?,?,?)";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setInt(2, wattage);
            statement.setBoolean(3, modular);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }

}
