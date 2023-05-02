package excelDriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ExcelAPI ex = new ExcelAPI("C:\\Users\\HP\\Desktop\\ReadWrite.xlsx");
		int rowCount = ex.getRowCount("login");
		int colCount = ex.columnCount("login");	
		int colNumber = 0;
		double age ; 
		//String age=null;
		String colName = "Age";
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				
				//if(ex.sheet.getRow(i).getCell(j).getStringCellValue().trim().equals(colName))
				if(ex.getCellData("login","Age",i).equals(colName))
					colNumber = j;
				if(colNumber == j && i !=0)
				{//Get cell data
					//age = Integer.parseInt(ex.getCellData("login",colName,i));
					age = ex.sheet.getRow(i).getCell(j).getNumericCellValue();
					if(age <= 18)
					    ex.setCellData("login", "Age", i, "MINOR");
					else if (age > 18)
						ex.setCellData("login","Age",i,"MAJOR");
					
				}
			}
		
		}
		
		
		//Get Cell data using column Name
		//ex.getCellData(String sheetName,String colName,int rowNum)

	}

}
