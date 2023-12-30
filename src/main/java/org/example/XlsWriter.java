package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class XlsWriter {
    public static void excelFile(List<Statistics> list, String path) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Листо_01");

        Row row = sheet.createRow(0);

        Cell cell0 = row.createCell(0);
        cell0.setCellValue("nameUniversity");

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("countUniversities");

        Cell cell2 = row.createCell(2);
        cell2.setCellValue("studyProfile");

        Cell cell3 = row.createCell(3);
        cell3.setCellValue("countStudents");

        Cell cell4 = row.createCell(4);
        cell4.setCellValue("avgGrade");

        for (Cell cell : row) {
            CellStyle style = wb.createCellStyle();
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
            cell.setCellStyle(style);

            Font font = wb.createFont();
            font.setFontName("Arial Hebrew");
            font.setFontHeightInPoints((short) 15);
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            style.setFont(font);

        }

        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }

        int num = 1;
        for (Statistics statistics : list) {
            Row row1 = sheet.createRow(num++);
            for (int column = 0; column < 5; column++) {
                Cell cell = row1.createCell(column);
                switch (column) {
                    case 0:
                        cell.setCellValue(statistics.getNameUniversity());
                        break;
                    case 1:
                        cell.setCellValue(statistics.getCountUniversities());
                        break;
                    case 2:
                        cell.setCellValue(statistics.getStudyProfile().getProfileName());
                        break;
                    case 3:
                        cell.setCellValue(statistics.getCountStudents());
                        break;
                    case 4:
                        cell.setCellValue(statistics.getAvgGrade());
                        break;
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(path)) {
            wb.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

