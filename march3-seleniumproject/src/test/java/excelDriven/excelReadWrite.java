package excelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadWrite {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fisRead = new FileInputStream("C:\\Users\\HP\\Desktop\\ReadWrite.xlsx");
		//FileOutputStream fisWrite = new FileOutputStream("C:\\Users\\HP\\Desktop\\ReadWrite.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fisRead);
		XSSFSheet sheetName = wb.getSheet("d1");
		XSSFRow row = sheetName.getRow(0);
		XSSFCell cell = null;
		
		System.out.println(row.getLastCellNum());
		System.out.println(sheetName.getPhysicalNumberOfRows());
		System.out.println(row.getPhysicalNumberOfCells());
		
		int cellIndex=0;
		int numRows=row.getPhysicalNumberOfCells();
		int numCells=sheetName.getRow(0).getLastCellNum();
		for(int i=0;i<numRows;i++)
		{
			for(int j=0;j<numCells;j++)
			{
				System.out.println(sheetName.getRow(i).getCell(j).getStringCellValue());
				if(sheetName.getRow(i).getCell(j).getStringCellValue().trim().equals("ColName"))
						{
						
						}
				
				
			}
		}
		
		
		
		wb.close();
		fisRead.close();
		//fisWrite.close();
		
 
	}

}
