
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lillie
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
     * Setting the make of the Storage
     *
     * @param make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setting the model of the storage
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Setting the price of storage
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setting the storages series
     *
     * @param series
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Setting Whether Storage is HHD
     *
     * @param HHD
     */
    public void setHHD(boolean HHD) {
        this.HHD = HHD;
    }

    /**
     * Setting speed of storage
     *
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Setting storage capacity
     *
     * @param capacityGB
     */
    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    /**
     * saving the storage to the database
     *
     * @return Storage
     */
    public boolean saveStorage() {

        Connection con = DatabaseConnection.establishConnection();

        try { //inserting the Storage into part table
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
            //inserting fields into the storage table in database
            query = "INSERT INTO Storage values (?,?,?,?,?)";

            statement = con.prepareStatement(query);
            //order in which these are entered
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
    
    /**
     * Deletes a given storage.
     */
    public void deleteStorage() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String query = "SELECT * FROM Part WHERE Model ='" + this.model + "' && PartType = 'Storage'";
            PreparedStatement statement = con.prepareStatement(query);
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            
            query = "DELETE FROM Storage WHERE ID = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}
