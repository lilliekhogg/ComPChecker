
import java.sql.Connection;
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
public class UserAccount {

    private String username;
    private String password;
    private String fName;
    private String sName;
    private String email;
    private boolean type;          //True for admin, false for general. 

    public String getUsername() {

        return username;
    }

    public boolean LogInService(String enteredUname, String enteredPass) {
        //Checks entered username and password against ones stored in database.
        Connection con = DatabaseConnection.establishConnection();
        String dbUname, dbPassword;

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT ID , Password, accountType FROM Account";

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                dbUname = rs.getString("ID");
                dbPassword = rs.getString("Password");
                boolean dbType = rs.getBoolean("accountType");
                if (dbUname.equals(enteredUname) && dbPassword.equals(enteredPass)) { //Comparison check
                    setType(dbType); //Sets type of user.
                    con.close();
                    return true;

                }

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }

        return false;

    }

    private void setType(boolean type) {
        this.type = type;
    }

    public boolean getType() {
        return type;
    }

}
