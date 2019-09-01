package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT=50;
	 public static long IMPLICT_WAIT=40;
	 
	 public static String TEST_DATA_PATH="F:\\corejava020719\\FreeCRMTest\\"
	 		+ "src\\main\\java\\com\\crm\\qa\\testdata\\CRMPRO_TestData.xlsx";
		static Workbook book;
		static Sheet sheet;
	 
	 public void switchtoframe() {
		 driver.switchTo().frame("mainpanel");
		 
	 }
	 
	 public static Object[][] getData(String sheetname) {
			FileInputStream file = null;
			
			try {
				file= new FileInputStream(TEST_DATA_PATH);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
			try {
				book=WorkbookFactory.create(file);
			}catch(InvalidFormatException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetname);
			Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//System.out.println(sheet.getLastRowNum());
			//System.out.println(sheet.getRow(0).getLastCellNum());
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					//System.out.println(data[i][j]);
				}
				
			}
			return data;
		}
	 
	 public static void takescreenshotAtEndOfTest() throws IOException {
		 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String currentdir=System.getProperty("user.dir");
		 
		FileUtils.copyFile(srcFile, new File(currentdir+"//Screenshots//"+System.currentTimeMillis()+".png"));
	 }

	
}
