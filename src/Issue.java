
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *This class represents an issue between two components. 
 * @author Luke
 */
public class Issue {

    int selectedPart, ID1, ID2;

    /**
     * Sets the selected part.
     * @param part integer id aka part value
     */
    public void setSelectedPart(int part) {
        selectedPart = part;
    }

    /**
     * Get the selected part
     * @return Returns selectedPart.
     */
    public int getSelectedPart() {
        return selectedPart;
    }

    /**
     * Sets the ID of the first incompatible part.
     * @param id1 integer ID of part1.
     */
    public void setID1(int id1) {
        ID1 = id1;
    }

    /**
     * Gets the integer ID of part 1.
     * @return Returns int ID1.
     */
    public int getID1() {
        return ID1;
    }

    /**
     * Sets the ID of the second incompatible part.
     * @param id2 integer ID of part2.
     */
    public void setID2(int id2) {
        ID2 = id2;
    }

    /**
     * Gets the integer ID of part 2.
     * @return Returns int ID2.
     */
    public int getID2() {
        return ID2;
    }

    /**
     * Saves the new compatability issue to the database.
     *
     * @param ID1 first part ID
     * @param ID2 second part ID
     */
    public void saveIssue(int ID1, int ID2) {

        Connection con = DatabaseConnection.establishConnection();
        try {

            String query = "INSERT INTO Compatibility VALUES (?,?,?)";  //Inserts into database
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, ID1);
            statement.setInt(2, ID2);
            statement.setBoolean(3, false);
            statement.execute();
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 

        }

    }
/**
 * Checks if two parts work with one another.
 * @param ID1 ID of a part
 * @param ID2   ID of a part
 * @param con  database connection
 * @return a boolean to represent if the two IDs have a compatability Issue.
 */
    public boolean compatbilityIssue(int ID1, int ID2, Connection con) {
        boolean issue = false;
        try {
            
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT * From Compatibility Where (Part1 = '" + ID1 + "' && Part2 ='" + ID2 + "') OR (Part1 = '" + ID2 + "' && Part2 ='" + ID1 + "')");    //Have to use an OR as it depends on how it was saved in the database,

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                issue = true;
            }
            return issue;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return issue;
    }

}
