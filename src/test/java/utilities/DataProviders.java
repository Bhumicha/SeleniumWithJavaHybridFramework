package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider (name = "LoginData")
    public String [][] getData() throws IOException, InterruptedException {
        String path=".//testData//LoginData.xlsx";
        ExcelUtility xlUtil=new ExcelUtility(path);

        int totalRows= ExcelUtility.getRowCount("Sheet1");
        int totalCols= ExcelUtility.getCellCount("Sheet1", 1);

        String[][] loginData =new String[totalRows][totalCols];
        for(int i=1; i<=totalRows; i++)
        {
            for (int j=0; j<totalCols; j++)
            {
                loginData[i-1][j]= ExcelUtility.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }
}
