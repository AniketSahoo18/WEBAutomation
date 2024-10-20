package utils;

import java.io.IOException;
import org.testng.annotations.DataProvider;

import reports.ExcelReportUtil;

public class DataProviders {

	@DataProvider(name = "testData_Fashion", parallel = false)

	public Object[][] ecommerceFashion() throws IOException {

		Object[][] data = ExcelReportUtil.getTestDataMap(TestDataMapper.getEcommerceData(), "Fashion");

		return data;
	}

	@DataProvider(name = "testData_Electronics", parallel = false)

	public Object[][] ecommerceElectronics() throws IOException {

		Object[][] data = ExcelReportUtil.getTestDataMap(TestDataMapper.getEcommerceData(), "Electronics");

		return data;
	}

}
