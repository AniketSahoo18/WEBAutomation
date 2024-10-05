package constants;

public class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/main/resources/properties/config.properties";

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
}
