package com.JaveReptile;

import com.JaveReptile.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ToExcel {
    public static void main(String[] args) throws IOException {
        Workbook wb = new HSSFWorkbook();
        FileOutputStream fout=new FileOutputStream("C:\\Users\\DELL\\Desktop\\test\\test.xls");
        Sheet sheet1 = wb.createSheet();
        List<Item> li = Reptile.getInfo("China");
        int rowCnt = 1;
        for(Item x:li){
            Row row = sheet1.createRow(rowCnt++);
            row.createCell(0).setCellValue(x.getTitle());
            row.createCell(1).setCellValue(x.getInfo());
            row.createCell(2).setCellValue(x.getUrl());
            System.out.println(x.toString());
        }
        wb.write(fout);
        fout.close();
    }
}
