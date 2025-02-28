package utility;

import constants.AppConstants;
import exceptions.InvalidExcelFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private static Logger logger = LogManager.getLogger(ExcelUtils.class);

    private ExcelUtils(){}

    public static List<Map<String, String>> readExcel(String dataSheetName){

        logger.log(Level.INFO, "Reading the Excel Sheet");
        List<Map<String,String>> data= new ArrayList<>();
        XSSFWorkbook workbook;
        try(FileInputStream fileInputStream = new FileInputStream(AppConstants.getTestdataFilePath())) {
            workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheet(dataSheetName);
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();
            Map<String, String> map;
            for(int i=1; i<=rowCount; i++){
                map = new LinkedHashMap<>();
                for (int j=0; j<columnCount; j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                 map.put(key,value);
                }
                data.add(map);
            }

        }catch (FileNotFoundException e){
           throw new InvalidExcelFileException("Excel file you trying to read is not found" , e);
        }
        catch (IOException e){
            throw new InvalidExcelFileException("Some IO Exception happened while reading the excel file", e);
        }
        return data;
    }

}
