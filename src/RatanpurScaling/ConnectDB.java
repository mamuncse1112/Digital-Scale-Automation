
package RatanpurScaling;

/**
 *
 * @author MOSTAFA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
class ConnectDB {
     public static Connection WENSDB(){
        try{
                Class.forName("oracle.jdbc.OracleDriver");
                Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.6:1521:XE","ACCOUNTS","123");
                return conn;
	
            } catch (Exception e){
        	JOptionPane.showMessageDialog(null,e);
            } return null;
    }
    
}
