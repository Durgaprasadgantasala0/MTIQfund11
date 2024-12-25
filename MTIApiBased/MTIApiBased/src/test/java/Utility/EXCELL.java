package Utility;


	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		public class EXCELL {
			
			public FileInputStream fis = null;
		    public XSSFWorkbook Hworkbook = null;
		    public XSSFSheet hsheet = null;
		    public XSSFRow hrow = null;
		    public XSSFCell hcell = null;
		   
		    public HSSFWorkbook workbook = null;
		    public HSSFSheet sheet = null;
		    public HSSFRow row = null;
		    public HSSFCell cell = null;
		 
		    public EXCELL(String xlFilePath) throws Exception
		    {
		        fis = new FileInputStream(xlFilePath);
		        workbook = new HSSFWorkbook(fis);
		        fis.close();
		    }
		 
		    public String getCellData(String sheetName, String colName, int rowNum)
		    {
		        try
		        {
		            int col_Num = -1;
		            sheet = workbook.getSheet(sheetName);
		           
		            row = sheet.getRow(0);
		            for(int i = 0; i < row.getLastCellNum(); i++)
		            {
		            	
		                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
		                    col_Num = i;
		            }
		 
		            row = sheet.getRow(rowNum-1);
		            cell = row.getCell(col_Num);
		 
		           if(cell.getCellTypeEnum() == CellType.STRING)
		                return cell.getStringCellValue();
		            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
		            {
		                String cellValue = String.valueOf(cell.getNumericCellValue());
		                if(HSSFDateUtil.isCellDateFormatted(cell))
		                {
		                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
		                    Date date = cell.getDateCellValue();
		                    cellValue = df.format(date);
		                }
		                return cellValue;
		            }else if(cell.getCellTypeEnum() == CellType.BLANK)
		                return "";
		            else
		                return String.valueOf(cell.getBooleanCellValue());
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		            return "row "+rowNum+" or column "+colName +" does not exist in Excel";
		        }
		    }
			
		    public int getLastRow(String sheetName)
		    {
		    	sheet = workbook.getSheet(sheetName);
		    	int lastrow= sheet.getLastRowNum();
		    
		    	return lastrow;
		    }
		    public void  setCellData(String path, String sheetName, int colName, int rowNum,String data) throws Throwable
		    {
		    	FileInputStream fis = new FileInputStream(path);
				Workbook Hworkbook = WorkbookFactory.create(fis);
				Hworkbook.getSheet(sheetName).getRow(rowNum).createCell(colName).setCellValue(data);
				FileOutputStream fos = new FileOutputStream(path);
			Hworkbook.write(fos);
		    	
		    }
		}

