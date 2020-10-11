package ru.app.doc;

import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.ejb.Local;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Класс считывающий данные столбца файла Excel в коллекцию List
 *
 * @author Aleks
 */
public class ReadExcelData {

    /**
     *
     * @param args
     * @throws IOException
     */
    // выбрать столбец для чтения данных (для проверки/тестировниая)
    final static int c = 6;

    String fileName = "PrimerRaspisania.xlsx";
    LinkedList<String> columndata = null;

    public static void main(String[] args) throws IOException, ParseException {

        ReadExcelData code = new ReadExcelData();
        code.getDataStringIntegerDate(c);

    }
// метод для получения данных даты в формате "число.месяц.год"

    public List<String> getDataStringIntegerDate(int columnIndex) throws ParseException {

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

                    if (row.getRowNum() > 0) { //фильтрация заголовков столбцов
                        if (cell.getColumnIndex() == columnIndex) {// соответствие индекса столбца
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    String date = "dd.MM.yyyy";
                                    if (DateUtil.isCellDateFormatted(cell)) {  // получение данных даты                                      
                                        SimpleDateFormat sdfDate = new SimpleDateFormat(date);
                                        columndata.add(sdfDate.format(cell.getDateCellValue()));
                                    } else { // получение целочисленных данных
                                        columndata.add((int) cell.getNumericCellValue() + "");
                                    }
                                    break;
                                case Cell.CELL_TYPE_STRING: // получение строчных данных
                                    columndata.add(cell.getStringCellValue());
                                    break;
                            }
                        }
                    }
                }
            }
            ios.close();
            Iterator it = columndata.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columndata;
    }
// метод для получения данных даты в формате "ЧАСы : минуты"
    public List<String> getDataTime(int columnIndex) throws ParseException {
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

                    if (row.getRowNum() > 0) { //фильтрация заголовков столбцов
                        if (cell.getColumnIndex() == columnIndex) {// соответствие индекса столбца
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_NUMERIC:
                                    String time = "HH:mm";
                                    if (DateUtil.isCellDateFormatted(cell)) {// получение данных времени
                                        SimpleDateFormat sdfTime = new SimpleDateFormat(time, Locale.UK);
                                        columndata.add(sdfTime.format(cell.getDateCellValue()));
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
            ios.close();
            Iterator it = columndata.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columndata;
    }
}
