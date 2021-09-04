/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RatanpurScaling;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ValueWriteOnOfline {
    
    public static int p1=0;
    
     public static void data(int id_of,int scale_weight,String cn,String name,String con,String itemN,String trN,String remark,String add,String trw,String grs,String scale,String user,String comp_id,int netwI,double unitPrice,double totalPrice,String identify)
    {
          Connection conn = null;
       // OraclePreparedStatement pst= null;
        //OracleResultSet rs= null;
        // TODO code application logic here
     //   System.out.println(p1);
       
       
        conn = orclconnectoff.getCon(); 
        try{
            java.sql.Statement select = conn.createStatement();
           // System.out.println("Mamun or rashid "+ id_of);
         
          ResultSet rs1=select.executeQuery("INSERT INTO SCALE_DATA(ID,SCALE_ID,WEIGHT,CHALLAN_NO,NAME,CONTACT_NUMBER,ITEM_NAME,TRANSPORT_NAME,REMARKS,ADDRESS,TARE_WEIGHT,GROSS_WEIGHT,USER_NAME,COMPANY_ID,RATE,TOTAL_AMOUNT,IDENTIFY,GLOBAL_DATA) values(  "
                  + "'"+id_of+"','"+scale+"','"+netwI+"',"
                 + "'"+cn+"','"+name+"','"+con+"','"+itemN+"','"+trN+"','"+remark+"','"+add+"','"+trw+"','"+grs+"','"+user+"','"+comp_id+"','"+unitPrice+"','"+totalPrice+"','"+identify+"','"+p1+"')");

        
} catch (Exception e){

            System.out.println(e);
}
    }
     
     public static void addGlobal(int p1){
         ValueWriteOnOfline.p1=p1;
         
     }
    
    
    
}
