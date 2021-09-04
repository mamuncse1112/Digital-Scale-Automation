/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RatanpurScaling;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class orclconnectoff {
    
    
    public static Connection getCon()
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mamun","123");
            return c;
        }catch(Exception e)
        {
            
        }
        
        return null;
        
    }
    
}
