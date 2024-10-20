package apiTests;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import coreUtil.PropertyUtil;
import coreUtil.ValidationUtil;
import io.restassured.specification.RequestSpecification;
import pojoResponse.AddPlaceResponse;
import reports.ExcelReportUtil;
import requestSpecification.RequestSpec;
import apiResources.APIResources;
import apiResources.DBConnection;
import apiResources.TestDataBuild;
import testbase.TestBase;
import utils.TestDataMapper;

@Listeners(listeners.TestListener.class)

public class PlaceAPITest extends TestBase {

	RequestSpecification res;
	AddPlaceResponse response;

	RequestSpec reqSpec = new RequestSpec();

	@DataProvider(name = "placeAPIData")

	public Object[] getTestData() {

		Object[][] data = ExcelReportUtil.getTestDataMap(TestDataMapper.getAPIData(), "AddPlace");

		return data;
	}

	@Test(dataProvider = "placeAPIData")

	public void test_Status(Map<String, String> mapData) throws IOException {

		try {

			res = given().spec(reqSpec.placeRequestSpecification()).body(TestDataBuild.addPlacePayLoad(mapData));

			APIResources resourceAPI = APIResources.valueOf("AddPlaceAPI");

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddPlaceResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddPlaceResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddPlaceResponse.class);

			// Data fetch from response
			String status = response.getStatus();

			// Connection to DB and fetch data
			List<Object> data = DBConnection.getDBDataMap();

			ValidationUtil.validationInfo("Status Validation");

			ValidationUtil.validationCheck("soft", status, data.get(0).toString(),
					"Validation : Expected Value from API and Actual Value from DB");

		}

		catch (Exception e) {

			ValidationUtil.validation(false,
					"User is not able to perform the below steps : <br>"
							+ "Validation : Expected Value from API and Actual Value from DB"

							+ "<br>Technical Error Message is as below : <br/>" + e.getMessage());
		}

	}

	@Test(dataProvider = "placeAPIData")

	public void test_PlaceID(Map<String, String> mapData) throws IOException {

		try {

//			CustomVariables.TESTCASE = mapData.get("TestID");
			res = given().spec(reqSpec.placeRequestSpecification()).body(TestDataBuild.addPlacePayLoad(mapData));

			APIResources resourceAPI = APIResources.valueOf("AddPlaceAPI");

//			resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddPlaceResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddPlaceResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddPlaceResponse.class);

			// Data fetch from response
			String placeID = response.getPlace_id();

			// Connection to DB and fetch data
			List<Object> data = DBConnection.getDBDataMap();

			ValidationUtil.validationInfo("Place ID Validation");

			ValidationUtil.validationCheck("soft", placeID, data.get(1).toString(),
					"Validation : Expected Value from API and Actual Value from DB");

		}

		catch (Exception e) {

			ValidationUtil.validation(false,
					"User is not able to perform the below steps : <br>"
							+ "Validation : Expected Value from API and Actual Value from DB"

							+ "<br>Technical Error Message is as below : <br/>" + e.getMessage());
		}

	}
}
