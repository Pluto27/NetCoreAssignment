/*
 * package Utility;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.FileOutputStream; import java.io.IOException;
 * 
 * import org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ExcelUtils {
 * 
 * private static XSSFSheet ExcelWSheet; private static XSSFWorkbook ExcelWBook;
 * private static XSSFCell Cell; private static XSSFRow Row;
 * 
 * public static void setExcelFile(String Path,String SheetName) throws
 * Exception { //open the excel file FileInputStream ExcelFile=new
 * FileInputStream(Path); //access the required datasheet ExcelWBook = new
 * XSSFWorkbook(ExcelFile); ExcelWSheet = ExcelWBook.getSheet(SheetName); }
 * 
 * public static void setCellData(String Result,int RowNum,int ColNum) { try {
 * Row=ExcelWSheet.getRow(RowNum); Cell= Row.getCell(ColNum); if(Cell==null) {
 * Cell=Row.createCell(ColNum); Cell.setCellValue(Result); } else {
 * Cell.setCellValue(Result); }
 * 
 * // Constant variables Test Data path and Test Data file name FileOutputStream
 * fileOut=new FileOutputStream(Constant.Path_TestData+Constant.File_TestData);
 * ExcelWBook.write(fileOut); fileOut.flush(); fileOut.close(); } catch
 * (FileNotFoundException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); } }
 * 
 * }
 */