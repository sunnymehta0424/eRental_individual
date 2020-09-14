package onlinelease.constants;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
private static XSSFSheet ExcelWsheet;
public static XSSFWorkbook ExcelWbook;
public static XSSFRow Row;
public static XSSFRow DummyRow;
private static XSSFCell Cell;
public static int colIndex;
public static Integer rowindex;

public static void createExcelFile(String filepath,String sheetName)
{
	try{
	ExcelWbook = new XSSFWorkbook();
	ExcelWsheet = ExcelWbook.createSheet(sheetName);
	FileOutputStream outputStream = new FileOutputStream(filepath);
	ExcelWbook.write(outputStream);
	outputStream.close();
	}catch(Exception e){}
}

public static void setExcelFile(String filepath, String sheetName)
{
	try{
		FileInputStream ExcelFile = new FileInputStream(filepath);
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWsheet = ExcelWbook.getSheet(sheetName);
		
	}catch(Exception e){
	}
} 

public static void CreateSheet(String sheetName)
{
	try{
		ExcelWsheet = ExcelWbook.createSheet(sheetName);
		}catch(Exception e){
		}
}
public static int IncreaseColumn(String sheetName)
{
	int ilastclmn=0;
	try{
		int row=ExcelUtils.getRowCount(sheetName);
		ilastclmn= ExcelUtils.getlastcolumn(row, sheetName);
		ilastclmn=ilastclmn+1;
	}catch(Exception e){
	}
	return ilastclmn;
}

public static String getCellData(int RowNum , int ColNum)
{
	String CellData="";
	try{
		// ExcelWsheet = ExcelWbook.getSheet(sheetName);
		Cell = ExcelWsheet.getRow(RowNum).getCell(ColNum);
		int cellFormat=Cell.getCellType();
		if(cellFormat==XSSFCell.CELL_TYPE_STRING)
		{	
        CellData = Cell.getStringCellValue();
        return CellData;
		}
		if(cellFormat==XSSFCell.CELL_TYPE_NUMERIC)
		{	
        Double cellVal =Cell.getNumericCellValue();
        int cellVal2=cellVal.intValue();
        CellData=Integer.toString(cellVal2);
        return CellData;
		}
		return CellData;
	 	}
	catch (Exception e)
	{
         return"";
    }
}
public static String getCellData1(int RowNum , int ColNum , String sheetName) throws Exception
{
	try{
		ExcelWsheet = ExcelWbook.getSheet(sheetName);
		Cell = ExcelWsheet.getRow(RowNum).getCell(ColNum);
        String CellData = Cell.getStringCellValue();
        return CellData;
		}catch (Exception e){
			return"";
		}
}

public static void setCellData(String path, String result,int RowNum,int ColNum, String sheetName)
{
	try{
	FileInputStream fis = new FileInputStream(path);
	ExcelWsheet = ExcelWbook.getSheet(sheetName);
	Row = ExcelWsheet.getRow(RowNum);
	if(Row==null)
	{
		Row = ExcelWsheet.createRow(RowNum);
	}
	Cell = Row.getCell(ColNum);
	if(Cell==null){
		Cell= Row.createCell(ColNum);
		//Cell.setCellType(Cell.CELL_TYPE_STRING);
		Cell.setCellValue(result);
	}
	else
	{
		Cell.setCellValue(result);
	}
	fis.close();
	FileOutputStream fileOut = new FileOutputStream(path);
	ExcelWbook.write(fileOut);
	fileOut.flush();
	fileOut.close();
	}catch(Exception e){
}
}
public static void setCellData1(String path, String result,int RowNum,int ColNum, String sheetName) throws Exception
{
	try{
	FileInputStream fis = new FileInputStream(path);
	ExcelWsheet = ExcelWbook.getSheet(sheetName);
	Row = ExcelWsheet.getRow(RowNum);
	if(Row==null)
	{
		Row = ExcelWsheet.createRow(RowNum);
	}
	Cell = Row.getCell(ColNum);
	if(Cell==null)
	{
	Cell= Row.createCell(ColNum);
	//Cell.setCellType(Cell.CELL_TYPE_STRING);
	Cell.setCellValue(result);
	}else{
		Cell.setCellValue(result);
	}
	fis.close();
	FileOutputStream fileOut = new FileOutputStream(path);
	ExcelWbook.write(fileOut);
	fileOut.flush();
	fileOut.close();
	}catch(Exception e){
	}
}
public static int getRowCount(String SheetName)
{
	int iNumber = 0;
	try {
		ExcelWsheet = ExcelWbook.getSheet(SheetName);
		//iNumber=ExcelWsheet.getLastRowNum()+1;
		iNumber=ExcelWsheet.getLastRowNum();
	} catch (Exception e){
		//Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
	}
	return iNumber;
}
public static int getlastcolumn(int ExlRowCnt , String SheetName)
{
	int iColNumber = 0;
	try {
		ExcelWsheet = ExcelWbook.getSheet(SheetName);
		iColNumber=ExcelWsheet.getRow(ExlRowCnt-1).getLastCellNum();
		} catch (Exception e){
			//Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
		}
	return iColNumber;
}

public static int getlastcolumnbyheaderrow(int rownbr , String SheetName)
{
	int iColNumber = 0;
	try {
		ExcelWsheet = ExcelWbook.getSheet(SheetName);
		iColNumber=ExcelWsheet.getRow(rownbr).getLastCellNum();
		} catch (Exception e){
			//Log.error("Class Utils | Method getRowCount | Exception desc : "+e.getMessage());
		}
	return iColNumber;
}

	
	/*
	 * public static int getcolindexbyname(String SheetName, String colname) {
	 * 
	 * try { ExcelWsheet = ExcelWbook.getSheet(SheetName); int lastcolnum =
	 * ExcelWsheet.getRow(0).getLastCellNum(); for(colIndex=0; colIndex<=lastcolnum;
	 * colIndex++) { String cellValue = ExcelUtils.getCellData(0, colIndex,
	 * SheetName); if(cellValue.equals(colname)) { break; } } } catch (Exception e){
	 * //Log.error("Class Utils | Method getRowCount | Exception desc : "+e.
	 * getMessage()); } return colIndex; }
	 * 
	 * 
	 * 
	 * public static Integer getrowindexbymethodname(String SheetName, String
	 * methodname) { try { ExcelWsheet = ExcelWbook.getSheet(SheetName); int lastrow
	 * = ExcelWsheet.getLastRowNum(); for(rowindex=0; rowindex<=lastrow; rowindex++)
	 * { String cellValue = ExcelUtils.getCellData(rowindex,
	 * ExcelWsheet.getRow(rowindex).getLastCellNum()-1, SheetName);
	 * if(cellValue.equals(methodname)) { return rowindex; } } } catch (Exception
	 * e){ //Log.error("Class Utils | Method getRowCount | Exception desc : "+e.
	 * getMessage()); } return rowindex=null; }
	 */
	 

public static void removeSheet(String sheetName, XSSFWorkbook ExcelWbook) 
{   
	try{
		for(int i=ExcelWbook.getNumberOfSheets()-1;i>=0;i--)
		{
			XSSFSheet tmpSheet =ExcelWbook.getSheetAt(i);
            if(tmpSheet.getSheetName().equals(sheetName))
            {
            ExcelWbook.removeSheetAt(i);
            }
            else
            {
            System.out.println("Sheet Name is not available in WorkBook");
            }
        }  
	}catch(Exception e){
	}
	}

public static void getColHeader(String sheetName, int rowNum, int colNum)
{
	ExcelWsheet = ExcelWbook.getSheet(sheetName);
	Header colName = ExcelWsheet.getHeader();
	String header = colName.toString();
	System.out.println(header);
}
}