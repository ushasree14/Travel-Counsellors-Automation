package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLUtils {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	String path;

	public XLUtils(String path) {
		this.path = path;
	}
	
	public int getRowCount(String xlsheetname) throws IOException {
		fi = new FileInputStream(path);
		System.out.println(fi);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheetname);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public int getCellCount(String xlsheetname, int rownum) throws IOException {
		fi = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheetname);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public String getCellData(String xlsheetname, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {

			data = formatter.formatCellValue(cell);

		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public void setCellData(String xlsheet, int rownum, int colnum, String data) throws IOException {
		fi = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
