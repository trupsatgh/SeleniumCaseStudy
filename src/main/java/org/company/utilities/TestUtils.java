package org.company.utilities;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {

    public static Workbook book;
    static Sheet sheet;
    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") +
            "/testdata/SaleoforceTestData.xlsx";

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file;

        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0)
                .getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }

    public static void takeScreenShot(WebDriver driver) throws IOException {
        //1. Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //2.Call getScreenshotAs method to create image file

        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //3.Move image file to new destination
        // get fileWithPath
        Date currentDate = new Date();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
        String fileSeparator = System.getProperty("file.separator");
        String reportFilepath = System.getProperty("user.dir") + fileSeparator + "Screenshots";
        String reportFileName = "ScreenShot_" + timestamp + ".png";
        String fileWithPath = reportFilepath + fileSeparator + reportFileName;

        File destFile = new File(fileWithPath);

        //4.Copy file at destination
        FileUtils.copyFile(srcFile, destFile);
    }
}



