package rldev.signaltable.service;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.DigitalInput;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelBuilder extends AbstractExcelView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, org.apache.poi.hssf.usermodel.HSSFWorkbook hssfWorkbook,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        APCSObject apcsObject =(APCSObject) map.get("apcsObject");
        // create a new Excel sheet
        HSSFSheet sheetDI = hssfWorkbook.createSheet("DI");
        sheetDI.setDefaultColumnWidth(50);

        HSSFSheet sheetAI = hssfWorkbook.createSheet("AI");
        sheetAI.setDefaultColumnWidth(50);

        HSSFSheet sheetDO = hssfWorkbook.createSheet("DO");
        sheetDO.setDefaultColumnWidth(50);

        HSSFSheet sheetAO = hssfWorkbook.createSheet("AO");
        sheetAO.setDefaultColumnWidth(50);

        // create style for header cells
        CellStyle style = hssfWorkbook.createCellStyle();
        Font font = hssfWorkbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(Font.COLOR_NORMAL);
        style.setFont(font);

        // create header row
        HSSFRow header = sheetDI.createRow(0);

        header.createCell(0).setCellValue("ID");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("SYMBOL");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("DESCRIPTION");
        header.getCell(2).setCellStyle(style);

        // create data rows
        int i = 1;
        for (DigitalInput digitalInput : apcsObject.getDigitalInputList()){
            HSSFRow dataRow = sheetDI.createRow(i);
            dataRow.createCell(0).setCellValue(digitalInput.getId());
            dataRow.createCell(1).setCellValue(digitalInput.getSymbol());
            dataRow.createCell(2).setCellValue(digitalInput.getDescription());
            i++;
        }
    }
}
