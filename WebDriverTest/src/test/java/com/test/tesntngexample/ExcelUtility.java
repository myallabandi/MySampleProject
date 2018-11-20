
package com.test.tesntngexample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelUtility {
	XSSFWorkbook workBook=null;
	XSSFSheet sheet=null;
	XSSFCell cell=null;
	XSSFRow row=null;
	UserDataObject userData=null;
	FileInputStream fileInput=null;
	
	public List<Object> getTestDataFromExcel(){
		List<Object> dataList=new ArrayList<Object>();
		try{
		fileInput=new FileInputStream("testSheet.xlsx");
		workBook=new XSSFWorkbook(fileInput);
		sheet=workBook.getSheet("UserDataSheet");
		row=sheet.getRow(0);
		for(int j=1;j<=sheet.getLastRowNum();j++){
			userData=new UserDataObject();
			for(int i=0;i<row.getLastCellNum();i++){	
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("FirstName")){
					userData.setFirstName(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("LastName")){
					userData.setLastName(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Gender")){
					userData.setGender(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Experience")){
					userData.setYearsOfExperience((int)sheet.getRow(j).getCell(i).getNumericCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("DOB")){
					userData.setDateOfBirth(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Profission")){
					userData.setProfission(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("ToolsKnown")){
					userData.setToolsKnown(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Continent")){
					userData.setContinent(sheet.getRow(j).getCell(i).getStringCellValue());
				}else if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("KnownSeleniumCommands")){
					userData.setKnownSeleniumCommands(sheet.getRow(j).getCell(i).getStringCellValue());
				}
			}
			dataList.add(userData);
		}
		}catch(IOException e){
			Reporter.log(e.toString());
			try{
			fileInput.close();
			}catch(Exception fileException){
				fileException.printStackTrace();
			}
		}
		try{
			fileInput.close();
		}catch(Exception e){
			e.printStackTrace();
		}

		return dataList;
	}

}