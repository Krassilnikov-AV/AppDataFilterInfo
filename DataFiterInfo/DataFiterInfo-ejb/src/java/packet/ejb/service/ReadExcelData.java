
package packet.ejb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Класс считывающий данные файла Excel в коллекцию
 * @author Aleks
 */

public class ReadExcelData {
  /**
   * основной метод для проверки корректности работы класса 
   * после включения в веб приложение, закоментировать.
   * @param args
   * @throws IOException 
   */     
     public static void main(String[] args) throws IOException {
        
        ReadExcelData pplb = new ReadExcelData();
        pplb.extractExcelContentByColumnIndex(0);
    }    
    
      public List<String> extractExcelContentByColumnIndex(int columnIndex) {
        LinkedList<String> columndata = null;
       String fileName ="PrimerRaspisania.xlsx";
        try {
            File f = new File(fileName);
            FileInputStream ios = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(ios);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            columndata = new LinkedList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if(row.getRowNum() > 0) { //To filter column headings
                        if(cell.getColumnIndex() == columnIndex) {// To match column index
                            switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                columndata.add(cell.getNumericCellValue()+"");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                columndata.add(cell.getStringCellValue());
                                break;
                            }
                        }
                    }
                }
            }
            ios.close();
            Iterator it = columndata.iterator();
            while(it.hasNext())
            System.out.println(it.next());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columndata;
    }
}
