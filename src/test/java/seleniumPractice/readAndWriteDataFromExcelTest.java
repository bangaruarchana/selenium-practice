package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class readAndWriteDataFromExcelTest {

	@Test /*
			 * fectching only single data from the cell
			 */
	public void fetchDataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("products");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		String data = cell.toString();
		System.out.println(data);
		System.out.println();
		System.out.println("fetched the data from the excel");

		wb.close();

	}

	@Test
	public void fecthMultipleDataFromExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("products");
		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			Row row = sh.getRow(i);
			String col1 = row.getCell(0).toString();
			String col2 = row.getCell(1).toString();
			String col3 = row.getCell(2).toString();
			System.out.println(col1 + "\t" + col2 + "\t" + col3);
		}
		wb.close();
	}

	@Test
	public void fetchMultipleDataBasedOnCondition() throws EncryptedDocumentException, IOException {
		String expectedproductId = "121";
		String data1 = "";
		String data2 = "";
		FileInputStream fis = new FileInputStream("./TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("products");
		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) {
			String data = "";

			try {
				data = sh.getRow(i).getCell(2).toString();//which data we need to check that 
				if (data.equals(expectedproductId)) {
					data1 = sh.getRow(i).getCell(1).toString();
					data2 = sh.getRow(i).getCell(2).toString();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(data1);
		System.out.println(data2);
		wb.close();
	}
	@Test 
	public void writeDataInExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("products");
		Row row = sh.createRow(4);
		Cell cell1 = row.createCell(0);
		Cell cell2 = row.createCell(1);
		Cell cell3 = row.createCell(2);

		cell1.setCellType(CellType.STRING);
		cell1.setCellValue("Redme");
		cell2.setCellType(CellType.STRING);
		cell2.setCellValue("Single camera");
		cell3.setCellType(CellType.NUMERIC);
		cell3.setCellValue("124");
		
		FileOutputStream fos=new FileOutputStream("./TestData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("data has entered in the excel");
		
	}

}
