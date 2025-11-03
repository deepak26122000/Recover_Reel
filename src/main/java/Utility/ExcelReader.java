package Utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReader {
    private static Workbook wb;


    public static void loadExcel(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error in loading excel file: " + e.getMessage());
        }
    }


    public static int getLastRow(String sheet) {
        return wb.getSheet(sheet).getLastRowNum() + 1;
    }

    public static String getExcel(String sheet, int row, int col) {
        if (wb == null) {
            throw new RuntimeException("WorkBook is not loaded");
        }
        var sheet3=wb.getSheet(sheet);
        if(sheet3==null){
            throw new RuntimeException("Sheet "+sheet3+" not found");
        }
        var rowObj=sheet3.getRow(row);
        if(rowObj==null) return "";

        var cellObj=rowObj.getCell(col);
        if(cellObj==null)return "";

        return cellObj.toString().trim();
    }

    public static void writeTestData(String sheetname, int row, int col,String path) {
        try {
            Row r = wb.getSheet(sheetname).getRow(row);
            if (r == null) {
                r = wb.getSheet(sheetname).createRow(row);
            }
            Cell c = r.getCell(col);
            if (c == null) {
                c = r.createCell(col);
            }
            c.setCellValue("used");

            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Unable to write: " + e.getMessage());
        }
    }


}