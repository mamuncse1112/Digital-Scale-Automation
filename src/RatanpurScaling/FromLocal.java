/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RatanpurScaling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class FromLocal {
    
    
    public static void data(String scale_id,String name,String con_no,String item_name,String tr_name,String remarks,String add,String com_id,int weight,int trw,int grsw,String ch_no,int rate,int total){
        try{
          Connection connect = ConnectDB.WENSDB();
           
          
          
            Connection cnt1 = ConnectDB.WENSDB();
              String sql1 = "SELECT COUNT(*) from SCALE_DATA";
              Statement stmt1= cnt1.createStatement();
              ResultSet result= stmt1.executeQuery(sql1);
              int p1=0;
              while(result.next()){
                  p1=result.getInt("COUNT(*)");
              }
                p1=p1+1;
               // System.out.println(p1);
          
          
            String sqlCom = "INSERT INTO SCALE_DATA(ID,SCALE_ID,NAME,CONTACT_NUMBER,CHALLAN_NO,ITEM_NAME,TRANSPORT_NAME,REMARKS,ADDRESS,COMPANY_ID,TARE_WEIGHT,GROSS_WEIGHT,WEIGHT,RATE,TOTAL_AMOUNT)"
                    + " values('"+p1+"',"+scale_id+"','"+name+"','"+con_no+"','"+ch_no+"','"+item_name+"','"+tr_name+"','"+remarks+"',"
                    + ",'"+add+"','"+com_id+"','"+trw+"','"+grsw+"','"+weight+"','"+rate+"','"+total+"')";
            
            Statement stmt = connect.createStatement();
            
            try{
                 stmt.executeUpdate(sqlCom);

            }catch(Exception e){
                System.out.println(e);
            }
            
        }catch(Exception e){
            
        }
    }
    
}
