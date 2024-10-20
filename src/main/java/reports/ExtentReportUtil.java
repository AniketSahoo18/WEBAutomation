package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import listeners.TestListener;

public final class ExtentReportUtil extends TestListener {

	private static String extentReportPath;

	public static ExtentReports getReport() {

		ExtentReports extentReport = new ExtentReports();

		String path = "D:\\Automation\\WEB\\UIReports\\";
		String reportName = "ecommerce.html";

		String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss").format(new Date());
		String folderName = "ExtentReports_" + timeStamp;

		File file = new File(path + folderName);
		file.mkdir();

		extentReportPath = path + folderName + "\\" + reportName;

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportPath);

		sparkReport.config().setDocumentTitle("Test Results");
		sparkReport.config().setReportName("UI Automation Result");
		sparkReport.config().setTheme(Theme.DARK);

		extentReport.attachReporter(sparkReport);

		return extentReport;
	}

	public static void flushReports(ExtentReports extentReport) {

		try {

			extentReport.flush();
			Desktop.getDesktop().browse(new File(extentReportPath).toURI());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
