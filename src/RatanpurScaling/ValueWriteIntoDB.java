
package RatanpurScaling;

/**
 *
 * @author MOSTAFA
 */

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

class ValueWriteIntoDB {
     public static void data(int p1,int scale_weight,String cn,String name,String con,String itemN,String trN,String remark,String add,String trw,String grs,String scale,String user,String comp_id,int netwI,double unitPrice,double totalPrice)
    {
          Connection conn = null;
       // OraclePreparedStatement pst= null;
        //OracleResultSet rs= null;
        // TODO code application logic here
       
       
        conn = ConnectDB.WENSDB(); 
        try{
            java.sql.Statement select = conn.createStatement();
         
         //ResultSet rs1=select.executeQuery("insert into INFO_TABLE(name) values('"+nm+"')");
         //ResultSet rs=select.executeQuery("select * from INFO_TABLE where NAME='" + nam + "'");
         
         //ResultSet rs1=select.executeQuery("insert into INFO_TABLE(name) values('"+strm+"')");
         ResultSet rs1=select.executeQuery("INSERT INTO SCALE_DATA(ID,SCALE_ID,WEIGHT,CHALLAN_NO,NAME,CONTACT_NUMBER,ITEM_NAME,TRANSPORT_NAME,REMARKS,ADDRESS,TARE_WEIGHT,GROSS_WEIGHT,USER_NAME,COMPANY_ID,RATE,TOTAL_AMOUNT) values('"+p1+"','"+scale+"','"+netwI+"',"
                 + "'"+cn+"','"+name+"','"+con+"','"+itemN+"','"+trN+"','"+remark+"','"+add+"','"+trw+"','"+grs+"','"+user+"','"+comp_id+"','"+unitPrice+"','"+totalPrice+"')");
//            //select table_name from user_tables; (to show all tables)//

        
} catch (Exception e){

            System.out.println(e);
}
    }
    public static void dataBackup(String scale_no,String challan_no,String weight_scale)
    {
            Connection con = null;
    
       
        con= ConnectDB.WENSDB(); 
        try{
            java.sql.Statement select = con.createStatement();
         ResultSet rs1=select.executeQuery("INSERT INTO SCALE_DATA_TEMP(SCALE_ID,CHALLAN_NO,WEIGHT) values('"+scale_no+"','"+challan_no+"','"+weight_scale+"')");
//            //select table_name from user_tables; (to show all tables)//

        
} catch (Exception e){}
        
    }
    
}
