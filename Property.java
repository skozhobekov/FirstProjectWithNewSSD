import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

public abstract class Property {


    private static final String PROPERTIES_FILE = "";
    public static Object CHROME_DRIVER;
    public static String PROJECT_PATH;
    public static String CHROME_DRIVER_PATH;
    public static final String BROWSERSYSNAME;
    public static final String SITE_ADDRESS;
    public static final String DEVSITE_ADDRESS;
    public static final String ADMINSIDE_ADDRESS;
    public static final String DEVADMINSITE_ADDRESS;


    static {
        PROJECT_PATH = get("C:\\Users\\User\\IdeaProjects\\FirstProjectWithNewSSD\\");
        CHROME_DRIVER_PATH = ("C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        BROWSERSYSNAME = ("webdriver.chrome.driver");
        SITE_ADDRESS = ("https://platforma-karaulov.ru");
        DEVSITE_ADDRESS = ("https://dev.platforma-karaulov.ru");
        ADMINSIDE_ADDRESS = ("platforma-karaulov.ru/admin/");
        DEVADMINSITE_ADDRESS = ("dev.platforma-karaulov.ru/admin/");
    }

    private static String get(String name) {
        Properties properties = new Properties();
        String value = null;
        try {
            properties.load(Property.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
            value = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
