
package RatanpurScaling;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;


public class ReportOnChallanNO {
    HSSFWorkbook workbook = new HSSFWorkbook(); 
    HSSFCellStyle border= workbook.createCellStyle();
    HSSFSheet spreadsheet = workbook.createSheet("Chalan_Slip");
    HSSFCellStyle style = workbook.createCellStyle();

     
    public void reportSlip(String chno,String cnDate,String itemN,String transprt,String remarks,String add,int netw,int tare,int grs,String sender,String receiver,String dateToStr,double unitPrice,double totalPrice,String id)
    {
        String unitPrc=String.valueOf(unitPrice);
        String totalPrc=String.valueOf(totalPrice);
      //HSSFWorkbook workbook = new HSSFWorkbook(); 
      //HSSFSheet spreadsheet = workbook.createSheet("Chalan_Slip");
       spreadsheet.setDisplayGridlines(false);
       
      HSSFFont font = workbook.createFont();
      font.setFontHeightInPoints((short) 25);
      font.setFontName("IMPACT");
     // font.setItalic(true);
      font.setColor(HSSFColor.BLACK.index);

      //Set font into style
      //HSSFCellStyle style = workbook.createCellStyle();
      style.setFont(font);
      style.setAlignment(HorizontalAlignment.CENTER);
      
      HSSFCellStyle align_cen = workbook.createCellStyle();
      align_cen.setAlignment(HorizontalAlignment.CENTER);
      
       HSSFCellStyle align_right = workbook.createCellStyle();
      align_right.setAlignment(HorizontalAlignment.CENTER);
      
       HSSFFont font1 = workbook.createFont();
      font1.setFontHeightInPoints((short) 10);
      font1.setFontName("IMPACT");
     // font.setItalic(true);
      font.setColor(HSSFColor.BLACK.index);

      //Set font into style
      HSSFCellStyle style_b= workbook.createCellStyle();
      style_b.setFont(font1);
      style_b.setAlignment(HorizontalAlignment.CENTER);
      
      HSSFCellStyle border_left= workbook.createCellStyle();
       border_left.setBorderLeft(BorderStyle.DASHED);
           border_left.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      
            
    
     HSSFRow row =null;
      HSSFCell cell;
      
      
      spreadsheet.addMergedRegion( new CellRangeAddress(0, 0, 0, 5));    
      row=spreadsheet.createRow(0);
      cell = row.createCell(0);
      cell.setCellValue("Ratanpur Jute Spinners Limited.");
      cell.setCellStyle(style);
      
      spreadsheet.addMergedRegion( new CellRangeAddress(1, 1, 0, 5));    
      row=spreadsheet.createRow(1);
      cell = row.createCell(0);
      cell.setCellValue("Kalagari Barongail, Shibaloya,Manikgonj.");
      cell.setCellStyle(align_cen);
      
      spreadsheet.addMergedRegion( new CellRangeAddress(2, 2, 0, 5));    
      row=spreadsheet.createRow(2);
      cell = row.createCell(0);
      cell.setCellValue("Digital Scale Weight Shlip");
      cell.setCellStyle(style_b);
      
      //spreadsheet.addMergedRegion( new CellRangeAddress(5, 5, 0, 10));    
      
      HSSFCellStyle cell_alignt= workbook.createCellStyle();     
     cell_alignt.setAlignment(HorizontalAlignment.RIGHT);
      row=spreadsheet.createRow(5);
       cell = row.createCell(0);
      cell.setCellValue("ID:  "+id );
      cell.setCellStyle(cell_alignt);
      
      cell = row.createCell(2);
      cell.setCellValue("Print Date & Time:" );
      
       cell = row.createCell(3);
      cell.setCellValue(dateToStr);
      
      HSSFRow row7=spreadsheet.createRow(7); 
      
      for(int i=0;i<5;i++)
      {
         border.setBorderBottom(BorderStyle.DASHED);
         border.setBottomBorderColor(IndexedColors.BLACK.getIndex());
         cell = row7.createCell(i);
         cell.setCellStyle(border);
       
      }
      
      
      
      HSSFCellStyle border_rr= workbook.createCellStyle();
      border_rr.setBorderRight(BorderStyle.DASHED);
      border_rr.setRightBorderColor(IndexedColors.BLACK.getIndex());
      for(int i=8;i<=15;i++)
      { 
         
          row=spreadsheet.createRow(i); 
          cell = row.createCell(5);
          cell.setCellStyle(border_rr);
          cell = row.createCell(0);
          cell.setCellStyle(border_left);
          
          cell = row.createCell(1);
          cell.setCellStyle(border_rr);
      }
      
      
      HSSFCellStyle bor_r= workbook.createCellStyle();
      bor_r.setBorderRight(BorderStyle.DASHED);
      bor_r.setRightBorderColor(IndexedColors.BLACK.getIndex()); 

      HSSFCellStyle bor_l= workbook.createCellStyle();
      bor_l.setBorderLeft(BorderStyle.DASHED);
      bor_l.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      
      bor_l.setBorderTop(BorderStyle.DASHED);
      bor_l.setTopBorderColor(IndexedColors.BLACK.getIndex());
     
        HSSFCellStyle bor_bt= workbook.createCellStyle();
      bor_bt.setBorderTop(BorderStyle.DASHED);
      bor_bt.setTopBorderColor(IndexedColors.BLACK.getIndex());
      
     HSSFRow row8=spreadsheet.createRow(8); 
     cell = row8.createCell(0);
     cell.setCellValue("Challan No:");
     cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(0);
     
     //spreadsheet.addMergedRegion( new CellRangeAddress(8, 8, 1, 2));
      cell = row8.createCell(1);
      cell.setCellValue(chno); 
      cell.setCellStyle(bor_bt);
      spreadsheet.autoSizeColumn(1);
      
      
     cell = row8.createCell(2);
      cell.setCellValue("Challan Date:"); 
       cell.setCellStyle(bor_l);
      spreadsheet.autoSizeColumn(2);
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(8, 8, 4, 5));
      cell = row8.createCell(3);
      cell.setCellValue(cnDate);
       cell.setCellStyle(bor_bt);
      spreadsheet.autoSizeColumn(3);
      
     spreadsheet.addMergedRegion( new CellRangeAddress(8, 8, 4, 5)); 
      cell = row8.createCell(4);
      cell.setCellValue("Vehicle Name: "+transprt);
      cell.setCellStyle(bor_l);
      spreadsheet.autoSizeColumn(4);
      
     
      HSSFRow row9=spreadsheet.createRow(9); 
      HSSFCellStyle bor_lv= workbook.createCellStyle();
      bor_lv.setBorderLeft(BorderStyle.DASHED);
      bor_lv.setLeftBorderColor(IndexedColors.BLACK.getIndex());     
      cell = row9.createCell(4);
      cell.setCellStyle(bor_lv);
      
      cell = row9.createCell(0);
      cell.setCellStyle(bor_lv);
           
      cell = row9.createCell(6);
      cell.setCellStyle(bor_lv);
       
      cell = row9.createCell(2);
      cell.setCellStyle(bor_lv);
      
      //spreadsheet.addMergedRegion( new CellRangeAddress(8, 8, 7, 8));
     cell = row8.createCell(5);
//      cell.setCellValue(transprt); 
      cell.setCellStyle(bor_bt);
      //spreadsheet.autoSizeColumn(5);
    
      cell = row8.createCell(6);
      cell.setCellStyle(bor_lv);
      
HSSFRow row10=spreadsheet.createRow(10);
     cell = row10.createCell(0);
     cell.setCellValue("Item Name:");
     cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(0);  
     
     //spreadsheet.addMergedRegion( new CellRangeAddress(10, 10, 1, 2));
     cell = row10.createCell(1);
     cell.setCellValue(itemN);
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(1);
      
     cell = row10.createCell(2);
      cell.setCellStyle(bor_bt);
   
     cell = row10.createCell(2);
     cell.setCellValue("Sender:");
      cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(2); 
     
      cell = row10.createCell(3);
      cell.setCellStyle(bor_bt);
      
     //spreadsheet.addMergedRegion( new CellRangeAddress(10, 10, 4, 7));
     cell = row10.createCell(3);
     cell.setCellValue(sender); 
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(3);
     
     cell = row10.createCell(6);
      cell.setCellStyle(bor_lv);
     
     for(int i=4;i<=5;i++)
     {
      cell = row10.createCell(i);
      cell.setCellStyle(bor_bt);
     }
     
     HSSFRow row12=spreadsheet.createRow(12);
     cell = row12.createCell(0);
     cell.setCellValue("Receiver:");
      cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(0);  
     
     //spreadsheet.addMergedRegion( new CellRangeAddress(12, 12, 1, 2));
     cell = row12.createCell(1);
     cell.setCellValue(receiver); 
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(1);
     
          
     cell = row12.createCell(2);
      cell.setCellStyle(bor_bt);
     
   
     cell = row12.createCell(2);
     cell.setCellValue("Address:");
      cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(2); 
    
     //spreadsheet.addMergedRegion( new CellRangeAddress(12, 12, 4, 7));
     cell = row12.createCell(3);
     cell.setCellValue(add); 
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(3);
     
     cell = row12.createCell(6);
      cell.setCellStyle(bor_lv);
     
      for(int i=4;i<=5;i++)
     {
      cell = row12.createCell(i);
      cell.setCellStyle(bor_bt);
     }
     
     
     HSSFRow row14=spreadsheet.createRow(14);
     cell = row14.createCell(0);
     cell.setCellValue("Transport:");
      cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(0);  
     
     //spreadsheet.addMergedRegion( new CellRangeAddress(14, 14, 1, 2));
     cell = row14.createCell(1);
     cell.setCellValue(transprt); 
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(1);
          
     cell = row14.createCell(2);
      cell.setCellStyle(bor_bt);
   
     cell = row14.createCell(2);
     cell.setCellValue("Remarks:");
      cell.setCellStyle(bor_l);
     spreadsheet.autoSizeColumn(2); 
    
     //spreadsheet.addMergedRegion( new CellRangeAddress(14, 14, 4, 7));
     cell = row14.createCell(3);
     cell.setCellValue(remarks); 
     cell.setCellStyle(bor_bt);
     spreadsheet.autoSizeColumn(3);
     
     cell = row14.createCell(6);
      cell.setCellStyle(bor_lv);
     
      for(int i=4;i<=5;i++)
     {
      cell = row14.createCell(i);
      cell.setCellStyle(bor_bt);
     }
   
     
      HSSFRow row15=spreadsheet.createRow(15); 
     
      for(int i=0;i<6;i++)
      {
         border.setBorderBottom(BorderStyle.DASHED);
         border.setBottomBorderColor(IndexedColors.BLACK.getIndex());
         cell = row15.createCell(i);
         cell.setCellStyle(border);
      }

       HSSFCellStyle bor_ll= workbook.createCellStyle();
      bor_ll.setBorderLeft(BorderStyle.DASHED);
      bor_ll.setLeftBorderColor(IndexedColors.BLACK.getIndex());
      bor_ll.setBorderBottom(BorderStyle.DASHED);
      bor_ll.setBottomBorderColor(IndexedColors.BLACK.getIndex());
      
      cell = row15.createCell(0);
      cell.setCellStyle(bor_ll);
         
      cell = row15.createCell(2);
      cell.setCellStyle(bor_ll);
      
      cell = row15.createCell(6);
      cell.setCellStyle(bor_lv);
      
    
      HSSFRow row16=spreadsheet.createRow(16); 
      
       for(int i=0;i<6;i++)
      {
         border.setBorderBottom(BorderStyle.DASHED);
         border.setBottomBorderColor(IndexedColors.BLACK.getIndex());
         cell = row16.createCell(i);
         cell.setCellStyle(border);
      }
       
    
       
      
       
      HSSFCellStyle border_r= workbook.createCellStyle();
      border_r.setBorderRight(BorderStyle.DASHED);
      border_r.setRightBorderColor(IndexedColors.BLACK.getIndex());
      for(int i=17;i<=24;i++)
      { 
         
          row=spreadsheet.createRow(i); 
          cell = row.createCell(5);
          cell.setCellStyle(border_r);
          
          cell = row.createCell(0);
          cell.setCellStyle(bor_lv);
      }
      
      HSSFCellStyle cell_align= workbook.createCellStyle();     
     cell_align.setAlignment(HorizontalAlignment.RIGHT);
      
     HSSFRow row18=spreadsheet.createRow(18);
     cell = row18.createCell(1);
     cell.setCellValue("Gross Weight:");
     cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(1); 
     
     cell = row18.createCell(0);
          cell.setCellStyle(bor_lv);
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(18, 18, 2, 4));
     cell = row18.createCell(2);
     cell.setCellValue(grs); 
     spreadsheet.autoSizeColumn(2);
      
     cell = row18.createCell(3);
     cell.setCellValue("Kg.");
     spreadsheet.autoSizeColumn(5); 
     
     cell = row18.createCell(6);
     cell.setCellStyle(bor_lv);
     
     
     
     HSSFRow row19=spreadsheet.createRow(19);
     cell = row19.createCell(1);
     cell.setCellValue("Tare Weight:");
      cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(1);  
    
     cell = row19.createCell(0);
     cell.setCellStyle(bor_lv);
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(20, 20, 2, 4));
     cell = row19.createCell(2);
     cell.setCellValue(tare); 
     spreadsheet.autoSizeColumn(2);
      
     cell = row19.createCell(3);
     cell.setCellValue("Kg.");
     spreadsheet.autoSizeColumn(3); 
     
      cell = row19.createCell(6);
     cell.setCellStyle(bor_lv);
     
     
      HSSFRow row20=spreadsheet.createRow(20);
     cell = row20.createCell(1);
     cell.setCellValue("Net Weight:");
      cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(1);  
     
     cell = row20.createCell(0);
     cell.setCellStyle(bor_lv);
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(22, 22, 2, 4));
     cell = row20.createCell(2);
     cell.setCellValue(netw); 
     spreadsheet.autoSizeColumn(2);
      
     cell = row20.createCell(3);
     cell.setCellValue("Kg.");
     spreadsheet.autoSizeColumn(3); 
     
      cell = row20.createCell(6);
     cell.setCellStyle(bor_lv);
     
     
     HSSFRow row21=spreadsheet.createRow(21);
     cell = row21.createCell(1);
     cell.setCellValue("Unit Price:");
      cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(1); 
     
     cell = row21.createCell(0);
          cell.setCellStyle(bor_lv);
          
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(18, 18, 2, 4));
     cell = row21.createCell(2);
     cell.setCellValue(unitPrc); 
     cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(2);
     
     
     cell = row21.createCell(6);
     cell.setCellStyle(bor_lv);
     
     
     
     HSSFRow row22=spreadsheet.createRow(22);
     cell = row22.createCell(1);
     cell.setCellValue("Total Price:");
      cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(1); 
     
     cell = row22.createCell(0);
          cell.setCellStyle(bor_lv);
     
      //spreadsheet.addMergedRegion( new CellRangeAddress(18, 18, 2, 4));
     cell = row22.createCell(2);
     cell.setCellValue(totalPrc);
     cell.setCellStyle(cell_align);
     spreadsheet.autoSizeColumn(2);
     
     
           cell = row22.createCell(6);
     cell.setCellStyle(bor_lv);
     
        
     
      
      
       HSSFRow row24=spreadsheet.createRow(24); 
       HSSFCellStyle border_t= workbook.createCellStyle();
      for(int i=0;i<6;i++)
      {
         border_t.setBorderTop(BorderStyle.DASHED);
         border_t.setTopBorderColor(IndexedColors.BLACK.getIndex());
         cell = row24.createCell(i);
         cell.setCellStyle(border_t);
      }
      
      
       HSSFRow row27=spreadsheet.createRow(27); 
       HSSFCellStyle border_tt= workbook.createCellStyle();
    
         border_tt.setBorderTop(BorderStyle.DASHED);
         border_tt.setTopBorderColor(IndexedColors.BLACK.getIndex());
         border_tt.setAlignment(HorizontalAlignment.CENTER);
         cell = row27.createCell(2);
         cell.setCellValue("Scale Operator");
         cell.setCellStyle(border_tt);
         
//         cell = row28.createCell(3);
         //cell.setCellStyle(align_cen);
         
      spreadsheet.addMergedRegion( new CellRangeAddress(27, 27, 4, 5));   
          cell = row27.createCell(4);
         cell.setCellValue("Authorised Signature");
         cell.setCellStyle(border_tt);
         spreadsheet.autoSizeColumn(4); 
       
         cell = row27.createCell(5);
         cell.setCellStyle(border_tt);
      
      
     
      try
  {
//      }
    
       String name=System.getProperty("user.name");
     String dir="C:\\Users\\"+name+"\\Desktop\\ChallanReport.xls";
     

      FileOutputStream out = new FileOutputStream(new File(dir));
      workbook.write(out);
      out.close();

       }catch(Exception e)
      {
           JOptionPane.showMessageDialog(null, e);
       } 
    }
}
