package Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excelreader {

	public static void main(String[] args) {
		String excelFilePath = "C:\\Users\\MAMIDIGR\\Desktop\\Editprofile.xlsx.xlsx"; // Replace with your file path
		try (FileInputStream fis = new FileInputStream(excelFilePath)) {
			Workbook workbook = null;
			if (excelFilePath.endsWith(".xlsx")) {
				workbook = new HSSFWorkbook(fis); // For .xlsx files
			} else if (excelFilePath.endsWith(".xls")) {
				workbook = new HSSFWorkbook(fis); // For .xls files
			} else {
				System.out.println("Unsupported file format.");
				return;
			}

			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t");
						break;
					case FORMULA:
						System.out.print(cell.getCellFormula() + "\t");
						break;
					default:
						System.out.print("Unknown Cell Type\t");
						break;
					}
				}
				System.out.println();
			}

			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
