
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
 * @author Luke
 */
public class Issue {

    int selectedPart, ID1, ID2;

    /**
     *
     * @param part sets selectedPart.
     */
    public void setSelectedPart(int part) {
        selectedPart = part;
    }

    /**
     *
     * @return gets selectedPart.
     */
    public int getSelectedPart() {
        return selectedPart;
    }

    /**
     *
     * @param id1 sets ID1.
     */
    public void setID1(int id1) {
        ID1 = id1;
    }

    /**
     *
     * @return gets ID1.
     */
    public int getID1() {
        return ID1;
    }

    /**
     *
     * @param id2 sets ID2.
     */
    public void setID2(int id2) {
        ID2 = id2;
    }

    /**
     *
     * @return gets ID2.
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

    public boolean compatbilityIssue(int ID1, int ID2) {
        Connection con = DatabaseConnection.establishConnection();
        boolean issue = false;
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT * From Compatibility Where (Part1 = '" + ID1 + "' && Part2 ='" + ID2 + "') OR (Part1 = '" + ID2 + "' && Part2 ='" + ID1 + "')");

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
