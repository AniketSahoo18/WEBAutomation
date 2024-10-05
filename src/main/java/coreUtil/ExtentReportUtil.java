package coreUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {

	public static ExtentReports getReport() {

		ExtentReports extentReport = new ExtentReports();

		String path = "D:\\Automation\\API\\APIReports\\";
		String reportName = "api.html";

		String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss").format(new Date());
		String folderName = "ExtentReports_" + timeStamp;

		File file = new File(path + folderName);
		file.mkdir();

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(path + folderName + "\\" + reportName);

		sparkReport.config().setDocumentTitle("Test Results");
		sparkReport.config().setReportName("API Automation Result");
		sparkReport.config().setTheme(Theme.DARK);

		extentReport.attachReporter(sparkReport);

		return extentReport;
	}
}
