package constants;

public class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String CONFIGFILEPATH = System.getProperty("user.dir")
			+ "/src/main/resources/properties/config.properties";

	private static final int IMPLICITWAIT = 10;
	private static final int EXPLICITWAIT = 10;

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static int getImplicitWait() {
		return IMPLICITWAIT;
	}

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
}
