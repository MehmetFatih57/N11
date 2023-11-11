package N11.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    FileInputStream fis;
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaIsmi){

        try {
            fis = new FileInputStream(dosyaYolu);
            workbook= WorkbookFactory.create(fis);
            sheet=workbook.getSheet(sayfaIsmi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Satir ve sutun sayılarını girdigimde ,O hucredeki veriyi return eder
    public String getCellData(int satir,int sutun){
        Cell cell=sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }
    //Exeldeki satır sayısını return eder
    public int rowCount(){
        return sheet.getLastRowNum();
    }
}