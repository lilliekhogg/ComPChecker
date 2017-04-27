
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This class represents an Error and managing it.
 * @author Tom
 */
public class ErrorManager {

    java.sql.Timestamp timestamp;
    String username;
    String form;
    String description;
    
    private void saveError(Connection con) {
        java.util.Date date = new java.util.Date();
        timestamp = new java.sql.Timestamp(date.getTime());

    }
}
