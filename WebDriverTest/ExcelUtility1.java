package com.test.tesntngexample;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility1 {

	XSSFWorkbook workBook=null;
	XSSFSheet sheet=null;
	XSSFCell cell=null;
	XSSFRow row=null;
	UserDataObject userData=null;
	FileInputStream fileInput=null;
	public List<Map<String,String>> getTestDataFromExcel(){
		List<Map<String,String>> dataList=new ArrayList<Map<String,String>>();
		Map<String,String> dataMap=null;
		try{
		fileInput=new FileInputStream("inputtestSheet.xlsx");
		workBook=new XSSFWorkbook(fileInput);
		sheet=workBook.getSheet("Logindatasheet");
		for(int i=1;i<=sheet.getLastRowNum();i++){
			dataMap=new HashMap<String,String>();
			row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				if(row.getCell(j)!=null){
					dataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(),row.getCell(j).getStringCellValue());
				}
			}
			dataList.add(dataMap);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataList;
	}
	
	public static void main(String[] args){
		ExcelUtility1 excelRead=new ExcelUtility1();
		List<Map<String,String>> excelData=excelRead.getTestDataFromExcel();
			for(Map<String,String> dataObject:excelData){
				for(String key:dataObject.keySet()){
					if(key.toString().equalsIgnoreCase("URL")){
						System.out.println("URL:" +dataObject.get(key));
					}else if(key.toString().equalsIgnoreCase("Username")){
						System.out.println("UserName:" +dataObject.get(key));
					}else if(key.toString().equalsIgnoreCase("Password")){
						System.out.println("Password:" +dataObject.get(key));
					}
				}
			}
		}
	}
