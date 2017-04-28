
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
 * @author Lillie
 */
public class UserAccount {

    private String username;
    private String password;    //Only used for saving a user due to security reasons.
    private String fName;
    private String sName;
    private String email;
    private boolean type;          //True for admin, false for general. 

    /**
     *
     * @return returns username.
     */
    public String getUsername() {

        return username;
    }

    /**
     *
     * @param enteredUname the username from user input.
     * @param enteredPass the password from user input.
     * @return if true, login is successfully. If false login has not been
     * completed.
     */
    public boolean LogInService(String enteredUname, String enteredPass) {
        //Checks entered username and password against ones stored in database.
        Connection con = DatabaseConnection.establishConnection();
        String dbUname, dbPassword;

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT ID, Password, accountType FROM Account WHERE ID='" + enteredUname + "'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                dbUname = rs.getString("ID");
                dbPassword = rs.getString("Password");
                boolean dbType = rs.getBoolean("accountType");
                if (dbUname.equals(enteredUname) && dbPassword.equals(enteredPass)) { //Comparison check
                    setType(dbType); //Sets type of user.
                    con.close();
                    setUsername(dbUname);
                    setPassword(dbPassword);
                    return true;
                }

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }

        return false;

    }

    /**
     * checks whether password entered into GUI is equal to password stored in
     * the database.
     *
     * @param username a pass username
     * @param password a passed password
     * @return if true password is correct.
     */
    public boolean checkPassword(String username, String password) {
        // this statement establishes the connection between netbeans and the vm
        Connection con = DatabaseConnection.establishConnection();
        String user = username;
        String enteredPassword = password;
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = ("SELECT ID, Password FROM Account WHERE ID='" + user + "'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                String dbPassword = rs.getString("Password");
                if (dbPassword == enteredPassword) {
                    return true;

                } else {
                    return false;

                }

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
            return false;
        }

        return false;
    }

    /**
     * Enables user to change password in the GUI and new password is then
     * accepted through connected database.
     *
     * @param username username of user
     * @param newPassword the new password to save.
     */
    public void changePassword(String username, String newPassword) {
        Connection con = DatabaseConnection.establishConnection();
        String user = username;
        String password = newPassword;
        try {

            //SQL query - changes password where the username is equal to input, entered by user.
            String query = ("UPDATE Account SET Password '" + password + "' WHERE Username = '" + username + "' ;  ");
            PreparedStatement statement = con.prepareStatement(query);

        } catch (SQLException err) { //error message

        }

        // setting the users data entered below
    }

    /**
     * This method sets the username of the object.
     *
     * @param username the passed String username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method sets the password of the object.
     *
     * @param password sets password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param fname firstname
     */
    public void setFname(String fname) {
        this.fName = fname;
    }

    /**
     *
     * @param sname surname
     */
    public void setSname(String sname) {
        this.sName = sname;
    }

    /**
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param type represents the type of user (True = Admin, false = General
     * user)
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     *
     * @return identifies the type of user.
     */
    public boolean getType() {
        return type;
    }

    /**
     *
     * @return user's first name.
     */
    public String getFName() {
        return fName;
    }

    /**
     *
     * @return user's surname.
     */
    public String getSName() {
        return sName;
    }

    /**
     *
     * @return user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * System method. (Don't know what this does but we need it)
     *
     * @param args system arguements.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LogIn frm = new LogIn();
        frm.setVisible(true);

    }

    /**
     * checking the availability of a username in the database.
     *
     * @param username a string username
     * @return if true username is available.
     */
    public boolean usernameAvailability(String username) {
        Connection con = DatabaseConnection.establishConnection();

        try {
            int availability;
            Statement stmt = (Statement) con.createStatement();
            //checks username entered against usernames within database.
            String query = ("SELECT COUNT(*) FROM Account WHERE ID = '" + username + "'");

            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                availability = rs.getInt("COUNT(*)");
                if (availability == 1) { //username is already taken
                    return false;
                } else {
                    return true; //username is available
                }
            }

        } catch (SQLException err) {

            System.out.println(err.getMessage());
            return false;
        }
        return false;
    }

    /**
     * saves the users details into the database.
     */
    public void saveUser() {

        //connecting to the vm
        Connection con = DatabaseConnection.establishConnection();

        try {
            //SQL query for inserting data into account table
            String query = "INSERT INTO Account values (?,?,?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            //setting user inputs into sql query
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, fName);
            statement.setString(4, sName);
            statement.setString(5, email);
            statement.setBoolean(6, type);
            statement.execute();
        } catch (SQLException err) {

        }

    }

    /**
     * Promotes current user, or passed user, to admin.
     *
     * @return this value represents if the process has been completed.
     */
    public boolean promoteToAdmin() {
        Connection con = DatabaseConnection.establishConnection();

        try {

            String query = "UPDATE Account SET accountType = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setBoolean(1, this.type);
            statement.setString(2, this.username);
            statement.execute();
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

    /*
    This method deletes the user from the database.
     */

    /**
     * Deletes current UserAccount object
     */
    public void deleteUser() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            //All builds the user has created must be deleted due to referential integrity. 
            String query = "DELETE FROM Build WHERE Account = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, this.username);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        try {

            String query = "DELETE FROM Account WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, this.username);
            statement.execute();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

    /**
     * This method populates the userAccount object from a given username.
     */
    public void populateUser() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT * FROM Account WHERE ID = '" + this.username + "'";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                fName = rs.getString("Fname");
                sName = rs.getString("sName");
                email = rs.getString("Email");
                type = rs.getBoolean("accountType");
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * This method edits a users details. It uses the current object to access
     * the attributes.
     */
    public void editUser() {
        Connection con = DatabaseConnection.establishConnection();
        try {
            String query = "UPDATE Account SET fName = ?, sName = ?, Email = ?, accountType = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, this.fName);
            statement.setString(2, this.sName);
            statement.setString(3, this.email);
            statement.setBoolean(4, this.type);
            statement.setString(5, this.username);
            statement.executeUpdate();
            statement.close();
            System.out.println(fName + sName + email + type);

        } catch (SQLException err) {
            System.out.println(err.getMessage());

        }

    }

}
