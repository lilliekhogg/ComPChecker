
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lillie Hogg
 */
public class Cooler {
    
    String make;
    String model;
    double price;
    int minRPM;
    int maxRPM;
    
    /**
     *Set make of cooler
     * @param make make of cooler
     */
    public void setMake(String make){
        this.make = make;
    }
    
    /**
     *Set model of cooler.
     * @param model model of cooler
     */
    public void setModel(String model){
        this.model = model;
    }
    
    /**
     *Sets price of object.
     * @param price price of cooler.
     */
    public void setPrice (double price){
        this.price = price;
    }
    
    /**
     *sets min RPM value of object. 
     * @param minRPM value of minRPM
     */
    public void setMinRPM (int minRPM){
        this.minRPM = minRPM;
    }
  
    /**
     *sets max RPM value of object.
     * @param maxRPM value of maxRPM
     */
    public void setMaxRPM (int maxRPM){
        this.maxRPM = maxRPM;
    }
    
    /**
     *Saves a cooler object to the database.
     * @return a value representing if the cooler has been saved
     */
    public boolean saveCooler() {
        //saving user inputs to the database
        
        Connection con = DatabaseConnection.establishConnection();

        try {
        //Inserts data into part table.
            String query = "INSERT INTO Part  (Price,Model,Make,PartType) VALUES (?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setDouble(1, this.price);
            statement.setString(2, this.model);
            statement.setString(3, this.make);
            statement.setString(4, "Cooler");
            statement.execute();
            String model = this.model;
            //Gets ID of inserted Item.
            query = "SELECT * FROM Part WHERE Model ='" + model + "' && PartType = 'Cooler'";
            statement.executeQuery(query);

            ResultSet rs = statement.getResultSet();
            int partID = 0;
            while (rs.next()) {
                partID = rs.getInt("PartID");
            }
            //Inserts data in Motherboard table.
            query = "INSERT INTO Cooler values (?,?,?)";
             statement = con.prepareStatement(query);
            statement.setInt(1, partID);
            statement.setInt(2, minRPM);
            statement.setInt(3, maxRPM);
            statement.execute();
            con.close();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;

        }

    }
    
}
