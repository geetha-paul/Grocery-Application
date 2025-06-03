package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;

public class ExcelUtililty {

	static FileInputStream file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheetName;

	public static String getStringData(int row, int column, String sheet) throws IOException

	{
		file = new FileInputStream(Constant.excelFileForLogin);

		workbook = new XSSFWorkbook(file);
		sheetName = workbook.getSheet(sheet);
		XSSFRow r = sheetName.getRow(row);
		XSSFCell c = r.getCell(column);
		return c.getStringCellValue();

	}

	public static String getIntegerData(int a, int b, String sheet) throws IOException

	{
		file = new FileInputStream(
				"C:\\Users\\DELL\\eclipse-workspace\\Grocery-Application\\src\\test\\resources\\TestData\\excelReadLogin.xlsx");

		workbook = new XSSFWorkbook(file);
		sheetName = workbook.getSheet(sheet);
		XSSFRow r = sheetName.getRow(a);
		XSSFCell c = r.getCell(b);
		int g = (int) c.getNumericCellValue();
		return String.valueOf(g);

	}
}
