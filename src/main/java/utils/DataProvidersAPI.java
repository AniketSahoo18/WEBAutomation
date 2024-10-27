package utils;

import org.testng.annotations.DataProvider;
import reports.ExcelReportUtil;

public class DataProvidersAPI {

	@DataProvider(name = "libraryAPIData")

	public Object[] libraryAPI() {

		Object[][] data = ExcelReportUtil.getTestDataMap(TestDataMapper.getAPIData(), "AddBook");

		return data;
	}

	@DataProvider(name = "placeAPIData")

	public Object[] getTestData() {

		Object[][] data = ExcelReportUtil.getTestDataMap(TestDataMapper.getAPIData(), "AddPlace");

		return data;

	}
}
