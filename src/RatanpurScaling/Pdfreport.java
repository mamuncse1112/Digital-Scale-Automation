/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RatanpurScaling;



import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



/**
 *
 * @author Admin
 */
public class Pdfreport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
    }
    
    public static void generatePdf()  throws FileNotFoundException, DocumentException {
        
        makediretory();
        
          LocalDate tdate = LocalDate.now();
        String ttdate = tdate.toString();
        
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\pdfscale\\"+ttdate+".pdf"));
        document.open();
        Font f=new Font(FontFamily.TIMES_ROMAN,10.0f,Font.ITALIC,BaseColor.RED);
        document.add(new Paragraph("MODERN STEEL MILLS LIMITED.\n 199 BAIZID BOSTAMIA \n CHITTAGONG,BANGLADESH",f));
        
        
         document.add(new Paragraph("\n\n\n"));
         
         PdfPTable table = new PdfPTable(10);
         
          table.addCell(new Phrase("Id", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

         table.addCell(new Phrase("Item Name", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

         
         table.addCell(new Phrase("Challan No", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));


             
         
       table.addCell(new Phrase("In. Date", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

        
         table.addCell(new Phrase("Out. Date", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
        table.addCell(new Phrase("Rece./Sen.", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

        table.addCell(new Phrase("VEHICLE ID", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
        table.addCell(new Phrase("Tare Weight", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

         table.addCell(new Phrase("Gross Weight", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
         table.addCell(new Phrase("Net Weight", FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
         

          document.add(table);
          
           
          
          try{
              
              Connection conn = ConnectDB.WENSDB();
              
              String sql = "SELECT * from scale_data ORDER BY ID DESC";
              
              Statement stmt = conn.createStatement();
              ResultSet rslt = stmt.executeQuery(sql);
              
              int i=0;
              while(rslt.next()){
                  
                  
                  String date1 = rslt.getTimestamp("DATE_TIME").toString();
                  String datte = date1.substring(0, 10);
                  
                  PdfPTable table1 = new PdfPTable(10);
                //  System.out.println(datte + " "+ ttdate);
                  //String tday = ;
                  if(datte.equals(ttdate)){
                 table1.addCell(new Phrase(String.valueOf(rslt.getInt("ID")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getString("ITEM_NAME")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

                 table1.addCell(new Phrase(String.valueOf(rslt.getString("CHALLAN_NO")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getTimestamp("DATE_TIME")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getDate("UPDATED_ON")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getString("NAME")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getString("CONTACT_NUMBER")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getInt("TARE_WEIGHT")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getInt("GROSS_WEIGHT")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));
                 table1.addCell(new Phrase(String.valueOf(rslt.getInt("WEIGHT")), FontFactory.getFont(FontFactory.TIMES_ITALIC, 6)));

                  document.add(table1);
                     // System.out.println("123");
                  }
                  
                  

              }
              
          }catch(Exception e){
              
           //   e.printStackTrace();
              
              
          }
        
        document.close();
        
    }
        
      public static void makediretory(){
        
         File file = new File("C:\\pdfscale");
        if (!file.exists()) {
            if (file.mkdir()) {
              //  System.out.println("Directory is created!");
            } else {
              //  System.out.println("Failed to create directory!");
            }
        }
        
    }
    
}
