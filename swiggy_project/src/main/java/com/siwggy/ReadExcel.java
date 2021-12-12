package com.siwggy;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static Object[][] loadExcel(String excelFilePath, int sheetIndex, boolean firstRowIsHeader) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
			int totalRows = sheet.getLastRowNum();

			Object[][] data;
			int rowIndex;

			if (firstRowIsHeader) {
				rowIndex = 1;
				data = new Object[totalRows][4];
			} else {
				rowIndex = 0;
				data = new Object[totalRows + 1][4];
			}

			for (; rowIndex <= totalRows; rowIndex++) {
				int objectRowIndex = rowIndex;

				if (firstRowIsHeader) {
					objectRowIndex = rowIndex - 1;
				}

				XSSFRow row = sheet.getRow(rowIndex);
				int totalCells = row.getLastCellNum();
				for (int cellIndex = 0; cellIndex < totalCells; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);

					switch (cell.getCellType()) {
					case STRING:
						data[objectRowIndex][cellIndex] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[objectRowIndex][cellIndex] = cell.getNumericCellValue();
						break;
					}
				}
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
