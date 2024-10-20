package apiTests;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import apiResources.APIResources;
import apiResources.DBConnection;
import apiResources.TestDataBuild;
import coreUtil.PropertyUtil;
import coreUtil.ValidationUtil;
import io.restassured.specification.RequestSpecification;
import pojoResponse.AddBookResponse;
import requestSpecification.RequestSpec;
import testbase.TestBase;

@Listeners(listeners.TestListener.class)

@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryAPITest extends TestBase {

	RequestSpecification res;
	AddBookResponse response;

	RequestSpec reqSpec = new RequestSpec();

	@DataProvider(name = "libraryAPIData")

	public Object[] libraryAPI() {

		List<Object> data = DBConnection.getDBDataLibrary();

		return new Object[] { data };
	}

	@Test(dataProvider = "libraryAPIData")

	public void test_Message(List<Object> list) throws IOException {

		try {

			res = given().spec(reqSpec.libraryRequestSpecification()).body(TestDataBuild.addBookPayLoad());

			APIResources resourceAPI = APIResources.valueOf("AddBookAPI");

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);

			String mssg = response.getMsg();

			ValidationUtil.validationInfo("Message Validation");

			ValidationUtil.validationCheck("soft", mssg, list.get(0).toString(),
					"Validation : Expected Value from API and Actual Value from DB");

		}

		catch (Exception e) {

			ValidationUtil.validation(false,
					"User is not able to perform the below steps : <br>"
							+ "Validation : Expected Value from API and Actual Value from DB"

							+ "<br>Technical Error Message is as below : <br/>" + e.getMessage());
		}

	}

	@Test(dataProvider = "libraryAPIData")

	public void test_ID(List<Object> list) throws IOException {

		try {

			res = given().spec(reqSpec.libraryRequestSpecification()).body(TestDataBuild.addBookPayLoad());

			APIResources resourceAPI = APIResources.valueOf("AddBookAPI");

			if (PropertyUtil.getValue("requestType").equalsIgnoreCase("POST"))
				response = res.when().post(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("GET"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);
			else if (PropertyUtil.getValue("requestType").equalsIgnoreCase("DELETE"))
				response = res.when().get(resourceAPI.getResource()).as(AddBookResponse.class);

			String id = response.getID();

			ValidationUtil.validationInfo("ID Validation");

			ValidationUtil.validationCheck("soft", id, list.get(1).toString(),
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
